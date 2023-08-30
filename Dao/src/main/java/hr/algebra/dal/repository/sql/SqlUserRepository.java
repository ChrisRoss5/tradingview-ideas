package hr.algebra.dal.repository.sql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import hr.algebra.dal.repository.UserRepository;
import hr.algebra.model.User;
import hr.algebra.model.User.UserRole;

public class SqlUserRepository implements UserRepository {

  private static final String ID = "Id";
  private static final String USERNAME = "Username";
  private static final String PASSWORD = "Password";
  private static final String ROLE = "Role";

  private static final String CREATE_USER = "{ CALL CreateUser (?,?,?,?) }";
  private static final String SELECT_USER_BY_USERNAME = "{ CALL SelectUserByUsername (?) }";
  private static final String SELECT_USER_BY_USERNAME_AND_PASSWORD = "{ CALL SelectUserByUsernameAndPassword (?,?) }";

  @Override
  public User register(String username, String password) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_USER)) {
      stmt.setString(USERNAME, username);
      stmt.setString(PASSWORD, password);
      stmt.setString(ROLE, UserRole.USER.name());
      stmt.registerOutParameter(ID, Types.INTEGER);
      stmt.executeUpdate();
      return new User(stmt.getInt(ID), username, password, UserRole.USER);
    }
  }

  @Override
  public boolean userExists(String username) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
        CallableStatement stmt = con.prepareCall(SELECT_USER_BY_USERNAME)) {
      stmt.setString(USERNAME, username);
      try (ResultSet rs = stmt.executeQuery()) {
        return rs.next();
      }
    }
  }

  @Override
  public Optional<User> login(String username, String password) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
        CallableStatement stmt = con.prepareCall(SELECT_USER_BY_USERNAME_AND_PASSWORD)) {
      stmt.setString(USERNAME, username);
      stmt.setString(PASSWORD, password);
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          return Optional.of(createUserFromResultSet(rs));
        }
      }
    }
    return Optional.empty();
  }

  private static User createUserFromResultSet(ResultSet rs) throws Exception {
    return new User(
        rs.getInt(ID),
        rs.getString(USERNAME),
        rs.getString(PASSWORD),
        UserRole.valueOf(rs.getString(ROLE)));
  }
}
