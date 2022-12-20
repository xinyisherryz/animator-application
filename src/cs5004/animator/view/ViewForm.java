package cs5004.animator.view;

/**
 * This enum represents the types of the view.
 * @author xinyizhang
 *
 */
public enum ViewForm {
  Text, Visual, Svg, Editor;
  
  @Override
  public String toString() {
    return this.name().toLowerCase();
  }
}
