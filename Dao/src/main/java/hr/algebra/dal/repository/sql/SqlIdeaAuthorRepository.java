package hr.algebra.dal.repository.sql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.List;
import java.util.Map.Entry;

import javax.sql.DataSource;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import hr.algebra.dal.repository.IdeaAuthorRepository;
import hr.algebra.model.Author;
import hr.algebra.model.Idea;

public class SqlIdeaAuthorRepository implements IdeaAuthorRepository {
  private static final String ID = "Id";
  private static final String IDEA_ID = "IdeaId";
  private static final String AUTHOR_ID = "AuthorId";

  private static final String CREATE_IDEA_AUTHOR = "{ CALL CreateIdeaAuthor (?,?,?) }";
  private static final String UPDATE_IDEA_AUTHOR = "{ CALL UpdateIdeaAuthor (?,?,?) }";
  private static final String DELETE_IDEA_AUTHOR = "{ CALL DeleteIdeaAuthor (?) }";
  private static final String SELECT_IDEA_AUTHOR = "{ CALL SelectIdeaAuthor (?) }";
  private static final String SELECT_IDEA_AUTHORS = "{ CALL SelectIdeaAuthors }";

  @Override
  public int createAssociation(Idea idea, Author author) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_IDEA_AUTHOR)) {
      stmt.setInt(IDEA_ID, idea.getId());
      stmt.setInt(AUTHOR_ID, author.getId());
      stmt.registerOutParameter(ID, Types.INTEGER);
      stmt.executeUpdate();
      return stmt.getInt(ID);
    }
  }

  @Override
  public void createAssociations(List<Entry<Idea, Author>> ideaAuthors) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_IDEA_AUTHOR)) {
      for (Entry<Idea, Author> ideaAuthor : ideaAuthors) {
        stmt.setInt(IDEA_ID, ideaAuthor.getKey().getId());
        stmt.setInt(AUTHOR_ID, ideaAuthor.getValue().getId());
        stmt.registerOutParameter(ID, Types.INTEGER);
        try {
          stmt.executeUpdate();
        } catch (SQLServerException ex) {
          if (!ex.getMessage().contains("Violation of UNIQUE KEY constraint"))
            throw ex;
        }
      }
    }
  }

  @Override
  public void deleteAssociation(Idea idea, Author author) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(DELETE_IDEA_AUTHOR)) {
      stmt.setInt(IDEA_ID, idea.getId());
      stmt.setInt(AUTHOR_ID, author.getId());
      stmt.executeUpdate();
    }
  }
}
