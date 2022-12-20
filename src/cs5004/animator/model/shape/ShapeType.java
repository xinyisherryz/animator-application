package cs5004.animator.model.shape;

/**
 * This enum represents shape types, which include: rectangle, oval.
 * @author xinyizhang
 *
 */
public enum ShapeType {
  Rectangle, Oval;
  
  @Override
  public String toString() {
    return this.name();
  }
}
