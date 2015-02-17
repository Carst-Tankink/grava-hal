import static org.fest.assertions.Assertions.assertThat;
import models.RegularPit;

import org.junit.Test;


public class RegularPitTest {
  @Test
  public void takeTest() {
    RegularPit pit = new RegularPit(0);
    int inHand = pit.takeStones();
    
    assertThat(inHand).isEqualTo(6);
    assertThat(pit.isEmpty()).isTrue();
  }
}
