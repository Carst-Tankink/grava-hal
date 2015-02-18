package models;

public class TurnResult {
  private int inHand;
  private Pit lastPit;
  
  public int getInHand() { return inHand; }
  public Pit getLastPit() { return lastPit; }
  
  public TurnResult(int inHand_, Pit lastPit_) {
    inHand = inHand_;
    lastPit = lastPit_;
  }
}