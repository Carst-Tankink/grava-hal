package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class GravaHal extends Model {
  private static final long serialVersionUID = -700730502688708739L;
  
  private String _playerOne;
  private String _playerTwo;
  
  @Id
  public String gameId;
  
  public GravaHal(String playerOne, String playerTwo) {
    _playerOne = playerOne;
    _playerTwo = playerTwo;
  }
  
  public String getPlayerOne() { 
    return _playerOne; 
  }
  
  public String getPlayerTwo() { 
    return _playerTwo;
  }
  
  public String getActivePlayer() { 
    return _playerOne; 
  }
}
