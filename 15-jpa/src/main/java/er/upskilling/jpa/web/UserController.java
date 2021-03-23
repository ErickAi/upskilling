package er.upskilling.jpa.web;

import er.upskilling.jpa.domain.User;
import er.upskilling.jpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/users")
  public List<User> getUsers() {
    return userService.getAll();
  }

  @GetMapping("/users/{id}")
  public User getUser(@PathVariable Long id) {
    return userService.findById(id);
  }

  @GetMapping("/no-trans/{id}")
  public User getchangedUser(@PathVariable Long id) {
    return userService.noTransaction(id);
  }
}
