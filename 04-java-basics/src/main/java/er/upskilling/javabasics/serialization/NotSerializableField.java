package er.upskilling.javabasics.serialization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NotSerializableField {

  private int id;
  private String name;
}
