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
public class Side extends Model {
  private static final long serialVersionUID = -4636931370644360666L;
  
  @Id private long sideId;
  
  private String title;
  
  @OneToMany(cascade = CascadeType.ALL)
  private List<RegularPit> pits;
  
  @OneToOne(cascade = CascadeType.ALL)
  private GravaHalPit gravaHalPit;

  
  /**
   * @param index
   * @return true iff the index points to a valid, non-empty pit
   */
  public boolean isNotEmpty(int index) {
    return validPit(index) && getPitContents(index) > 0; 
  }

  private boolean validPit(int index) {
    return index >= 0 && index < pits.size();
  }

  /**
   * Make a play starting at the given pit index
   * @param index the pit to start at, zero-based
   * @return a Result, containing remaining stones and whether the last stone landed in the Grava Hal. 
   * Returns a TurnResult of 0 left, not in Grava Hal
   */
  public TurnResult playFrom(int index) {
    if (validPit(index)) {
      RegularPit pit = pits.get(index);
      int stonesLeft = pit.takeStones();
      return sowFrom(stonesLeft, index + 1, true);
    }
    else {
      return new TurnResult(0, false);
    }
  }

  /**
   * Sow the hand given by stonesLeft into the pits starting at start
   * @param stonesLeft Current hand
   * @param start Pit to start sowing in
   * @param includeGravaHal Whether to sow in the side's Grava Hal
   * @return Stones left after sowing
   */
  public TurnResult sowFrom(int stonesLeft, int start, boolean includeGravaHal) {
    boolean lastInGravaHal = false;
    while(stonesLeft > 0 && start < pits.size()) {
      Pit sowIn = pits.get(start);
      stonesLeft = sow(stonesLeft, sowIn);
      start++;
    }
    
    if(stonesLeft > 0 && includeGravaHal) {
      stonesLeft = sow(stonesLeft, gravaHalPit);
      lastInGravaHal = true;
    }
    return new TurnResult(stonesLeft, lastInGravaHal);
  }
  
  private int sow(int hand, Pit pit) {
    pit.putStone();
    return hand - 1;
  }
  
  /**
   * Get the contents of the pit at the given index.
   * If the index is not part of the side, return zero.
   * @param index the index of the pit, zero-based.
   * @return the contents of the pit at the given index
   */
  public int getPitContents(int index) {
    if (validPit(index)) {
      return pits.get(index).getContents();
    }
    else { 
      return 0;
    }
  }
  
  /**
   * Get the contents of the Grava Hal
   * @return the content of the Grava Hal pit.
   */
  public int getGravaHalContents() {
    return gravaHalPit.getContents();
  }
  
  /** Create a side with 6 pits.
   * @param title_ the name of the side. 
   */
  public Side(String title_) {
    title = title_;
    
    int sideLength = 6;
    pits = new ArrayList<RegularPit>(sideLength);
    for(int i = 0; i < sideLength; i++) {
      RegularPit pit = new RegularPit(i);
      pits.add(pit);
    }
    
    gravaHalPit = new GravaHalPit();
  }
  
  public String getTitle() {
    return title;
  }  
  
  public Iterator<RegularPit> getPits() {
    return pits.iterator();
  }
  
  public GravaHalPit getGravaHalPit() {
    return gravaHalPit;
  }
  
}