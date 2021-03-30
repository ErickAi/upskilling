package er.upskilling.sql;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.h2.tools.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class H2serverConfig {

  private final DataSource dataSource;

  @Bean(initMethod = "start", destroyMethod = "stop")
  public Server h2Server() throws SQLException {
    log.info("Start H2 TCP server");
    System.out.println(dataSource.getLoginTimeout());
    return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "5656");
  }

  @Bean(initMethod = "start", destroyMethod = "stop")
  public Server h2WebServer() throws SQLException {
    log.info("Start H2 WEB server");
    return Server.createWebServer("-web", "-webAllowOthers", "-webPort", "6565");
  }
}