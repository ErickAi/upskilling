package er.upskilling.javabasics;

import java.util.Objects;

public class EqualsAndHashcode {

  private int id;
  private String name;
  private int someField;

  public EqualsAndHashcode() {
  }

  public EqualsAndHashcode(String name, int someField) {
    this.name = name;
    this.someField = someField;
  }

  public EqualsAndHashcode(int id, String name, int someField) {
    this.id = id;
    this.name = name;
    this.someField = someField;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getSomeField() {
    return someField;
  }

  public void setSomeField(int someField) {
    this.someField = someField;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    EqualsAndHashcode equalsAndHashcode = (EqualsAndHashcode) o;
    return id == equalsAndHashcode.id && someField == equalsAndHashcode.someField && Objects.equals(name, equalsAndHashcode.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, someField);
  }
}
