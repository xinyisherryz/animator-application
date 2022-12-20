package cs5004.animator.model.animation;

import cs5004.animator.model.shape.ColorRGB;
import cs5004.animator.model.shape.Shape;

/**
 * This class represents changing color animation.
 * @author xinyizhang
 *
 */
public class ChangingColor extends AbstractAnimation {

  protected ColorRGB startColor;
  protected ColorRGB endColor;
  
  /**
   * Constructs a changing color animation given the inputs.
   * 
   * @param shapeName  the name of the shape
   * @param startTime  the start time of changing color
   * @param endTime    the end time of changing color
   * @param startColor the start color
   * @param endColor   the end color
   * @throws IllegalArgumentException if the start time is later than the end
   *                                  time, or start/end time is less than zero,
   *                                  or the shape name is null
   */
  public ChangingColor(String shapeName, int startTime, int endTime, 
      ColorRGB startColor, ColorRGB endColor)
      throws IllegalArgumentException {
    super(shapeName, AnimationForm.ChangingColor, startTime, endTime);
    this.startColor = startColor;
    this.endColor = endColor;
  }

  /**
   * Returns the start color. 
   * @return start color
   */
  public ColorRGB getStartColor() {
    return this.startColor;
  }
  
  /**
   * Returns the end color.
   * @return end color
   */
  public ColorRGB getEndColor() {
    return this.endColor;
  }
  
  @Override
  public String toString() {
    String description = this.shapeName + " changes color from "
        + this.startColor.toString() + " to " + this.endColor.toString()
        + " from time t=" + String.valueOf(startTime) 
        + " to t=" + String.valueOf(endTime) + "\n";
    return description;
  }

  @Override
  public void changeShape(Shape shape, int time) {
    if (this.getStartTime() < time && time < this.getEndTime()) {
      ColorRGB color = new ColorRGB(
          this.getMiddle(startTime, endTime, time, this.startColor.getR(), this.endColor.getR()),
          this.getMiddle(startTime, endTime, time, this.startColor.getG(), this.endColor.getG()),
          this.getMiddle(startTime, endTime, time, this.startColor.getB(), this.endColor.getB()));
      shape.setColor(color);
    } else if (time >= this.getEndTime()) {
      shape.setColor(endColor);
    }
  }
 
  
}
