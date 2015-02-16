package models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import play.db.ebean.Model;

@Entity
public class Board extends Model {
  private static final long serialVersionUID = 628997699036514191L;
  
  @Id private long boardId;
  
  @OneToMany(cascade = CascadeType.ALL)
  private List<Side> sides;
  
  /** Width of the board
   * @return The number of sides the board has
   */
  public Iterator<Side> getSides() {
    return sides.iterator();
  }
  
  /** Create an initial board.
   *  The board contains two sides, named One and Two. 
   */
  public Board() {
    sides = new ArrayList<Side>();
    sides.add(new Side("One"));
    sides.add(new Side("Two"));
  }
}