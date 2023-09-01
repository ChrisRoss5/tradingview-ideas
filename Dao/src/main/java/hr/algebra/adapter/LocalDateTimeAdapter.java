package hr.algebra.adapter;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import hr.algebra.model.Idea;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {
  @Override
  public LocalDateTime unmarshal(String value) throws Exception {
    if (value == null || value.isEmpty()) {
      return null;
    }
    return LocalDateTime.parse(value, Idea.DATE_FORMATTER);
  }

  @Override
  public String marshal(LocalDateTime value) throws Exception {
    if (value == null) {
      return null;
    }
    return value.format(Idea.DATE_FORMATTER);
  }
}
