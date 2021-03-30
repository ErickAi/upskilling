package er.upskilling.sql.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

  private int onum;
  private float amt;
  private Date odate;
  private int cnum;
  private int snum;
}
