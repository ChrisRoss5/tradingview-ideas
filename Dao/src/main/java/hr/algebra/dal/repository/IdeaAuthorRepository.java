package hr.algebra.dal.repository;

import java.util.List;
import java.util.Map.Entry;

public interface IdeaAuthorRepository {

  void createAssociations(List<Entry<Integer, Integer>> ideaAuthors) throws Exception;

  void deleteIdeaAssociations(int ideaId) throws Exception;

  void deleteAuthorAssociations(int authorId) throws Exception;

}
