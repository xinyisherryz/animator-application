package cs5004.animator.model.animation;

import cs5004.animator.model.shape.Shape;

/**
 * This class represents scaling.
 * @author xinyizhang
 *
 */
public class Scaling extends AbstractAnimation {

  protected double fromSize1;
  protected double fromSize2;
  protected double toSize1;
  protected double toSize2;
  
  /**
   * Constructs a scaling animation given the inputs.
   * 
   * @param shapeName the shape name in this scaling animation
   * @param startTime the start time of scaling
   * @param endTime   the end time of scaling
   * @param fromSize1 the start width/X radius of shape
   * @param fromSize2 the start height/Y radius of shape
   * @param toSize1   the end width/X radius of shape
   * @param toSize2   the end height/Y radius of shape
   * @throws IllegalArgumentException if the start time is later than the end
   *                                  time, or start/end time is less than zero,
   *                                  or the shape name is null
   */
  public Scaling(String shapeName, int startTime, int endTime,
      double fromSize1, double fromSize2, double toSize1, double toSize2)
      throws IllegalArgumentException {
    super(shapeName, AnimationForm.Scaling, startTime, endTime);
    this.fromSize1 = fromSize1;
    this.fromSize2 = fromSize2;
    this.toSize1 = toSize1;
    this.toSize2 = toSize2;
  }
  
  
  
  /**
   * Return the start width/X radius of shape.
   * @return the start width/X radius of shape
   */
  public double getFromSize1() {
    return this.fromSize1;
  }
  
  /**
   * Returns the start height/Y radius of shape.
   * @return the start height/Y radius of shape
   */
  public double getFromSize2() {
    return this.fromSize2;
  }
  
  /**
   * Returns the end width/X radius of shape.
   * @return the end width/X radius of shape
   */
  public double getToSize1() {
    return this.toSize1;
  }
  
  /**
   * Returns the end height/Y radius of shape.
   * @return the end height/Y radius of shape
   */
  public double getToSize2() {
    return this.toSize2;
  }
  
  @Override
  public String toString() {
    String description = "";
    if (this.shapeName.equals("R")) {
      description = this.shapeName + String.format(" scales from Width: %.1f", fromSize1)
          + String.format(", Height: %.1f", fromSize2) + String.format(" to Width: %.1f", toSize1)
          + String.format(", Height: %.1f", toSize2) + " from time t=" + String.valueOf(startTime)
          + " to t=" + String.valueOf(endTime) + "\n";
      return description;
    } else {
      description = this.shapeName + String.format(" scales from X radius: %.1f", fromSize1)
          + String.format(", Y radius: %.1f", fromSize2)
          + String.format(" to X radius: %.1f", toSize1)
          + String.format(", Y radius: %.1f", toSize2) + " from time t=" + String.valueOf(startTime)
          + " to t=" + String.valueOf(endTime) + "\n";
      return description;
    }
  }

  @Override
  public void changeShape(Shape shape, int time) {
    if (this.getStartTime() < time && time < this.getEndTime()) {
      shape.setSize1(
          this.getMiddle(startTime, endTime, time, this.getFromSize1(), this.getToSize1()));
      shape.setSize2(
          this.getMiddle(startTime, endTime, time, this.getFromSize2(), this.getToSize2()));
    } else if (time >= this.getEndTime()) {
      shape.setSize1(toSize1);
      shape.setSize2(toSize2);
    }
  }
  
}
