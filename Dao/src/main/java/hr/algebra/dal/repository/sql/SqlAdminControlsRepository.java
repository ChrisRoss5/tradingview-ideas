package hr.algebra.dal.repository.sql;

import java.sql.CallableStatement;
import java.sql.Connection;

import javax.sql.DataSource;

import hr.algebra.dal.repository.AdminControlsRepository;

public class SqlAdminControlsRepository implements AdminControlsRepository {

  private static final String DELETE_ALL_CONTENT = "{ CALL DeleteAllContent }";

  @Override
  public void deleteAllContent() throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_ALL_CONTENT)) {
      stmt.executeUpdate();
    }
  }
}
