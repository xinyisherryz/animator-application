package cs5004.animator.model.animation;

import cs5004.animator.model.shape.Shape;

/**
 * This class represents the animations of shapes.
 * @author xinyizhang
 *
 */
public interface Animation {

  /**
   * Returns the name of the shape in this animation.
   * @return shape name
   */
  String getShapeName();
  
  /**
   * Returns the form of the animation.
   * @return animation form
   */
  AnimationForm getAnimationForm();
  
  /**
   * Returns the start time of the animation.
   * @return start time
   */
  int getStartTime();
  
  /**
   * Returns the end time of the animation.
   * @return end time
   */
  int getEndTime();  
  
  /**
   * Change the animation's shape to a certain time's status.
   */
  void changeShape(Shape shape, int time);
  
}
