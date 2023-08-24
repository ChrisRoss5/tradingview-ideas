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
  private static final String UPDATE_USER = "{ CALL UpdateUser (?,?,?,?) }";
  private static final String DELETE_USER = "{ CALL DeleteUser (?) }";
  private static final String SELECT_USER = "{ CALL SelectUser (?) }";
  private static final String SELECT_USER_BY_USERNAME = "{ CALL SelectUserByUsername (?) }";
  private static final String SELECT_USER_BY_USERNAME_AND_PASSWORD = "{ CALL SelectUserByUsernameAndPassword (?,?) }";
  private static final String SELECT_USERS = "{ CALL SelectUsers }";

  @Override
  public int createUser(User user) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_USER)) {
      stmt.setString(USERNAME, user.getUsername());
      stmt.setString(PASSWORD, user.getPassword());
      stmt.setString(ROLE, user.getRole().name());
      stmt.registerOutParameter(ID, Types.INTEGER);
      stmt.executeUpdate();
      return stmt.getInt(ID);
    }
  }

  @Override
  public void updateUser(int id, User user) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(UPDATE_USER)) {
      stmt.setInt(ID, id);
      stmt.setString(USERNAME, user.getUsername());
      stmt.setString(PASSWORD, user.getPassword());
      stmt.setString(ROLE, user.getRole().name());
      stmt.executeUpdate();
    }
  }

  @Override
  public void deleteUser(int id) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_USER)) {
      stmt.setInt(ID, id);
      stmt.executeUpdate();
    }
  }

  @Override
  public Optional<User> selectUser(int id) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(SELECT_USER)) {
      stmt.setInt(ID, id);
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          return Optional.of(createUserFromResultSet(rs));
        }
      }
    }
    return Optional.empty();
  }

  @Override
  public Optional<User> selectUserByUsername(String username) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
        CallableStatement stmt = con.prepareCall(SELECT_USER_BY_USERNAME)) {
      stmt.setString(USERNAME, username);
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          return Optional.of(createUserFromResultSet(rs));
        }
      }
    }
    return Optional.empty();
  }

  @Override
  public Optional<User> selectUserByUsernameAndPassword(String username, String password) throws Exception {
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

  @Override
  public List<User> selectUsers() throws Exception {
    List<User> users = new ArrayList<>();
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
        CallableStatement stmt = con.prepareCall(SELECT_USERS);
        ResultSet rs = stmt.executeQuery()) {
      while (rs.next()) {
        users.add(createUserFromResultSet(rs));
      }
    }
    return users;
  }

  private static User createUserFromResultSet(ResultSet rs) throws Exception {
    return new User(
        rs.getInt(ID),
        rs.getString(USERNAME),
        rs.getString(PASSWORD),
        UserRole.valueOf(rs.getString(ROLE)));
  }
}
