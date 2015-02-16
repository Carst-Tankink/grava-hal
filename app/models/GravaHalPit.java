package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class GravaHalPit extends Model {
  private static final long serialVersionUID = 4249684704024541820L;

  @Id private String gravaHalId;
  
  private int contents;
  
  public int getContents() {
    return contents;
  }
  
  public GravaHalPit() {
    contents = 0;
  }
}