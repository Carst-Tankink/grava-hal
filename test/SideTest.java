import java.util.Iterator;

import models.Side;
import models.RegularPit;

import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.*;

public class SideTest {
  
  Side side;
  
  @Before
  public void setUp() {
    side = new Side("TestSide");
  }
  
  @Test
  public void testInitialContents() {  
    assertThat(side.getTitle()).isEqualTo("TestSide");
    
    for(Iterator<RegularPit> pI = side.getPits(); pI.hasNext();) {
      RegularPit pit = pI.next();
      assertThat(pit.getContents()).isEqualTo(6);
    }
    
    assertThat(side.getGravaHalPit().getContents()).isEqualTo(0);
  }

  @Test
  public void simplePlayTest() {
    int remainder = side.playFrom(0).getInHand();

    assertThat(remainder).isEqualTo(0);

    Iterator<RegularPit> pI = side.getPits();

    RegularPit first = pI.next();
    assertThat(first.isEmpty()).isTrue();

    while (pI.hasNext()) {
      RegularPit pit = pI.next();
      assertThat(pit.getContents()).isEqualTo(7);
    }

    assertThat(side.getGravaHalContents()).isEqualTo(1);
  }
  
  @Test
  public void playAtEndTest() {
    int remainder = side.playFrom(5).getInHand();

    assertThat(remainder).isEqualTo(5);
    assertThat(side.getPitContents(5)).isEqualTo(0);
    assertThat(side.getGravaHalContents()).isEqualTo(1);
  }
  
  @Test
  public void illegalPlayTest() {
    assertThat(side.getPitContents(6)).isEqualTo(0);
    side.playFrom(6);
    
    for(int i = 0; i < 6; i++) {
      assertThat(side.getPitContents(i)).isEqualTo(6);
    }
    
    assertThat(side.getGravaHalContents()).isEqualTo(0);
  }
}
