package hr.algebra.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import hr.algebra.adapter.LocalDateTimeAdapter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "title", "link", "description", "publishedDate", "symbol", "market" })
public final class Idea {

  public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

  @XmlTransient
  private int id;
  private String title;
  private String link;
  private String description;
  @XmlTransient
  private String picturePath;
  @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
  @XmlElement(name = "publisheddate")
  private LocalDateTime publishedDate;
  private Symbol symbol;
  private Market market;

  public Idea(String title, String link, String description, String picturePath, LocalDateTime publishedDate,
      Symbol symbol, Market market) {
    this.title = title;
    this.link = link;
    this.description = description;
    this.picturePath = picturePath;
    this.publishedDate = publishedDate;
    this.symbol = symbol;
    this.market = market;
  }

  public Idea(int id, String title, String link, String description, String picturePath, LocalDateTime publishedDate,
      Symbol symbol, Market market) {
    this(title, link, description, picturePath, publishedDate, symbol, market);
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPicturePath() {
    return picturePath;
  }

  public void setPicturePath(String picturePath) {
    this.picturePath = picturePath;
  }

  public LocalDateTime getPublishedDate() {
    return publishedDate;
  }

  public void setPublishedDate(LocalDateTime publishedDate) {
    this.publishedDate = publishedDate;
  }

  public Symbol getSymbol() {
    return symbol;
  }

  public void setSymbol(Symbol symbol) {
    this.symbol = symbol;
  }

  public Market getMarket() {
    return market;
  }

  public void setMarket(Market market) {
    this.market = market;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((link == null) ? 0 : link.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Idea other = (Idea) obj;
    if (link == null) {
      if (other.link != null) {
        return false;
      }
    } else if (!link.equals(other.link)) {
      return false;
    }
    return true;
  }
}
