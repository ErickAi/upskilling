package er.upskilling.javabasics;

import er.upskilling.javabasics.serialization.NotSerializableField;
import er.upskilling.javabasics.serialization.SerializableClass;
import er.upskilling.javabasics.serialization.SerializableField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SerializationTest {

  @BeforeEach
  void init() {
    SerializableClass serializableObject = new SerializableClass(1, "name",
        new SerializableField(1, "serializableField"), new NotSerializableField(1, "notSerializableField"));

    try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("serializedObject"))) {
      outputStream.writeObject(serializableObject);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  void serialVersionUid() {
//    SerializableClass serializableObject = new SerializableClass(1, "name",
//        new SerializableField(1, "serializableField"), new NotSerializableField(1, "notSerializableField"));
//    try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("serializedWithNoVersionUID"))) {
//      outputStream.writeObject(serializableObject);
//    } catch (Exception e) {
//      e.printStackTrace();
//    }

    SerializableClass secondVersion = null;
    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("serializedWithNoVersionUID"))) {
      secondVersion = (SerializableClass) inputStream.readObject();
      System.out.println(secondVersion.toString());
    } catch (Exception e) {
      System.out.println("Object not deserialized!!!");
      e.printStackTrace();
    }
    assertNull(secondVersion);
  }

  @Test
  void transientFieldTest() {
    SerializableClass deserializableObject = null;
    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("serializedObject"))) {
      deserializableObject = (SerializableClass) inputStream.readObject();
      System.out.println(deserializableObject.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }
    assertNotNull(deserializableObject);
    assertNull(deserializableObject.getNotSerializable());
  }
}
