package hr.algebra.dal.repository.sql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import hr.algebra.dal.repository.SymbolRepository;
import hr.algebra.model.Symbol;

public class SqlSymbolRepository implements SymbolRepository {

  private static final String ID = "Id";
  private static final String NAME = "Name";
  private static final String DESCRIPTION = "Description";
  private static final String LINK = "Link";

  private static final String CREATE_SYMBOL = "{ CALL CreateSymbol (?,?,?,?) }";
  private static final String UPDATE_SYMBOL = "{ CALL UpdateSymbol (?,?,?,?) }";
  private static final String DELETE_SYMBOL = "{ CALL DeleteSymbol (?) }";
  private static final String SELECT_SYMBOLS = "{ CALL SelectSymbols }";

  @Override
  public int createSymbol(Symbol symbol) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_SYMBOL)) {
      stmt.setString(NAME, symbol.getName());
      stmt.setString(DESCRIPTION, symbol.getDescription());
      stmt.setString(LINK, symbol.getLink());
      stmt.registerOutParameter(ID, Types.INTEGER);
      stmt.executeUpdate();
      return stmt.getInt(ID);
    }
  }

  @Override
  public void createSymbols(List<Symbol> symbols) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_SYMBOL)) {
      for (Symbol symbol : symbols) {
        stmt.setString(NAME, symbol.getName());
        stmt.setString(DESCRIPTION, symbol.getDescription());
        stmt.setString(LINK, symbol.getLink());
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
  public void updateSymbol(int id, Symbol symbol) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(UPDATE_SYMBOL)) {
      stmt.setInt(ID, id);
      stmt.setString(NAME, symbol.getName());
      stmt.setString(DESCRIPTION, symbol.getDescription());
      stmt.setString(LINK, symbol.getLink());
      stmt.executeUpdate();
    }
  }

  @Override
  public void deleteSymbol(int id) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_SYMBOL)) {
      stmt.setInt(ID, id);
      stmt.executeUpdate();
    }
  }

  @Override
  public List<Symbol> selectSymbols() throws Exception {
    List<Symbol> symbols = new ArrayList<>();
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
        CallableStatement stmt = con.prepareCall(SELECT_SYMBOLS);
        ResultSet rs = stmt.executeQuery()) {
      while (rs.next()) {
        symbols.add(createSymbolFromResultSet(rs));
      }
    }
    return symbols;
  }

  private static Symbol createSymbolFromResultSet(ResultSet rs) throws Exception {
    return new Symbol(
        rs.getInt(ID),
        rs.getString(NAME),
        rs.getString(DESCRIPTION),
        rs.getString(LINK));
  }
}
