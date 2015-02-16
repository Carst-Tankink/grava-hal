package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Side extends Model {
  private static final long serialVersionUID = -4636931370644360666L;
  
  @Id private long sideId;
  
  private String title;
  
  public String getTitle() {
    return title;
  }
  
  public Side(String title_) {
    title = title_;
  }
}
