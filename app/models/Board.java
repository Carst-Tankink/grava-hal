package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Board extends Model {
  private static final long serialVersionUID = 628997699036514191L;
  
  @Id private long boardId;
  
  private ArrayList<Side> sides;
  
  public List<Side> getSides() {
    return sides;
  }
  
  public Board() {
    sides = new ArrayList<Side>();
    sides.add(new Side("One"));
    sides.add(new Side("Two"));
  }
}