package er.upskilling.jpa.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import er.upskilling.jpa.domain.User;
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
