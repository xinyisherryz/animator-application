package cs5004.animator.model.animation;

import cs5004.animator.model.shape.Point2D;
import cs5004.animator.model.shape.Shape;

/**
 * This class represents animation moving.
 * @author xinyizhang
 *
 */
public class Moving extends AbstractAnimation {

  protected Point2D startPoint;
  protected Point2D endPoint;
  
  /**
   * Constructs a moving animation given the inputs.
   * 
   * @param shapeName  the name of the shape to move
   * @param startTime  the start time to move
   * @param endTime    the end time to move
   * @param startPoint the start point to move
   * @param endPoint   the end point to move
   * @throws IllegalArgumentException if the start time is later than the end
   *                                  time, or start/end time is less than zero,
   *                                  or the shape name is null
   */
  public Moving(String shapeName, int startTime, int endTime,
      Point2D startPoint, Point2D endPoint)
      throws IllegalArgumentException {
    super(shapeName, AnimationForm.Moving, startTime, endTime);
    this.startPoint = startPoint;
    this.endPoint = endPoint;
  }
  
  /**
   * Returns the start point of moving.
   * @return the start point
   */
  public Point2D getStartPoint() {
    return this.startPoint;
  }
  
  /**
   * Returns the end point of moving.
   * @return the end point
   */
  public Point2D getEndPoint() {
    return this.endPoint;
  }
  
  @Override
  public String toString() {
    String description = this.shapeName + " moves from " + this.startPoint.toString()
        + " to " + this.endPoint.toString() + " from time t=" + String.valueOf(this.startTime)
        + " to t=" + String.valueOf(this.endTime) + "\n";
    return description;
  }

  @Override
  public void changeShape(Shape shape, int time) {
    if (this.getStartTime() < time && time <= this.getEndTime()) {
      Point2D point2d = new Point2D(
          this.getMiddle(startTime, endTime, time, this.startPoint.getX(), this.endPoint.getX()),
          this.getMiddle(startTime, endTime, time, this.startPoint.getY(), this.endPoint.getY()));
      shape.setPosition(point2d);
    } else if (time > this.getEndTime()) {
      shape.setPosition(endPoint);
    }
  }
}
