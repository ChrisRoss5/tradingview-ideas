package hr.algebra.dal.repository;

import java.util.Optional;

import hr.algebra.model.User;

public interface UserRepository {

  User register(String username, String password) throws Exception;

  boolean userExists(String username) throws Exception;

  Optional<User> login(String username, String password) throws Exception;

}
