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
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "name", "description", "link" })
public final class Symbol {

  @XmlTransient
  @Setter(AccessLevel.NONE)
  private int id;

  @ToString.Include
  private String name;

  private String description;

  @EqualsAndHashCode.Include
  private String link;

  public Symbol(String name, String description, String link) {
    this.name = name;
    this.description = description;
    this.link = link;
  }

  @Override
  public String toString() {
    return getName();
  }
}
