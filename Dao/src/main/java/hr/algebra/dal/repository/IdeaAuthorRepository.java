package hr.algebra.dal.repository;

import hr.algebra.model.Idea;

import java.util.List;
import java.util.Map.Entry;

public interface IdeaAuthorRepository {

  void createAssociations(List<Entry<Integer, Integer>> ideaAuthors) throws Exception;

  void deleteIdeaAssociations(int ideaId) throws Exception;

  List<Integer> selectAuthorIdsByIdea(Idea idea) throws Exception;

}
