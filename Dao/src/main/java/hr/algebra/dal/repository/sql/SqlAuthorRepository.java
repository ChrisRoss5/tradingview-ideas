package hr.algebra.dal.repository.sql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import hr.algebra.dal.repository.AuthorRepository;
import hr.algebra.model.Author;

public class SqlAuthorRepository implements AuthorRepository {

  private static final String ID = "Id";
  private static final String NAME = "Name";
  private static final String LINK = "Link";

  private static final String CREATE_AUTHOR = "{ CALL CreateAuthor (?,?,?) }";
  private static final String UPDATE_AUTHOR = "{ CALL UpdateAuthor (?,?,?) }";
  private static final String DELETE_AUTHOR = "{ CALL DeleteAuthor (?) }";
  private static final String SELECT_AUTHORS = "{ CALL SelectAuthors }";

  @Override
  public int createAuthor(Author author) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_AUTHOR)) {
      stmt.setString(NAME, author.getName());
      stmt.setString(LINK, author.getLink());
      stmt.registerOutParameter(ID, Types.INTEGER);
      stmt.executeUpdate();
      return stmt.getInt(ID);
    }
  }

  @Override
  public void createAuthors(List<Author> authors) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
        CallableStatement stmt = con.prepareCall(CREATE_AUTHOR)) {
      for (Author author : authors) {
        stmt.setString(NAME, author.getName());
        stmt.setString(LINK, author.getLink());
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
  public void updateAuthor(int id, Author author) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(UPDATE_AUTHOR)) {
      stmt.setInt(ID, id);
      stmt.setString(NAME, author.getName());
      stmt.setString(LINK, author.getLink());
      stmt.executeUpdate();
    }
  }

  @Override
  public void deleteAuthor(int id) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_AUTHOR)) {
      stmt.setInt(ID, id);
      stmt.executeUpdate();
    }
  }

  @Override
  public List<Author> selectAuthors() throws Exception {
    List<Author> authors = new ArrayList<>();
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
        CallableStatement stmt = con.prepareCall(SELECT_AUTHORS)) {
      if (stmt.execute()) {
        ResultSet rs = stmt.getResultSet();
        while (rs.next()) {
          authors.add(createAuthorFromResultSet(rs));
        }
      }
    }
    return authors;
  }

  private static Author createAuthorFromResultSet(ResultSet rs) throws Exception {
    return new Author(
        rs.getInt(ID),
        rs.getString(NAME),
        rs.getString(LINK));
  }
}
