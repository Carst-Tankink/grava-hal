package models;


import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import play.db.ebean.Model;

@MappedSuperclass
public class Pit extends Model {

  @Id protected String pitId;
  protected int contents;
  
  protected Pit(int contents_) {
    contents = contents_;
  }
  
  /** Returns the contents of a pit
   * 
   * @return The number of stones in this pit.
   */
  public int getContents() {
    return contents;
  }

  /** Put a stone in the pit.
   */
  public void putStone() {
    contents += 1;
  }

}