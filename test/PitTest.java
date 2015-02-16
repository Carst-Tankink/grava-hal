import models.Pit;

import org.junit.*;

import static org.fest.assertions.Assertions.*;


public class PitTest {

  @Test
  public void initPitTest() {
    Pit pit = new Pit();
    assertThat(pit.getContents()).isEqualTo(6);
  }
  
  @Test
  public void takeTest() {
    Pit pit = new Pit();
    int inHand = pit.takeStones();
    
    assertThat(inHand).isEqualTo(6);
    assertThat(pit.isEmpty());  
  }
  
  @Test
  public void putTest() {
    Pit pit = new Pit();
    
    assertThat(pit.getContents()).isEqualTo(6);
    pit.putStone();
    assertThat(pit.getContents()).isEqualTo(7);
    
  }
}
