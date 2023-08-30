package hr.algebra.model;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ideaarchive")
@XmlAccessorType(XmlAccessType.FIELD)
public final class IdeaArchive {

  @XmlElementWrapper
  @XmlElement(name = "idea")
  private List<Idea> ideas;

  public IdeaArchive() {
  }

  public IdeaArchive(List<Idea> ideas) {
    this.ideas = ideas;
  }

  public List<Idea> getIdeas() {
    return ideas;
  }

}
