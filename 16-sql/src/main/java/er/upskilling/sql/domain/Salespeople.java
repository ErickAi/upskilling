package er.upskilling.sql.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Salespeople {

  private int snum;
  private String Sname;
  private String city;
  private float comm;
}
