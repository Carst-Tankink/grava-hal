package models;

import javax.persistence.Entity;

@Entity
public class RegularPit extends Pit {
  private static final long serialVersionUID = 5441466998278023929L;
  
  private int id;
  
  public String getId() {
    return Integer.toString(id);
  }
  
  /**
   * Take all stones from the pit, making it empty.
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
}
