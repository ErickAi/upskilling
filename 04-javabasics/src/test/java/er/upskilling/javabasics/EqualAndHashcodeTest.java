package er.upskilling.javabasics;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

public class EqualAndHashcodeTest {

  @Test
  public void hashcode() {
    Person ivan = new Person(1, "Ivan", 11);
    Person piter = new Person(2, "Piter", 11);

    System.out.println("Ivan hashcode: " + ivan.hashCode() + "\nPiter hashcode: " + piter.hashCode());
    HashSet<Person> people = new HashSet<>();
    people.add(ivan);
    people.add(piter);
    updateAge(people);


    System.out.println(people.contains(ivan));
  }

  public static void updateAge(HashSet<Person> people) {
    for (Person person : people) {
      person.setAge(person.getAge() + 1);
      System.out.println("hashcode: " + person.hashCode());
    }
  }
}
