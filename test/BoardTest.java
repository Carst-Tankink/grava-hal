import models.Board;

import org.junit.*;

import static org.fest.assertions.Assertions.*;


public class BoardTest {
  @Test
  void initBoardTest() {
    Board board = new Board();
    
    assertThat(board.getSides().size()).isEqualTo(2);
  }
}
