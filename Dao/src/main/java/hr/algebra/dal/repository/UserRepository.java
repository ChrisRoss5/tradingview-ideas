package hr.algebra.dal.repository;

import java.util.List;
import java.util.Optional;

import hr.algebra.model.User;

public interface UserRepository {
  int createUser(User user) throws Exception;

  void updateUser(int id, User user) throws Exception;

  void deleteUser(int id) throws Exception;

  Optional<User> selectUser(int id) throws Exception;

  Optional<User> selectUserByUsername(String username) throws Exception;

  Optional<User> selectUserByUsernameAndPassword(String username, String password) throws Exception;

  List<User> selectUsers() throws Exception;
}
