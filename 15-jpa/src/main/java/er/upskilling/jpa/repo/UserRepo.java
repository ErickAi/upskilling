package er.upskilling.jpa.repo;

import er.upskilling.jpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

  User findByEmail(String email);
}
