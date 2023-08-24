package hr.algebra.auth;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import hr.algebra.dal.factory.RepositoryFactory;
import hr.algebra.dal.repository.UserRepository;
import hr.algebra.model.User;

public final class SessionManagerSingleton {
  private static final UserRepository userRepository = RepositoryFactory.getUserRepository();
  private static SessionManagerSingleton instance;
  private User currentUser;

  private SessionManagerSingleton() {
  }

  public static SessionManagerSingleton getInstance() {
    if (instance == null) {
      instance = new SessionManagerSingleton();
    }
    return instance;
  }

  public boolean login(String username, String password) {
    try {
      Optional<User> optionalUser = userRepository.selectUserByUsernameAndPassword(username, password);
      if (optionalUser.isPresent()) {
        currentUser = optionalUser.get();
        return true;
      }
    } catch (Exception ex) {
      Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
  }

  public void logout() {
    currentUser = null;
  }

  public User getCurrentUser() {
    return currentUser;
  }

  public boolean isLoggedIn() {
    return currentUser != null;
  }

  public boolean isAdmin() {
    return isLoggedIn() && currentUser.getRole() == User.UserRole.ADMIN;
  }

  public boolean userExists(String username) {
    try {
      return userRepository.selectUserByUsername(username).isPresent();
    } catch (Exception ex) {
      Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
    }
    return false;
  }

  public void register(String username, String password) {
    try {
      User user = new User(username, password, User.UserRole.USER);
      userRepository.createUser(user);
      currentUser = user;
    } catch (Exception ex) {
      Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
