package cs5004.animator.model.shape;

/**
 * This interface represents shapes and related operations.
 * @author xinyizhang
 *
 */
public interface Shape {

  /**
   * Returns the name of this shape.
   * @return R if the shape is rectangle, or C if it's oval
   */
  String getName();
  
  /**
   * Returns the type of this shape.
   * @return rectangle or oval
   */
  ShapeType getType();
  
  /**
   * Returns the position of the shape.
   * @return the 2D position of the shape
   */
  Point2D getPosition();
  
  /**
   * Returns the width if it's rectangle, and X radius if it's oval.
   * @return width of rectangle, or X radius of oval
   */
  double getSize1();
  
  /**
   * Returns the height if it's rectangle, and Y radius if it's oval.
   * @return height of rectangle, or Y radius of oval
   */
  double getSize2();
  
  /**
   * Returns the color of this shape.
   * @return ColorRBG of this shape
   */
  ColorRGB getColor();
  
  /**
   * Returns the appear time of the shape.
   * @return the appear time
   */
  int getAppearTime();
  
  /**
   * Returns the disappear time of the shape.
   * @return the disappear time
   */
  int getDisappearTime();
  
  /**
   * Return the clone of this shape.
   * @return the clone
   */
  Shape clone();
  
  /**
   * Update the position of this shape.
   * @param point the new position
   */
  void setPosition(Point2D point);
  
  /**
   * Update the width of the rectangle, or X radius of oval.
   * @param size1 the new width of rectangle, or X radius of oval
   */
  void setSize1(double size1);
  
  /**
   * Update the height of the rectangle, or Y radius of oval.
   * @param size2 the new height of rectangle, or Y radius of oval
   */
  void setSize2(double size2);
  
  /**
   * Update the color of the shape.
   * @param color the new color
   */
  void setColor(ColorRGB color);
  
  /**
   * Update the appear time of the shape.
   * @param time the new appear time
   */
  void setAppearTime(int time);
  
  /**
   * Update the disappear time of the shape.
   * @param time the new disappear time
   */
  void setDisappearTime(int time);

  /**
   * Return the first visible time of this shape.
   * @return the first visible time of this shape
   */
  int getVisibleTime();
  
  /**
   * Set the first visible time of this shape.
   * @param time the new first visible time of this shape.
   */
  void setVisibleTime(int time);
  
  /**
   * Return a boolean indicating that whether the shape has been initialized a
   * non-empty color/shape/size.
   * 
   * @return a boolean indicating that whether the shape has been initialized a
   *         non-empty color/shape/size
   */
  boolean isInitialized();

  /**
   * Change the status of the boolean indicating that whether the shape has been
   * initialized a non-empty color/shape/size.
   * 
   * @param status a boolean status to update
   */
  void setInitialized(boolean status);
}
