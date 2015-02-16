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
  
  /** Creates a full pit, with 6 stones
   */
  public Pit() {
    contents = 6;
  }
}
