package er.upskilling.jpa.config;

import er.upskilling.jpa.domain.User;
import er.upskilling.jpa.dto.UserList;
import er.upskilling.jpa.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class H2serverConfig {

  private final UserRepo userRepo;

  @Bean(initMethod = "start", destroyMethod = "stop")
  public Server h2Server() throws SQLException {
    log.info("Start H2 TCP server");
    return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "5656");
  }

  @Bean(initMethod = "start", destroyMethod = "stop")
  public Server h2WebServer() throws SQLException {
    log.info("Start H2 WEB server");
    return Server.createWebServer("-web", "-webAllowOthers", "-webPort", "6565");
  }

  @PostConstruct
  public void initData() {
    if (!userRepo.existsById(1000L)) {
      RestTemplate restTemplate = new RestTemplate();
      List<User> users = Objects.requireNonNull(restTemplate.getForObject(
          "https://randomuser.me/api/?exc=login,cell,id,picture&noinfo&nat=us,gb,au&results=100"
          , UserList.class)).getResults();
      userRepo.saveAll(users);

/*
      long counter = 0;
      for (User u : users) {
        u.getName().setUser(u);
        u.getLocation().setUser(u);
        u.getLocation().getStreet().setLocation(u.getLocation());
        u.setRoles(Set.of(Role.ROLE_USER));
        if (counter == 0L) {
        u.setRoles(Set.of(Role.ROLE_USER, Role.ROLE_MODERATOR, Role.ROLE_ADMIN));
        counter += 1;
      } else {
        if (counter < 1005) {
          u.setRoles(Set.of(Role.ROLE_USER, Role.ROLE_MODERATOR));
          counter += 1;
        } else {
          u.setRoles(Collections.singleton(Role.ROLE_USER));
        }
      }
        userRepo.save(u);
      }
*/
    }
  }
}