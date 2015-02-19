package models;

import javax.persistence.Entity;

@Entity
public class GravaHalPit extends Pit {
  /**
   * Creates a GravaHal pit, a pit with 0 stones in it.
   */
  public GravaHalPit() {
    super(0);
  }
}