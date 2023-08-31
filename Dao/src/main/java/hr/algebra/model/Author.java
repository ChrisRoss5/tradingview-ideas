package hr.algebra.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "name", "link" })
public final class Author {

  @Setter(AccessLevel.NONE)
  @XmlTransient
  private int id;

  private String name;

  @EqualsAndHashCode.Include
  private String link;

  public Author(String name, String link) {
    this.name = name;
    this.link = link;
  }

  @Override
  public String toString() {
    return getName();
  }
}
