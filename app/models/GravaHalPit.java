package models;

import javax.persistence.Entity;

@Entity
public class GravaHalPit extends Pit {
  private static final long serialVersionUID = 4249684704024541820L;

  /**
   * Creates a GravaHal pit, a pit with 0 stones in it.
   */
  public GravaHalPit() {
    super(0);
  }
}