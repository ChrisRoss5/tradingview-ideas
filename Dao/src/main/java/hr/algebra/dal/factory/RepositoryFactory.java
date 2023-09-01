package hr.algebra.dal.factory;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import hr.algebra.dal.repository.AdminControlsRepository;
import hr.algebra.dal.repository.AuthorRepository;
import hr.algebra.dal.repository.IdeaAuthorRepository;
import hr.algebra.dal.repository.IdeaRepository;
import hr.algebra.dal.repository.ImageRepository;
import hr.algebra.dal.repository.MarketRepository;
import hr.algebra.dal.repository.SymbolRepository;
import hr.algebra.dal.repository.UserRepository;

public final class RepositoryFactory {

  private static final Properties properties = new Properties();
  private static final String PATH = "/config/repository.properties";
  private static final String IDEA_REPOSITORY = "IDEA_REPOSITORY";
  private static final String AUTHOR_REPOSITORY = "AUTHOR_REPOSITORY";
  private static final String IDEA_AUTHOR_REPOSITORY = "IDEA_AUTHOR_REPOSITORY";
  private static final String SYMBOL_REPOSITORY = "SYMBOL_REPOSITORY";
  private static final String MARKET_REPOSITORY = "MARKET_REPOSITORY";
  private static final String USER_REPOSITORY = "USER_REPOSITORY";
  private static final String ADMIN_CONTROLS_REPOSITORY = "ADMIN_CONTROLS_REPOSITORY";
  private static final String IMAGE_REPOSITORY = "IMAGE_REPOSITORY";
  private static IdeaRepository ideaRepository;
  private static AuthorRepository authorRepository;
  private static IdeaAuthorRepository ideaAuthorRepository;
  private static SymbolRepository symbolRepository;
  private static MarketRepository marketRepository;
  private static UserRepository userRepository;
  private static AdminControlsRepository adminControlsRepository;
  private static ImageRepository imageRepository;

  static {
    try (InputStream is = RepositoryFactory.class.getResourceAsStream(PATH)) {
      properties.load(is);
      ideaRepository = createRepository(IdeaRepository.class, IDEA_REPOSITORY);
      authorRepository = createRepository(AuthorRepository.class, AUTHOR_REPOSITORY);
      ideaAuthorRepository = createRepository(IdeaAuthorRepository.class, IDEA_AUTHOR_REPOSITORY);
      symbolRepository = createRepository(SymbolRepository.class, SYMBOL_REPOSITORY);
      marketRepository = createRepository(MarketRepository.class, MARKET_REPOSITORY);
      userRepository = createRepository(UserRepository.class, USER_REPOSITORY);
      adminControlsRepository = createRepository(AdminControlsRepository.class, ADMIN_CONTROLS_REPOSITORY);
      imageRepository = createRepository(ImageRepository.class, IMAGE_REPOSITORY);
    } catch (Exception ex) {
      Logger.getLogger(RepositoryFactory.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private static <T> T createRepository(Class<T> repositoryClass, String propertyName) throws Exception {
    String repositoryClassName = properties.getProperty(propertyName);
    return repositoryClass.cast(Class.forName(repositoryClassName)
        .getDeclaredConstructor()
        .newInstance());
  }

  public static IdeaRepository getIdeaRepository() {
    return ideaRepository;
  }

  public static AuthorRepository getAuthorRepository() {
    return authorRepository;
  }

  public static IdeaAuthorRepository getIdeaAuthorRepository() {
    return ideaAuthorRepository;
  }

  public static SymbolRepository getSymbolRepository() {
    return symbolRepository;
  }

  public static MarketRepository getMarketRepository() {
    return marketRepository;
  }

  public static UserRepository getUserRepository() {
    return userRepository;
  }

  public static AdminControlsRepository getAdminControlsRepository() {
    return adminControlsRepository;
  }

  public static ImageRepository getImageRepository() {
    return imageRepository;
  }
}
