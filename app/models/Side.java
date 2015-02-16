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

  /** Getter for the side's title.
   * @return The side's title.
   */
  public String getTitle() {
    return title;
  }  
  
  /** 
   * Iterator over the pits of this side.
   * @return The pits of this side, as an iterator
   */
  public Iterator<RegularPit> getPits() {
    return pits.iterator();
  }
  
  /** Getter for this side's Grava Hal
   * 
   * @return The Grava Hal
   */
  public GravaHalPit getGravaHalPit() {
    return gravaHalPit;
  }
  
  
  private int sow(int hand, Pit pit) {
    pit.putStone();
    return hand - 1;
  }
  /**
   * Make a play starting at the given pit index
   * @param index the pit to start at, zero-based
   * @return the amount of stones after filling the side
   */
  public int playFrom(int index) {
    RegularPit pit = pits.get(index);
    int stonesLeft = pit.takeStones();
    int sowAt = index + 1;
    
    while(stonesLeft > 0 && sowAt < pits.size()) {
      Pit sowIn = pits.get(sowAt);
      stonesLeft = sow(stonesLeft, sowIn);
      sowAt++;
    }
    
    if(stonesLeft > 0) {
      stonesLeft = sow(stonesLeft, gravaHalPit);
    }
    
    return stonesLeft;
  }
  
  /**
   * Get the contents of the pit at the given index
   * @param index the index of the pit, zero-based.
   * @return the contents of the pit at the given index
   */
  public int getPitContents(int index) {
    return pits.get(index).getContents(); 
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
      RegularPit pit = new RegularPit();
      pits.add(pit);
    }
    
    gravaHalPit = new GravaHalPit();
  }
}