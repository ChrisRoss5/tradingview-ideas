package hr.algebra.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@XmlRootElement(name = "ideaarchive")
@XmlAccessorType(XmlAccessType.FIELD)
public final class IdeaArchive {

  @XmlElementWrapper
  @XmlElement(name = "idea")
  private List<Idea> ideas;
}
