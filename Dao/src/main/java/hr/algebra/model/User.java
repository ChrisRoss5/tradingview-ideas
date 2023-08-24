package hr.algebra.model;

public final class User {
  private int id;
  private String username;
  private String password;
  private UserRole role;

  public enum UserRole {
    USER, ADMIN
  }

  public User(String username, String password, UserRole role) {
    this.username = username;
    this.password = password;
    this.role = role;
  }

  public User(int id, String username, String password, UserRole role) {
    this(username, password, role);
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserRole getRole() {
    return role;
  }

  public void setRole(UserRole role) {
    this.role = role;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + "]";
  }
}
