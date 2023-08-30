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

  private static final String SET_SELECTED_MARKET = "{ CALL SetSelectedMarket (?,?) }";
  private static final String SELECT_MARKETS = "{ CALL SelectMarkets }";

  @Override
  public void setSelected(int id, boolean isSelected) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SET_SELECTED_MARKET)) {
      stmt.setInt(ID, id);
      stmt.setBoolean(IS_SELECTED, isSelected);
      stmt.executeUpdate();
    }
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