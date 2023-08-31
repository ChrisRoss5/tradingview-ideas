package hr.algebra.dal.repository.sql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.List;
import java.util.Map.Entry;

import javax.sql.DataSource;

import com.microsoft.sqlserver.jdbc.SQLServerException;

import hr.algebra.dal.repository.IdeaAuthorRepository;

public class SqlIdeaAuthorRepository implements IdeaAuthorRepository {
  private static final String ID = "Id";
  private static final String IDEA_ID = "IdeaId";
  private static final String AUTHOR_ID = "AuthorId";

  private static final String CREATE_IDEA_AUTHOR = "{ CALL CreateIdeaAuthor (?,?,?) }";
  private static final String DELETE_IDEA_AUTHOR_BY_IDEA_ID = "{ CALL DeleteIdeaAuthorByIdeaId (?) }";
  private static final String DELETE_IDEA_AUTHOR_BY_AUTHOR_ID = "{ CALL DeleteIdeaAuthorByAuthorId (?) }";

  @Override
  public void createAssociations(List<Entry<Integer, Integer>> ideaAuthors) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection(); CallableStatement stmt = con.prepareCall(CREATE_IDEA_AUTHOR)) {
      for (Entry<Integer, Integer> ideaAuthor : ideaAuthors) {
        stmt.setInt(IDEA_ID, ideaAuthor.getKey());
        stmt.setInt(AUTHOR_ID, ideaAuthor.getValue());
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
  public void deleteIdeaAssociations(int ideaId) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
        CallableStatement stmt = con.prepareCall(DELETE_IDEA_AUTHOR_BY_IDEA_ID)) {
      stmt.setInt(IDEA_ID, ideaId);
      stmt.executeUpdate();
    }
  }

  @Override
  public void deleteAuthorAssociations(int authorId) throws Exception {
    DataSource dataSource = DataSourceSingleton.getInstance();
    try (Connection con = dataSource.getConnection();
        CallableStatement stmt = con.prepareCall(DELETE_IDEA_AUTHOR_BY_AUTHOR_ID)) {
      stmt.setInt(AUTHOR_ID, authorId);
      stmt.executeUpdate();
    }
  }
}
