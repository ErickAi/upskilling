package er.upskilling.javabasics;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class EqualAndHashcodeTest {

  @Test
  public void hashcode() {
    EqualsAndHashcode ivan = new EqualsAndHashcode(1, "Ivan", 11);
    EqualsAndHashcode piter = new EqualsAndHashcode(2, "Piter", 11);

    System.out.println("Ivan hashcode: " + ivan.hashCode() + "\nPiter hashcode: " + piter.hashCode());
    HashSet<EqualsAndHashcode> people = new HashSet<>();
    people.add(ivan);
    people.add(piter);
    updateAge(people);


    System.out.println(people.contains(ivan));
  }

  public static void updateAge(HashSet<EqualsAndHashcode> people) {
    for (EqualsAndHashcode equalsAndHashcode : people) {
      equalsAndHashcode.setSomeField(equalsAndHashcode.getSomeField() + 1);
      System.out.println("hashcode: " + equalsAndHashcode.hashCode());
    }
  }
}
