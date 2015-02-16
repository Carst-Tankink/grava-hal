package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;


@Entity
public class Pit extends Model {
  private static final long serialVersionUID = 5441466998278023929L;
  
  @Id private String pitId;
  
  private int contents;
  
  /** Returns the contents of a pit
   * 
   * @return The number of stones in this pit.
   */
  public int getContents() {
    return contents;
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
  
  /**
   * Put a stone in the pit.
   */
  public void putStone() {
    contents += 1;
  }

  public boolean isEmpty() {
    return contents > 0;
  }
  
  /** Creates a full pit, with 6 stones
   */
  public Pit() {
    contents = 6;
  }
}
