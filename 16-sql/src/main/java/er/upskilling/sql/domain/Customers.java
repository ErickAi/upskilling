package er.upskilling.sql.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customers {

  private int cnum;
  private String cname;
  private String city;
  private int rating;
  private int snum;
}
