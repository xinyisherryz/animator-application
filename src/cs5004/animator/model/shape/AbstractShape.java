package cs5004.animator.model.shape;

/**
 * This class represents the abstract shape which implements interface Shape.
 * @author xinyizhang
 *
 */
public abstract class AbstractShape implements Shape {

  protected ShapeType type;
  protected Point2D position;
  protected double size1;
  protected double size2;
  protected ColorRGB color;
  protected int appearTime;
  protected int disappearTime;
  protected String name;
  
  /**
   * Constructs an AbstractShape given the inputs.
   * 
   * @param type          the type of the shape
   * @param position      the position of the shape
   * @param size1         the width or X radius of the shape
   * @param size2         the height or Y radius of the shape
   * @param color         the color of the shape
   * @param appearTime    the appear time of the shape
   * @param disappearTime the disappear time of the shape
   * @throws IllegalArgumentException if the size is less and equal to zero, or
   *                                  appearTime is not less than disappearTime
   */
  public AbstractShape(String name, ShapeType type, Point2D position, double size1, double size2,
      ColorRGB color, int appearTime, int disappearTime) throws IllegalArgumentException {
    if (size1 < 0 || size2 < 0) {
      throw new IllegalArgumentException("The size of the shape cannot be negative.");
    }
    if (appearTime > disappearTime) {
      throw new IllegalArgumentException(
          "The appear time should be earlier than " + "the disappear time.");
    }
    this.type = type;
    this.position = position;
    this.size1 = size1;
    this.size2 = size2;
    this.color = color;
    this.appearTime = appearTime;
    this.disappearTime = disappearTime;
    this.name = name;
  }
  
  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public ShapeType getType() {
    return this.type;
  }

  @Override
  public Point2D getPosition() {
    return this.position;
  }

  @Override
  public double getSize1() {
    return this.size1;
  }

  @Override
  public double getSize2() {
    return this.size2;
  }

  @Override
  public ColorRGB getColor() {
    return this.color;
  }

  @Override
  public int getAppearTime() {
    return this.appearTime;
  }

  @Override
  public int getDisappearTime() {
    return this.disappearTime;
  }

  @Override
  public Shape clone() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setPosition(Point2D point) {
    this.position = point;
  }

  @Override
  public void setSize1(double size1) {
    this.size1 = size1;
  }

  @Override
  public void setSize2(double size2) {
    this.size2 = size2;
  }

  @Override
  public void setColor(ColorRGB color) {
    this.color = color;
  }

  @Override
  public void setAppearTime(int time) {
    this.appearTime = time;
  }

  @Override
  public void setDisappearTime(int time) {
    this.disappearTime = time;
  }

}
