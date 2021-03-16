package er.upskilling.springboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(of={"name", "gender", "nat"})
@Entity
@Table(name = "USERS")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @OneToOne(optional = false)
  @JoinColumn(name="user_id", unique = true, nullable = false, insertable = false, updatable = false)
  private Name name;

  @Enumerated(EnumType.STRING)
  @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
  @Column(name = "role")
  @ElementCollection(fetch = FetchType.EAGER)

  private Set<Role> roles;
  @Column(name = "email", nullable = false, unique = true)
  @Email
  @NotEmpty
  @Size(max = 128)
  private String email;
  private String phone;
  private String gender;
  private String nat;
  @OneToOne(optional = false)
  @JoinColumn(name="user_id", unique = true, nullable = false, insertable = false, updatable = false)
  private Location location;

}
