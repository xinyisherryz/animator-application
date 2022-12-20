package cs5004.animator.model.shape;

/**
 * This class represents oval.
 * @author xinyizhang
 *
 */
public class Oval extends AbstractShape {
  
  private int visibleTime;
  private boolean isInitialized;

  /**
   * Constructs an oval given the following inputs.
   * 
   * @param type          the shape type
   * @param position      the position of this oval
   * @param size1         the X radius of this oval
   * @param size2         the Y radius of this oval
   * @param color         the color of this oval
   * @param appearTime    the appear time of this oval
   * @param disappearTime the disappear time of this oval
   * @throws IllegalArgumentException if the X radius or Y radius is less than and
   *                                  equal to zero, or the appear time is not
   *                                  earlier than the disappear time
   */
  public Oval(String name, ShapeType type, Point2D position, double size1, double size2,
      ColorRGB color, int appearTime, int disappearTime) throws IllegalArgumentException {
    super(name, type, position, size1, size2, color, appearTime, disappearTime);
    this.visibleTime = -1;
    this.isInitialized = false;
  }

  @Override
  public Shape clone() {
    return new Oval(this.name, this.type, this.position, this.size1, this.size2, this.color,
        this.appearTime, this.disappearTime);
  }
  
  @Override
  public String toString() {
    String description = "Name: " + this.getName() + "\n"
        + "Type: " + this.type.toString() + "\n"
        + "Center: " + this.position.toString()
        + String.format(", X radius: %.1f", this.size1)
        + String.format(", Y radius: %.1f", this.size2)
        + ", Color: " + this.color.toString() + "\n"
        + "Appears at t=" + this.appearTime + "\n"
        + "Disappears at t=" + this.disappearTime + "\n";
    return description;
  }
  
  /**
   * Return the first visible time of this oval.
   * @return the first visible time of this oval
   */
  @Override
  public int getVisibleTime() {
    return this.visibleTime;
  }
  
  /**
   * Set the first visible time of this oval.
   * @param time the new first visible time of this oval.
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
