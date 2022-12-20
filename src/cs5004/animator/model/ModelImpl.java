package cs5004.animator.model;

import java.util.ArrayList;
import java.util.List;

import cs5004.animator.model.animation.Animation;
import cs5004.animator.model.shape.Shape;

/**
 * This class represents the implementation of the animator model.
 * @author xinyizhang
 *
 */
public class ModelImpl implements Model {

  protected List<Shape> allShapes;
  protected List<Animation> allAnimations;
  protected int startTime;
  protected int endTime;
  
  /**
   * Constructs a model implementation with no input.
   * Initializes the all shape and all animation lists as empty.
   */
  public ModelImpl() {
    this.allShapes = new ArrayList<Shape>();
    this.allAnimations = new ArrayList<Animation>();
    this.startTime = 0;
    this.endTime = 0;
  }
  
  
  @Override
  public void addShape(Shape shape) throws IllegalArgumentException {
    if (this.allShapes.contains(shape)) {
      throw new IllegalArgumentException("There's a same shape in the list already.");
    }
    
    if (shape.getDisappearTime() > this.endTime) {
      this.endTime = shape.getDisappearTime();
    }
    
    this.allShapes.add(shape);
  }

  @Override
  public void addAnimation(Animation animation) throws IllegalArgumentException {
    if (this.allAnimations.contains(animation)) {
      throw new IllegalArgumentException("This animation already exists.");
    }

    for (Shape shape : this.getAllShapes()) {
      if (shape.getName().equals(animation.getShapeName())) {
        if (animation.getEndTime() > shape.getDisappearTime()) {
          shape.setDisappearTime(animation.getEndTime());
          if (animation.getEndTime() > this.endTime) {
            this.setEndTime(animation.getEndTime());
          }
        }
      }
    }

    if (this.allAnimations.isEmpty()) {
      this.allAnimations.add(animation);
      return;
    }

    for (Animation a : this.allAnimations) {
      if (animation.getStartTime() <= a.getStartTime()) {
        int index = this.allAnimations.indexOf(a);
        this.allAnimations.add(index, animation);
        return;
      }
    }

    this.allAnimations.add(animation);

  }

  @Override
  public List<Shape> getAllShapes() {
    return this.allShapes;
  }

  @Override
  public List<Animation> getAllAnimations() {
    return this.allAnimations;
  }
  
  @Override
  public String toString() {
    String description = "";
    if (!this.allShapes.isEmpty()) {
      description = "Shapes:" + "\n\n";
    }
    for (Shape s: this.allShapes) {
      description += s.toString() + "\n";
    }
    for (Animation a: this.allAnimations) {
      description += a.toString();
    }
    return description;
  }


  @Override
  public List<Shape> getAllShapesUpdate(int time) {
    List<Shape> updatedShapes = new ArrayList<>();

    for (Shape shape : this.getAllShapes()) {
      Shape copyShape = shape.clone();
      if (shape.getVisibleTime() <= time) {
        for (Animation animation : this.getAllAnimations()) {
          if (animation.getShapeName().equals(shape.getName())
              && animation.getStartTime() <= time) {
            animation.changeShape(copyShape, time);
          }
        }
        updatedShapes.add(copyShape);
      }

    }
    return updatedShapes;
  }

  @Override
  public int getEndTime() {
    return this.endTime;
  }


  @Override
  public void setEndTime(int time) {
    this.endTime = time;
    
  }

}
