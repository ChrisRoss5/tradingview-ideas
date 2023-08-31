package hr.algebra.model;

public final class User {
  private int id;
  private String username;
  private String passwordHash;
  private UserRole role;

  public enum UserRole {
    USER, ADMIN
  }

  public User(int id, String username, String passwordHash, UserRole role) {
    this.id = id;
    this.username = username;
    this.passwordHash = passwordHash;
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

  public String getPasswordHash() {
    return passwordHash;
  }

  public void setPasswordHash(String passwordHash) {
    this.passwordHash = passwordHash;
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
