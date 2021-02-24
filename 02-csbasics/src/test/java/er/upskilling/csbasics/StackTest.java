package er.upskilling.csbasics;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;


class StackTest {

  @Test
  void remove() {
    String a = "a";
    Stack<String> stack = new Stack<>();
    stack.push(a);
    String pop = stack.pop();
    System.out.println(pop);
    assertEquals(pop,a);
    assertTrue(stack.empty());
  }

  @Test
  void justPeek() {
    String a = "a";
    Stack<String> stack = new Stack<>();
    stack.push(a);
    String peek = stack.peek();
    System.out.println(peek);
    assertEquals(peek,a);
    assertFalse(stack.empty());
  }

}
