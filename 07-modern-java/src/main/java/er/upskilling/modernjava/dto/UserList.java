package er.upskilling.modernjava.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import er.upskilling.modernjava.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserList {
  List<User> results;
}
