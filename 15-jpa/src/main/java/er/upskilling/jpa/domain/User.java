package er.upskilling.jpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

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

  private String phone;
  private String gender;
  private String nat;
}
