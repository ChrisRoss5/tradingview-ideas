package hr.algebra.dal.repository;

import hr.algebra.model.Author;
import java.util.List;

public interface AuthorRepository {

  int createAuthor(Author author) throws Exception;

  void createAuthors(List<Author> authors) throws Exception;

  void updateAuthor(int id, Author author) throws Exception;

  void deleteAuthor(int id) throws Exception;

  List<Author> selectAuthors() throws Exception;

}
