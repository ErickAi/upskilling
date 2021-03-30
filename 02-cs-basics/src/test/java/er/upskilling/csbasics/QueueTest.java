package er.upskilling.csbasics;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QueueTest {

  @Test
  void poll() {
    Queue<String> queue = new PriorityQueue<>(7);
    String a = "a";
    String b = "b";
    queue.add(a);
    queue.add(b);
    String poll = queue.poll();
    assertEquals(a, poll);
    assertEquals(1, queue.size());
  }
}
