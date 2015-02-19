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
  public void initGameTest() {
    assertThat(game.getPlayerOne()).isEqualTo(playerOne);
    assertThat(game.getPlayerTwo()).isEqualTo(playerTwo);
    
    assertThat(game.getActivePlayer()).isEqualTo(playerOne);
    
    assertThat(game.getPlayerSide("Alice").getTitle()).isEqualTo("One");
    assertThat(game.getPlayerSide(playerTwo).getTitle()).isEqualTo("Two");
  }
  
  @Test
  public void playTest() {
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
  
  @Test
  public void turnChangeTest() {
    game.playFrom(playerOne, 2);
    assertThat(game.getActivePlayer()).isEqualTo(playerTwo);
    
  }
  
  @Test
  public void playNoTurnTest() {
    // Playing when it is not your turn.
    game.playFrom(playerOne, 2);
    assertThat(game.contentsAt(playerOne, 2)).isEqualTo(0);
    game.playFrom(playerOne, 1);
    assertThat(game.contentsAt(playerOne, 2)).isEqualTo(0);
    
    assertThat(game.getActivePlayer()).isEqualTo(playerTwo);
    
  }
  
  @Test
  public void goAgainTest() {
    // Plays ending in the Grava Hal allow you to go again.
    game.playFrom(playerOne, 0);
    assertThat(game.getActivePlayer()).isEqualTo(playerOne);
  }
  
  @Test
  public void emptyPitTest() {
    // (Design assumption) it shouldn't be possible to play from an empty pit.
    game.playFrom(playerOne, 5);
    assertThat(game.contentsAt(playerOne, 5)).isEqualTo(0);
    
    game.playFrom(playerTwo, 1);
    assertThat(game.contentsAt(playerOne, 5)).isEqualTo(0);
    
    game.playFrom(playerOne, 5);
    assertThat(game.contentsAt(playerOne, 5)).isEqualTo(0);
    assertThat(game.getActivePlayer()).isEqualTo(playerOne);
  }
  
  @Test
  public void wrongPlayTest() {
    game.playFrom(playerOne, -1);

    for(int i = 0; i < 6; i++) {
      assertThat(game.contentsAt(playerOne, i)).isEqualTo(6);
      assertThat(game.contentsAtGravaHal(playerOne)).isEqualTo(0);
      assertThat(game.contentsAt(playerTwo, i)).isEqualTo(6);
      assertThat(game.contentsAtGravaHal(playerTwo)).isEqualTo(0);
    }
    
  }
}