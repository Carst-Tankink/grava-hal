package models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity
public class GravaHal extends Model {
  private static final long serialVersionUID = -700730502688708739L;
  
  /* For persistence. */
  @Id private String gameId;

  /* Players: the game has two players, one of which is active (has the turn) 
  */
  private String playerOne;
  private String playerTwo;
  private String activePlayer;

  /* The game board */  
  @OneToMany(cascade = CascadeType.ALL)
  private List<Side> board;
  
  public String getGameId() {
    return gameId;
  }
  
  public String getPlayerOne() {
    return playerOne;
  }
  
  public String getPlayerTwo() {
    return playerTwo;
  }
  
  public String getActivePlayer() { 
    return activePlayer;
  }

  public Iterator<Side> getSides() {
    return board.iterator();
  }
  
  public void playFrom(String player, int pitIndex) {
    Side playerSide = getPlayerSide(player);
    Side currentSide = playerSide;
    
    int inHand = playerSide.playFrom(pitIndex);
    
    // TODO:  Refactor to method.
    while (inHand > 0) {
      currentSide = getNextSide(currentSide);
      Iterator<RegularPit> pI = currentSide.getPits();
      
      while (pI.hasNext() && inHand > 0) {
        RegularPit pit = pI.next();
        pit.putStone();
        inHand--;
      }

      if (inHand > 0 && currentSide == playerSide) {
        currentSide.getGravaHalPit().putStone();
        inHand--;
      }
    }
  }
  
  private Side getNextSide(Side side) {
    int index = board.indexOf(side);
    return board.get((index + 1) % 2);
  }
  
  private Side getPlayerSide(String player) {
    // TODO: Better mapping of player -> side
    int playerIndex = (player == playerOne) ? 0 : 1;
    Side playerSide = board.get(playerIndex);
    return playerSide;
  }
  
  public int contentsAt(String player, int pitIndex) {
    Side side = getPlayerSide(player);
    return side.getPitContents(pitIndex);
  }
  
  public int contentsAtGravaHal(String player) {
    return getPlayerSide(player).getGravaHalContents();
  }
  
  public GravaHal(String playerOne_, String playerTwo_) {
    playerOne = playerOne_;
    playerTwo = playerTwo_;
    
    activePlayer = playerOne;
    
    board = new ArrayList<Side>();
    board.add(new Side("One"));
    board.add(new Side("Two"));
  }
}
