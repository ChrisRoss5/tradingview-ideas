package hr.algebra.parsers.rss;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import hr.algebra.dal.factory.RepositoryFactory;
import hr.algebra.dal.repository.AuthorRepository;
import hr.algebra.dal.repository.IdeaAuthorRepository;
import hr.algebra.dal.repository.IdeaRepository;
import hr.algebra.dal.repository.ImageRepository;
import hr.algebra.dal.repository.SymbolRepository;
import hr.algebra.model.Author;
import hr.algebra.model.Idea;
import hr.algebra.model.Market;
import hr.algebra.model.Symbol;

public class IdeaParser {

  private static final String RSS_URL = "https://www.tradingview.com/feed";
  private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.RFC_1123_DATE_TIME;
  private static final ZoneId USER_TIME_ZONE = ZoneId.systemDefault();
  private static final IdeaRepository ideaRepository = RepositoryFactory.getIdeaRepository();
  private static final AuthorRepository authorRepository = RepositoryFactory.getAuthorRepository();
  private static final IdeaAuthorRepository ideaAuthorRepository = RepositoryFactory.getIdeaAuthorRepository();
  private static final SymbolRepository symbolRepository = RepositoryFactory.getSymbolRepository();
  private static final ImageRepository imageRepository = RepositoryFactory.getImageRepository();

  private enum CssSelector {
    ITEM("item"),
    TITLE("title"),
    LINK("link"),
    DESCRIPTION("description"),
    PUB_DATE("pubDate"),
    CONTENT("content\\:encoded"),
    SYMBOL_NAME(".chart-symbol a"),
    SYMBOL_LINK(".chart-symbol a"),
    SYMBOL_DESCRIPTION(".chart-symbol .symbol-descr"),
    AUTHOR_NAME(".chart-author a"),
    AUTHOR_LINK(".chart-author a"),
    IMAGE_LINK(".chart-author ~ a img");

    private final String selector;

    private CssSelector(String selector) {
      this.selector = selector;
    }

    private String getSelector() {
      return selector;
    }
  }

  public static void parse(List<Market> markets) throws Exception {
    Set<Symbol> symbols = new HashSet<>();
    Set<Author> authors = new HashSet<>();
    Map<Idea, Author> ideaAuthorMap = new HashMap<>();

    long time1 = System.nanoTime();

    for (Market market : markets) {
      String url = RSS_URL + "/?sort=recent&stream=" + market.getName().toLowerCase();
      Document doc = Jsoup.connect(url).get();
      Elements items = doc.select(CssSelector.ITEM.getSelector());

      for (Element item : items) {
        String title = selectText(item, CssSelector.TITLE);
        String link = selectText(item, CssSelector.LINK);
        String description = selectText(item, CssSelector.DESCRIPTION);
        String pubDate = selectText(item, CssSelector.PUB_DATE);
        String content = selectText(item, CssSelector.CONTENT);
        Document bodyFragment = Jsoup.parseBodyFragment(content);
        String symbolName = selectText(bodyFragment, CssSelector.SYMBOL_NAME);
        String symbolDescription = selectText(bodyFragment, CssSelector.SYMBOL_DESCRIPTION);
        String symbolLink = selectAttribute(bodyFragment, CssSelector.SYMBOL_LINK, "href");
        String authorName = selectText(bodyFragment, CssSelector.AUTHOR_NAME);
        String authorLink = selectAttribute(bodyFragment, CssSelector.AUTHOR_LINK, "href");
        String imageLink = selectAttribute(bodyFragment, CssSelector.IMAGE_LINK, "src");
        String picturePath = imageRepository.saveImageFromLink(imageLink);
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(pubDate, DATE_FORMATTER);
        ZonedDateTime zonedDateTime = offsetDateTime.atZoneSameInstant(USER_TIME_ZONE);
        LocalDateTime publishedDate = zonedDateTime.toLocalDateTime();
        Symbol symbol = new Symbol(symbolName, symbolDescription, symbolLink);
        Author author = new Author(authorName, authorLink);
        Idea idea = new Idea(title, link, description, picturePath, publishedDate, symbol, market);
        symbols.add(symbol);
        authors.add(author);
        ideaAuthorMap.put(idea, author);
      }
    }

    long time2 = System.nanoTime();
    System.out.println("Elapsed time 1: " + (time2 - time1) / 1_000_000_000.0 + "s");

    symbolRepository.createSymbols(new ArrayList<>(symbols));
    authorRepository.createAuthors(new ArrayList<>(authors));

    Map<String, Symbol> dbSymbolsMap = symbolRepository.selectSymbols().stream()
        .collect(Collectors.toMap(Symbol::getLink, Function.identity()));
    Map<String, Author> dbAuthorsMap = authorRepository.selectAuthors().stream()
        .collect(Collectors.toMap(Author::getLink, Function.identity()));

    for (Idea idea : ideaAuthorMap.keySet()) {
      idea.setSymbol(dbSymbolsMap.get(idea.getSymbol().getLink()));
    }

    ideaRepository.createIdeas(new ArrayList<>(ideaAuthorMap.keySet()));

    Map<String, Idea> dbIdeasMap = ideaRepository.selectIdeas().stream()
        .collect(Collectors.toMap(Idea::getLink, Function.identity()));

    List<Entry<Integer, Integer>> ideaAuthorEntries = ideaAuthorMap.entrySet().stream()
        .map(entry -> Map.entry(
            dbIdeasMap.get(entry.getKey().getLink()).getId(),
            dbAuthorsMap.get(entry.getValue().getLink()).getId()))
        .toList();

    ideaAuthorRepository.createAssociations(ideaAuthorEntries);

    long time3 = System.nanoTime();
    System.out.println("Elapsed time 2: " + (time3 - time2) / 1_000_000_000.0 + "s");
  }

  private static String selectText(Element element, CssSelector selector) {
    Element el = element.selectFirst(selector.getSelector());
    return el == null ? "" : el.text();
  }

  private static String selectAttribute(Element element, CssSelector selector, String attribute) {
    Element el = element.selectFirst(selector.getSelector());
    return el == null ? "" : el.attr(attribute);
  }
}
