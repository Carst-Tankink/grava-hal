import models.Pit;
import models.RegularPit;

import org.junit.*;

import static org.fest.assertions.Assertions.*;


public class PitTest {
  @Test
  public void pitTest() {
    Pit pit = new RegularPit();
    
    int initialContent = pit.getContents();
    pit.putStone();
    assertThat(pit.getContents()).isEqualTo(initialContent + 1);
    
  }
}
