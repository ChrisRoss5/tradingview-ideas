package hr.algebra.model;

public final class Market {
  private int id;
  private String name;
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
  public String toString() {
    return "Market [id=" + id + ", name=" + name + ", isSelected=" + isSelected + "]";
  }
}
