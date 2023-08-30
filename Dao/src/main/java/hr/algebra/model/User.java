package hr.algebra.model;

public final class User {
  private int id;
  private String username;
  private String password;
  private UserRole role;

  public enum UserRole {
    USER, ADMIN
  }

  public User(int id, String username, String password, UserRole role) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.role = role;
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

  public boolean isAdmin() {
    return role == UserRole.ADMIN;
  }
}
