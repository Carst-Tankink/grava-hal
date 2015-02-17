import models.GravaHal;

import org.junit.*;

import static org.fest.assertions.Assertions.*;

public class GravaHalTest {
  
  GravaHal game;
  @Before
  public void setUp() {
    game = new GravaHal("Alice", "Bob");
  }
  
  @Test
  public void initGame() {
    assertThat(game.getPlayerOne()).isEqualTo("Alice");
    assertThat(game.getPlayerTwo()).isEqualTo("Bob");
    
    assertThat(game.getActivePlayer()).isEqualTo("Alice");
  }
  
  @Test
  public void testPlay() {
    String playerOne = game.getPlayerOne();
    String playerTwo = game.getPlayerTwo();
    game.playFrom(playerOne, 5);
    
    assertThat(game.contentsAt(playerOne, 5)).isEqualTo(0);
    assertThat(game.contentsAtGravaHal(playerOne)).isEqualTo(1);
    assertThat(game.contentsAt(playerTwo, 0)).isEqualTo(7);
    assertThat(game.contentsAt(playerTwo, 1)).isEqualTo(7);
    assertThat(game.contentsAt(playerTwo, 2)).isEqualTo(7);
    assertThat(game.contentsAt(playerTwo, 3)).isEqualTo(7);
    assertThat(game.contentsAt(playerTwo, 4)).isEqualTo(7);
    assertThat(game.contentsAt(playerTwo, 5)).isEqualTo(6);
    
    
  }
}