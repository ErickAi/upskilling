package er.upskilling.springboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="NAMES")
@Access(AccessType.FIELD)
public class Name {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @OneToOne(optional = false)
  @JoinColumn(name="user_id", unique = true, nullable = false)
  private User user;
  @Column(name = "title")
  @Size(max = 128)
  private String title;
  @Column(name = "first")
  @Size(max = 128)
  private String first;
  @Column(name = "last")
  @Size(max = 128)
  private String last;
}
