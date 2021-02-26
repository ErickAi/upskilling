package er.upskilling.javabasics.serialization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class SerializableField implements Serializable {

  private int id;
  private String name;
}
