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
@XmlType(propOrder = { "name" })
public final class Market {

  @Setter(AccessLevel.NONE)
  @XmlTransient
  private int id;

  @EqualsAndHashCode.Include
  @ToString.Include
  private String name;

  @XmlTransient
  private boolean isSelected;

  @Override
  public String toString() {
    return getName();
  }
}
