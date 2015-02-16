import java.util.Iterator;

import models.Side;
import models.Pit;

import org.junit.Test;

import static org.fest.assertions.Assertions.*;

public class SideTest {

  @Test
  public void testInitialContents() {
    Side side = new Side("TestSide");
    
    assertThat(side.getTitle()).isEqualTo("TestSide");
    
    for(Iterator<Pit> pI = side.getPits(); pI.hasNext();) {
      Pit pit = pI.next();
      assertThat(pit.getContents()).isEqualTo(6);
    }
    
    assertThat(side.getGravaHalPit().getContents()).isEqualTo(0);
  }

}
