package hr.algebra.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "name" })
public final class Market {
  @XmlTransient
  private int id;
  private String name;
  @XmlTransient
  private boolean isSelected;

  public Market(String name, boolean isSelected) {
    this.name = name;
    this.isSelected = isSelected;
  }

  public Market(int id, String name, boolean isSelected) {
    this(name, isSelected);
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isSelected() {
    return isSelected;
  }

  public void setSelected(boolean isSelected) {
    this.isSelected = isSelected;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Market other = (Market) obj;
    if (id != other.id)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return name;
  }
}
