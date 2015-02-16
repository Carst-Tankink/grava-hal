package models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity
public class Side extends Model {
  private static final long serialVersionUID = -4636931370644360666L;
  
  @Id private long sideId;
  
  private String title;
  
  @OneToMany(cascade = CascadeType.ALL)
  private List<Pit> pits;
  
  @OneToOne(cascade = CascadeType.ALL)
  private GravaHalPit gravaHalPit;

  /** Getter for the side's title.
   * @return The side's title.
   */
  public String getTitle() {
    return title;
  }  
  
  /** Iterator over the pits of this side.
   * 
   * @return The pits of this side, as an iterator
   */
  public Iterator<Pit> getPits() {
    return pits.iterator();
  }
  
  public GravaHalPit getGravaHalPit() {
    return gravaHalPit;
  }
  /** Create a side with 6 pits.
   * @param title_ the name of the side. 
   */
  public Side(String title_) {
    title = title_;
    
    pits = new ArrayList<Pit>();
    for(int i = 0; i < 6; i++) {
      Pit pit = new Pit();
      pits.add(pit);
    }
    
    gravaHalPit = new GravaHalPit();
  }
}