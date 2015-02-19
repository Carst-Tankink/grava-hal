package models;

import javax.persistence.Entity;

@Entity
public class RegularPit extends Pit {
   private int id;
  
  /**
   * Take all stones from the pit.
   * 
   * @return the number of stones that were in the pit
   */
  public int takeStones() {
    int stones = contents;
    contents = 0;
    return stones;
  }
  
  /** Creates a full pit, with 6 stones
   */
  public RegularPit(int id_) {
    super(6);
    id = id_;
  }
  
  public int getId() {
    return id;
  }
  
}
