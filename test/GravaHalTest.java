import models.GravaHal;

import org.junit.*;

import static org.fest.assertions.Assertions.*;

public class GravaHalTest {
  
  GravaHal game;
  String playerOne = "Alice";
  String playerTwo = "Bob";
  
  @Before
  public void setUp() {
    game = new GravaHal(playerOne, playerTwo);
  }
  
  @Test
  public void initGame() {
    assertThat(game.getPlayerOne()).isEqualTo(playerOne);
    assertThat(game.getPlayerTwo()).isEqualTo(playerTwo);
    
    assertThat(game.getActivePlayer()).isEqualTo(playerOne);
  }
  
  @Test
  public void testPlay() {
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
  
  @Test
  public void skipOpposingGHTest() {
    // Never sow in an opposing Grava Hal.
    game.playFrom(playerOne, 0);
    assertThat(game.contentsAtGravaHal(playerOne)).isEqualTo(1);
    
    // Player one goes again.
    game.playFrom(playerOne, 1);
    assertThat(game.contentsAt(playerOne, 5)).isEqualTo(8);
    
    // Any play by player two, not giving him another turn
    game.playFrom(playerTwo, 1);
    assertThat(game.contentsAtGravaHal(playerTwo)).isEqualTo(1);
    assertThat(game.contentsAt(playerOne, 0)).isEqualTo(1);
    
    game.playFrom(playerOne, 5); 
    assertThat(game.contentsAtGravaHal(playerTwo)).isEqualTo(1);
    assertThat(game.contentsAt(playerOne, 0)).isEqualTo(2);
  }
}