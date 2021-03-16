package er.upskilling.springboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="LOCATIONS")
public class Location {

  @Id
  private Long id;
  @OneToOne(optional = false, mappedBy = "location")
  private User user;
  @OneToOne(optional = false)
  @JoinColumn(name = "location_id", unique = true, nullable = false, updatable = false)
  private Street street;
  private String city;
  private String state;
  private String country;
  private String postcode;
}
