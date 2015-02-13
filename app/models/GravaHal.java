package models;

public class GravaHal {
  private String _playerOne;
  private String _playerTwo;
  
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
