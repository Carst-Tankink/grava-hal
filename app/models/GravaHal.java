package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class GravaHal extends Model {
  private static final long serialVersionUID = -700730502688708739L;
  
  
  @Id private String gameId;
  private String playerOne;
  private String playerTwo;
  
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
    return playerOne;
  }

  public GravaHal(String playerOne_, String playerTwo_) {
    playerOne = playerOne_;
    playerTwo = playerTwo_;
  }
}
