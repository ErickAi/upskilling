package er.upskilling.jpa.service;

import er.upskilling.jpa.domain.User;
import er.upskilling.jpa.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
//@Transactional(value = Transactional.TxType.NEVER)
//@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class UserService {

  private final UserRepo userRepo;

  public List<User> getAll() {
    return userRepo.findAll();
  }

  @Transactional
  public User findById(Long id) {
    User user = userRepo.findById(id).orElseThrow(() -> new NullPointerException("User not found"));
    changeUserEmail(user);
    return user;
  }

  public User noTransaction(Long id) {
    return findById(id);
  }

  private void changeUserEmail(User user) {
    user.setEmail("changed@mail.com");
  }
}
