package cs5004.animator.model;

import java.util.List;

import cs5004.animator.model.animation.Animation;
import cs5004.animator.model.shape.Shape;

/**
 * This class represents the interface of animator model.
 * @author xinyizhang
 *
 */
public interface Model {

  /**
   * Add shape to the model.
   * @param shape the shape to add
   * @throws IllegalArgumentException if the shape already exists
   */
  void addShape(Shape shape) throws IllegalArgumentException;
  
  /**
   * Add animation to the model.
   * @param animation the animation to add
   * @throws IllegalArgumentException if the animation already exists
   */
  void addAnimation(Animation animation) throws IllegalArgumentException;
  
  /**
   * Returns all the shapes in this model.
   * @return all shapes
   */
  List<Shape> getAllShapes();
  
  /**
   * Returns all the animations in this model.
   * @return all animations
   */
  List<Animation> getAllAnimations();
  
  /**
   * Returns all the shapes updated by a time in this model.
   * @param time the time to update to
   * @return all the shapes updated by a time in this model
   */
  List<Shape> getAllShapesUpdate(int time);
  
  /**
   * Return the end time of this model.
   * @return the end time of this model
   */
  int getEndTime();
  
  /**
   * Set the end time of this model.
   * @param time the end time of this model
   */
  void setEndTime(int time);
}
