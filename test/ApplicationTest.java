import models.GravaHal;

import org.junit.*;

import play.twirl.api.Content;
import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;


/**
*
* Unit tests for the game.
*
*/
public class ApplicationTest {

    @Test
    public void initGame() {
      GravaHal game = new GravaHal("Alice", "Bob");
      assertThat(game.getPlayerOne()).isEqualTo("Alice");
      assertThat(game.getPlayerTwo()).isEqualTo("Bob");
      
      assertThat(game.getActivePlayer()).isEqualTo("Alice");
    }
}
