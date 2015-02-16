import java.util.Iterator;

import models.Side;
import models.RegularPit;

import org.junit.Test;

import static org.fest.assertions.Assertions.*;

public class SideTest {

  @Test
  public void testInitialContents() {
    Side side = new Side("TestSide");
    
    assertThat(side.getTitle()).isEqualTo("TestSide");
    
    for(Iterator<RegularPit> pI = side.getPits(); pI.hasNext();) {
      RegularPit pit = pI.next();
      assertThat(pit.getContents()).isEqualTo(6);
    }
    
    assertThat(side.getGravaHalPit().getContents()).isEqualTo(0);
  }

  @Test
  public void simplePlayTest() {
    Side side = new Side("TestSide");
    
    int remainder = side.playFrom(0);
    
    assertThat(remainder).isEqualTo(0);
    
    Iterator<RegularPit> pI = side.getPits();
    
    RegularPit first = pI.next();
    assertThat(first.isEmpty()).isTrue();
    
    while (pI.hasNext()) {
      RegularPit pit = pI.next();
      assertThat(pit.getContents()).isEqualTo(7);
    }
    
    assertThat(side.getGravaHalPit().getContents()).isEqualTo(1);
  }
  
  
}
