package er.upskilling.modernjava.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(of={"name", "gender", "nat"})
public class User {
  private Name name;
  @JsonProperty(value = "email")
  private String mainEmail;
  private List<String> additionalEmails;
  private String phone;
  private String gender;
  private String nat;
  private Location location;
  private DayOfBirth dob;
  private Registered registered;

}
