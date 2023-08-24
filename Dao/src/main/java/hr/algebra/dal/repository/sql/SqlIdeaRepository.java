package hr.algebra.dal.repository.sql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import hr.algebra.dal.repository.IdeaRepository;
import hr.algebra.model.Idea;
import hr.algebra.model.Market;
import hr.algebra.model.Symbol;

public class SqlIdeaRepository implements IdeaRepository {

  private static final String ID = "Id";
  private static final String TITLE = "Title";
  private static final String LINK = "Link";
  private static final String DESCRIPTION = "Description";
  private static final String PICTURE_PATH = "PicturePath";
  private static final String PUBLISHED_DATE = "PublishedDate";
  private static final String SYMBOL_ID = "SymbolId";
  private static final String SYMBOL_NAME = "SymbolName";
  private static final String SYMBOL_DESCRIPTION = "SymbolDescription";
  private static final String SYMBOL_LINK = "SymbolLink";
  private static final String MARKET_ID = "MarketId";
  private static final String MARKET_NAME = "MarketName";
  private static final String MARKET_IS_SELECTED = "MarketIsSelected";

  private static final String CREATE_IDEA = "{ CALL CreateIdea (?,?,?,?,?,?,?,?) }";
  private static final String UPDATE_IDEA = "{ CALL UpdateIdea (?,?,?,?,?,?,?,?) }";
  private static final String DELETE_IDEA = "{ CALL DeleteIdea (?) }";
  private static final String SELECT_IDEA = "{ CALL SelectIdea (?) }";
  private static final String SELECT_IDEA_BY_LINK = "{ CALL SelectIdeaByLink (?) }";
  private static final String SELECT_IDEAS = "{ CALL SelectIdeas }";

  @Override
  public int createIdea(Idea idea) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_IDEA)) {
      stmt.setString(TITLE, idea.getTitle());
      stmt.setString(LINK, idea.getLink());
      stmt.setString(DESCRIPTION, idea.getDescription());
      stmt.setString(PICTURE_PATH, idea.getPicturePath());
      stmt.setString(PUBLISHED_DATE, idea.getPublishedDate().format(Idea.DATE_FORMATTER));
      stmt.setInt(SYMBOL_ID, idea.getSymbol().getId());
      stmt.setInt(MARKET_ID, idea.getMarket().getId());
      stmt.registerOutParameter(ID, Types.INTEGER);
      stmt.executeUpdate();
      return stmt.getInt(ID);
    }
  }

  @Override
  public void createIdeas(List<Idea> ideas) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_IDEA)) {
      for (Idea idea : ideas) {
        stmt.setString(TITLE, idea.getTitle());
        stmt.setString(LINK, idea.getLink());
        stmt.setString(DESCRIPTION, idea.getDescription());
        stmt.setString(PICTURE_PATH, idea.getPicturePath());
        stmt.setString(PUBLISHED_DATE, idea.getPublishedDate().format(Idea.DATE_FORMATTER));
        stmt.setInt(SYMBOL_ID, idea.getSymbol().getId());
        stmt.setInt(MARKET_ID, idea.getMarket().getId());
        stmt.registerOutParameter(ID, Types.INTEGER);
        try {
          stmt.executeUpdate();
        } catch (SQLServerException ex) {
          if (!ex.getMessage().contains("Violation of UNIQUE KEY constraint"))
            throw ex;
        }
      }
    }
  }

  @Override
  public void updateIdea(int id, Idea data) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(UPDATE_IDEA)) {
      stmt.setInt(ID, id);
      stmt.setString(TITLE, data.getTitle());
      stmt.setString(LINK, data.getLink());
      stmt.setString(DESCRIPTION, data.getDescription());
      stmt.setString(PICTURE_PATH, data.getPicturePath());
      stmt.setString(PUBLISHED_DATE, data.getPublishedDate().format(Idea.DATE_FORMATTER));
      stmt.setInt(SYMBOL_ID, data.getSymbol().getId());
      stmt.setInt(MARKET_ID, data.getMarket().getId());
      stmt.executeUpdate();
    }
  }

  @Override
  public void deleteIdea(int id) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_IDEA)) {
      stmt.setInt(ID, id);
      stmt.executeUpdate();
    }
  }

  @Override
  public Optional<Idea> selectIdea(int id) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_IDEA)) {
      stmt.setInt(ID, id);
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          return Optional.of(createIdeaFromResultSet(rs));
        }
      }
    }
    return Optional.empty();
  }

  @Override
  public Optional<Idea> selectIdeaByLink(String link) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
        CallableStatement stmt = con.prepareCall(SELECT_IDEA_BY_LINK)) {
      stmt.setString(LINK, link);
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          return Optional.of(createIdeaFromResultSet(rs));
        }
      }
    }
    return Optional.empty();
  }

  @Override
  public List<Idea> selectIdeas() throws Exception {
    List<Idea> ideas = new ArrayList<>();
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
        CallableStatement stmt = con.prepareCall(SELECT_IDEAS);
        ResultSet rs = stmt.executeQuery()) {
      while (rs.next()) {
        ideas.add(createIdeaFromResultSet(rs));
      }
    }
    return ideas;
  }

  private static Idea createIdeaFromResultSet(ResultSet rs) throws Exception {
    return new Idea(
        rs.getInt(ID),
        rs.getString(TITLE),
        rs.getString(LINK),
        rs.getString(DESCRIPTION),
        rs.getString(PICTURE_PATH),
        LocalDateTime.parse(rs.getString(PUBLISHED_DATE), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSS")),
        new Symbol(
            rs.getInt(SYMBOL_ID),
            rs.getString(SYMBOL_NAME),
            rs.getString(SYMBOL_DESCRIPTION),
            rs.getString(SYMBOL_LINK)),
        new Market(
            rs.getInt(MARKET_ID),
            rs.getString(MARKET_NAME),
            rs.getBoolean(MARKET_IS_SELECTED)));
  }
}
