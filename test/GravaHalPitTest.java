import models.GravaHalPit;

import org.junit.Test;

import static org.fest.assertions.Assertions.*;

public class GravaHalPitTest {

  @Test
  public void initialTest() {
    GravaHalPit gravaHal = new GravaHalPit();
    
    assertThat(gravaHal.getContents()).isEqualTo(0);
  }
  
  @Test
  public void putTest() {
    GravaHalPit pit = new GravaHalPit();
    
    int originalValue = pit.getContents();
    pit.putStone();
    assertThat(pit.getContents()).isEqualTo(originalValue + 1); 
  }
}