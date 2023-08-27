package hr.algebra.model;

public final class Author {

  private int id;
  private String name;
  private String link;

  public Author(String name, String link) {
    this.name = name;
    this.link = link;
  }

  public Author(int id, String name, String link) {
    this(name, link);
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

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
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
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Author other = (Author) obj;
    if (link == null) {
      if (other.link != null)
        return false;
    } else if (!link.equals(other.link))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return name;
  }
}
