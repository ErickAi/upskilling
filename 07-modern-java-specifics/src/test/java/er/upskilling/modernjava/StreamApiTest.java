package er.upskilling.modernjava;

import er.upskilling.modernjava.domain.User;
import er.upskilling.modernjava.dto.UserList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamApiTest {

  private static List<User> USERS;
  private static final Random random = new Random();

  @BeforeAll
  static void init() {
    RestTemplate restTemplate = new RestTemplate();
    USERS = Objects.requireNonNull(restTemplate.getForObject(
        "https://randomuser.me/api/?exc=login,cell,id,picture&noinfo&nat=us,gb,au&results=100"
        , UserList.class)).getResults();
    USERS.forEach(u -> addAdditionalEmail.accept(u));
  }

  // выбрать всех незамужних женщин старше 18ти лет отсортировать по возрасту. вывести имя и возраст
  @Test
  void filterCompare() {
    USERS.stream()
        .filter(u -> u.getName().getTitle().equalsIgnoreCase("miss"))
        .filter(u -> u.getDob().getAge() > 18)
//        .sorted((u1, u2) -> u1.getDob().getAge() - u2.getDob().getAge())
        .sorted(Comparator.comparingInt(u -> u.getDob().getAge()))
        .forEach(u -> System.out.println(u.getName() + " " + u.getDob().getAge()));
  }

  @Test
  void flatMap() {
    // пользователь содержит список дополнительных email'ов (String). коллекция может быть null, пустой и содержать элементы.
    // подсчитать коллекции additionalEmails: сколько содержат , mail, parcel, container
    // имена пользователей с null, и empty коллекциями вывести на экран
    Map<String, List<User>> nullEmptyEmails = new HashMap<>();
    USERS.stream()
        .map(user -> {
          if (user.getAdditionalEmails() == null) {
            if (!nullEmptyEmails.containsKey("null")) {
              nullEmptyEmails.put("null", new ArrayList<>());
            }
            nullEmptyEmails.get("null").add(user);
          } else if (user.getAdditionalEmails().isEmpty()) {
            if (!nullEmptyEmails.containsKey("empty")) {
              nullEmptyEmails.put("empty", new ArrayList<>());
            }
            nullEmptyEmails.get("empty").add(user);
          } else {
            return user.getAdditionalEmails();
          }
          return Collections.emptyList();
        })
        .flatMap(Collection::stream).map(s -> ((String) s).substring(((String) s).indexOf('@')))
        .collect(
            Collectors.collectingAndThen(
                Collectors.groupingBy(Function.identity(), Collectors.counting()),
                stringLongMap -> new ArrayList<Map.Entry<?, Long>>(stringLongMap.entrySet())
            )
        ).forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

    for (Map.Entry<String, List<User>> stEntry : nullEmptyEmails.entrySet()) {
      System.out.printf("users with %s additionalEmails %s\n", stEntry.getKey(), stEntry.getValue().size());
      for (User user : stEntry.getValue()) {
        System.out.println(user.getName());
      }
    }
  }

  static Consumer<User> addAdditionalEmail = user -> {
    if (random.nextBoolean()) {
      List<String> additionalEmails = new ArrayList<>();
      additionalEmails.add(user.getName().getFirst() + getRandomInt() + "@mail.com");
      user.setAdditionalEmails(additionalEmails);
    } else if (random.nextBoolean()) {
      List<String> additionalEmails = new ArrayList<>();
      additionalEmails.add(user.getName().getFirst() + getRandomInt() + "@parcel.com");
      user.setAdditionalEmails(additionalEmails);
    }
    if (user.getAdditionalEmails() != null && random.nextBoolean()) {
      user.getAdditionalEmails().add(user.getName().getFirst() + getRandomInt() + "@container.com");
    }
    if (user.getAdditionalEmails() == null && random.nextBoolean()) {
      user.setAdditionalEmails(Collections.emptyList());
    }
  };

  static int getRandomInt() {
    var first = random.ints(11111, 99999).findFirst();
    if (first.isPresent())
      return first.getAsInt();
    return 11111;
  }

}
