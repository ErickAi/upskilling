package er.upskilling.jpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(of = {"name", "gender", "nat"})
@Entity
@Table(name = "USERS")
@SequenceGenerator(name = "user_seq", initialValue = 1000)
public class User {

  @Id
  @GeneratedValue(generator = "user_seq")
  private Long id;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "title", column = @Column(name = "name_title")),
      @AttributeOverride(name = "first", column = @Column(name = "first_name")),
      @AttributeOverride(name = "last", column = @Column(name = "last_name"))})
  private Name name;

  @Column(name = "email", nullable = false, unique = true)
  @Email
  @NotEmpty
  @Size(max = 128)
  private String email;

  @ElementCollection
  private List<String> phones = new ArrayList<>();

  private String phone;
  private String gender;
  private String nat;
}
