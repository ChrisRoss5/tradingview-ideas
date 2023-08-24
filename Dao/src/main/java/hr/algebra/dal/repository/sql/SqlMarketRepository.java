package hr.algebra.dal.repository.sql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

import hr.algebra.dal.repository.MarketRepository;
import hr.algebra.model.Market;

public class SqlMarketRepository implements MarketRepository {
  private static final String ID = "Id";
  private static final String NAME = "Name";
  private static final String IS_SELECTED = "IsSelected";

  private static final String CREATE_MARKET = "{ CALL CreateMarket (?,?,?) }";
  private static final String UPDATE_MARKET = "{ CALL UpdateMarket (?,?,?) }";
  private static final String DELETE_MARKET = "{ CALL DeleteMarket (?) }";
  private static final String SELECT_MARKET = "{ CALL SelectMarket (?) }";
  private static final String SELECT_MARKETS = "{ CALL SelectMarkets }";

  @Override
  public int createMarket(Market market) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_MARKET)) {
      stmt.setString(NAME, market.getName());
      stmt.setBoolean(IS_SELECTED, market.isSelected());
      stmt.registerOutParameter(ID, Types.INTEGER);
      stmt.executeUpdate();
      return stmt.getInt(ID);
    }
  }

  @Override
  public void updateMarket(int id, Market market) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(UPDATE_MARKET)) {
      stmt.setInt(ID, id);
      stmt.setString(NAME, market.getName());
      stmt.setBoolean(IS_SELECTED, market.isSelected());
      stmt.executeUpdate();
    }
  }

  @Override
  public void deleteMarket(int id) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_MARKET)) {
      stmt.setInt(ID, id);
      stmt.executeUpdate();
    }
  }

  @Override
  public Optional<Market> selectMarket(int id) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_MARKET)) {
      stmt.setInt(ID, id);
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          return Optional.of(new Market(rs.getInt(ID), rs.getString(NAME), rs.getBoolean(IS_SELECTED)));
        }
      }
    }
    return Optional.empty();
  }

  @Override
  public List<Market> selectMarkets() throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_MARKETS)) {
      try (ResultSet rs = stmt.executeQuery()) {
        List<Market> markets = new ArrayList<>();
        while (rs.next()) {
          markets.add(new Market(rs.getInt(ID), rs.getString(NAME), rs.getBoolean(IS_SELECTED)));
        }
        return markets;
      }
    }
  }
}