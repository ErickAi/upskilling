package er.upskilling.jpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"title", "first", "last"})
@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class Name {

  private String title;

  private String first;

  private String last;
}
