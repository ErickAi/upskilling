package er.upskilling.sql;

import er.upskilling.sql.domain.Salespeople;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.TestDatabaseAutoConfiguration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

import java.util.List;

@JdbcTest(excludeAutoConfiguration = TestDatabaseAutoConfiguration.class)
@DisplayName(value = "SELECT задачи")
@Slf4j
class SelectTasks {

  @Autowired
  private JdbcTemplate jdbcTemplate;
  @Autowired
  private NamedParameterJdbcOperations jdbcOperations;

  @BeforeEach
  void init() {
    log.info("NEXT TEST");
  }

  @Test
  @DisplayName(value = "Выбрать всех продавцов")
  void getAllSalespeople() {
    List<Salespeople> salespeople = jdbcOperations.query(
        "select * from SALESPEOPLE"
        , new BeanPropertyRowMapper(Salespeople.class));
    for (Salespeople s :salespeople) {
      log.info(s.toString());
    }
  }
}
