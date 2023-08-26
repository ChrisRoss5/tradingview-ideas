package hr.algebra.dal.repository;

import hr.algebra.model.Idea;

import java.util.List;
import java.util.Map.Entry;

import hr.algebra.model.Author;

public interface IdeaAuthorRepository {

  int createAssociation(Idea idea, Author author) throws Exception;

  void createAssociations(List<Entry<Idea, Author>> ideaAuthors) throws Exception;

  void deleteAssociation(Idea idea, Author author) throws Exception;

  List<Integer> selectIdeaIdsByAuthor(Author author) throws Exception;

  List<Integer> selectAuthorIdsByIdea(Idea idea) throws Exception;
}
