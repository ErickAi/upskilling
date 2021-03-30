package er.upskilling.modernjava;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CodingTask {

  @Test
  void test() {
//Дана строка, нужно вывести количество каждого имени в строке и отсортировать по количеству(обратный порядок), а потом по имени.
    String str = "Charlie Jennifer Charlie Bob Charlie Charlie Bob Jennifer Alice Alice";
    Arrays.stream(str.split(" "))
        .collect(
            Collectors.collectingAndThen(
                Collectors.groupingBy(Function.identity(), Collectors.counting()),
                stringLongMap -> stringLongMap.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue()
                    .reversed()
                    .thenComparing(Map.Entry.comparingByKey()))
                    .collect(Collectors.toList())
            )
        ).forEach(e -> System.out.println(e.getValue() + " " + e.getKey()));
  }
}
