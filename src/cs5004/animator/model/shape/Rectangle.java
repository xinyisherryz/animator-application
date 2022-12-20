package cs5004.animator.model.shape;

/**
 * This class represents the rectangle.
 * @author xinyizhang
 *
 */
public class Rectangle extends AbstractShape {

  private int visibleTime;
  private boolean isInitialized;
  
  /**
   * Constructs a rectangle given the inputs.
   * 
   * @param type          the shape type
   * @param position      the position of this rectangle
   * @param size1         the width of this rectangle
   * @param size2         the height of this rectangle
   * @param color         the color of this rectangle
   * @param appearTime    the appear time of this rectangle
   * @param disappearTime the disappear time of this rectangle
   * @throws IllegalArgumentException if the width or height is less than and
   *                                  equal to zero, or the appear time is not
   *                                  earlier than the disappear time
   */
  public Rectangle(String name, ShapeType type, Point2D position, double size1, double size2,
      ColorRGB color, int appearTime, int disappearTime) throws IllegalArgumentException {
    super(name, type, position, size1, size2, color, appearTime, disappearTime);
    this.visibleTime = -1;
    this.isInitialized = false;

  }
  
  @Override
  public Shape clone() {
    return new Rectangle(this.name, this.type, this.position, this.size1, this.size2, this.color,
        this.appearTime, this.disappearTime);
  }

  @Override
  public String toString() {
    String description = "Name: " + this.getName() + "\n"
        + "Type: " + this.type.toString() + "\n"
        + "Min corner: " + this.position.toString()
        + String.format(", Width: %.1f", this.size1)
        + String.format(", Height: %.1f", this.size2)
        + ", Color: " + this.color.toString() + "\n"
        + "Appears at t=" + this.appearTime + "\n"
        + "Disappears at t=" + this.disappearTime + "\n";
    return description;
  }
  
  /**
   * Return the first visible time of this rectangle.
   * @return the first visible time of this rectangle
   */
  @Override
  public int getVisibleTime() {
    return this.visibleTime;
  }
  
  /**
   * Set the first visible time of this rectangle.
   * @param time the new first visible time of this rectangle.
   */
  @Override
  public void setVisibleTime(int time) {
    this.visibleTime = time;
  }

  @Override
  public boolean isInitialized() {
    return this.isInitialized;
  }

  @Override
  public void setInitialized(boolean status) {
    this.isInitialized = status;
  }
}
