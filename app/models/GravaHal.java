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
  
  public GravaHal(String playerOne_, String playerTwo_) {
    playerOne = playerOne_;
    playerTwo = playerTwo_;
    
    activePlayer = playerOne;
    
    board = new ArrayList<Side>();
    board.add(new Side("One"));
    board.add(new Side("Two"));
  }
}
