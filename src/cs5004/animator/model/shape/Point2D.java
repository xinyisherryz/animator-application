package cs5004.animator.model.shape;

/**
 * This class represents a 2D point. This point is denoted as (x,y).
 */
public class Point2D {

  private double x;
  private double y;
  
  /**
   * Construct a 2d point with the given coordinates.
   * @param x the x-coordinate of this point
   * @param y the y-coordinate of this point
   */
  public Point2D(double x, double y) {
    this.x = x;
    this.y = y;
  }
  
  /**
   * Return the x-coordinate of this point.
   * @return x-coordinate
   */
  public double getX() {
    return x;
  }
  
  /**
   * Return the y-coordinate of this point.
   * @return y-coordinate
   */
  public double getY() {
    return y;
  }
  
  @Override
  public String toString() {
    return String.format("(%.1f, %.1f)", this.x, this.y);
    
  }
}
