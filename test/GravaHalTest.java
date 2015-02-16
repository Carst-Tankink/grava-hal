import models.GravaHal;
import models.Board;

import org.junit.*;

import static org.fest.assertions.Assertions.*;

public class GravaHalTest {
  /* Initializing a two-player game, with the first player active.
   */
  @Test
  public void initGame() {
    GravaHal game = new GravaHal("Alice", "Bob");
    assertThat(game.getPlayerOne()).isEqualTo("Alice");
    assertThat(game.getPlayerTwo()).isEqualTo("Bob");
    
    assertThat(game.getActivePlayer()).isEqualTo("Alice");
    
    Board board = game.getBoard();
    assertThat(board.getSides().size()).isEqualTo(2);
  }
}