package hr.algebra.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public final class User {

  @Setter(AccessLevel.NONE)
  private int id;

  private String username;

  private String passwordHash;

  private UserRole role;

  public enum UserRole {
    USER, ADMIN
  }

  public boolean isAdmin() {
    return role == UserRole.ADMIN;
  }
}
