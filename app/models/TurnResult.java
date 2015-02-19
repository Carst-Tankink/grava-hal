package models;

public class TurnResult {
  private int inHand;
  private boolean inGravaHal;
  
  public TurnResult(int inHand_, boolean inGravaHal_) {
    inHand = inHand_;
    inGravaHal = inGravaHal_;
  }
  
  public int getInHand() { return inHand; }
  public boolean getInGravaHal() { return inGravaHal; }
}