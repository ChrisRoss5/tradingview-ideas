package hr.algebra.dal.repository;

import hr.algebra.model.Author;
import java.util.List;
import java.util.Optional;

public interface AuthorRepository {


  int createAuthor(Author author) throws Exception;
  
  void createAuthors(List<Author> authors) throws Exception;

  void updateAuthor(int id, Author author) throws Exception;

  void deleteAuthor(int id) throws Exception;

  Optional<Author> selectAuthor(int id) throws Exception;

  Optional<Author> selectAuthorByLink(String link) throws Exception;

  List<Author> selectAuthors() throws Exception;
}
