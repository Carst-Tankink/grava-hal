package models;


import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import play.db.ebean.Model;

@MappedSuperclass
public class Pit extends Model {
  @Id protected String pitId;
  protected int contents;
 
  /** Put a stone in the pit.
   */
  public void putStone() {
    contents += 1;
  }
  
  public int getContents() {
    return contents;
  }

  /** 
   * Check if the pit is empty 
   */
  public boolean isEmpty() {
    return contents == 0;
  }

  
  protected Pit(int contents_) {
    contents = contents_;
  } 
}