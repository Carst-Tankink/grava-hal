import models.GravaHalPit;

import org.junit.Test;

import static org.fest.assertions.Assertions.*;

public class GravaHalPitTest {

  @Test
  public void initialTest() {
    GravaHalPit gravaHal = new GravaHalPit();
    
    assertThat(gravaHal.getContents()).isEqualTo(0);
  }
}