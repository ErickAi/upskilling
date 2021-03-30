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
public class SerializableClass implements Serializable {

  public static final long serialVersionUID = 2689400984223723610L;   //first serialVersionUID = 3530627270033980617L;

  private int id;
  private String name;
  private SerializableField serializable;
  transient private NotSerializableField notSerializable;
}
