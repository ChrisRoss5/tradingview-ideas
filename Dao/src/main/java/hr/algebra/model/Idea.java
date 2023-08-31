package hr.algebra.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import hr.algebra.adapter.LocalDateTimeAdapter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "title", "link", "description", "publishedDate", "symbol", "market", "authors" })
public final class Idea {

  public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

  @Setter(AccessLevel.NONE)
  @XmlTransient
  private int id;

  private String title;

  @EqualsAndHashCode.Include
  private String link;

  private String description;

  @XmlTransient
  private String picturePath;

  @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
  @XmlElement(name = "publisheddate")
  private LocalDateTime publishedDate;

  private Symbol symbol;

  private Market market;

  @XmlElementWrapper
  @XmlElement(name = "author")
  private List<Author> authors;

  public Idea(String title, String link, String description, String picturePath, LocalDateTime publishedDate,
      Symbol symbol, Market market, List<Author> authors) {
    this.title = title;
    this.link = link;
    this.description = description;
    this.picturePath = picturePath;
    this.publishedDate = publishedDate;
    this.symbol = symbol;
    this.market = market;
    this.authors = authors;
  }
}
