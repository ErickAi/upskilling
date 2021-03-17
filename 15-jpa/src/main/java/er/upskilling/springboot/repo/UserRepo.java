package er.upskilling.springboot.repo;

import er.upskilling.springboot.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
