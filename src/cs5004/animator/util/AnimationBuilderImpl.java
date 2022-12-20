package cs5004.animator.util;

import cs5004.animator.model.Model;
import cs5004.animator.model.ModelImpl;
import cs5004.animator.model.animation.ChangingColor;
import cs5004.animator.model.animation.Moving;
import cs5004.animator.model.animation.Scaling;
import cs5004.animator.model.shape.ColorRGB;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Point2D;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.Shape;
import cs5004.animator.model.shape.ShapeType;

/**
 * This class represents the implementation of animation builder.
 * @author xinyizhang
 *
 */
public class AnimationBuilderImpl implements AnimationBuilder<ModelImpl> {

  private Model model;
  private int backgroundX;
  private int backgroundY;
  private int backgroundSize1;
  private int backgroundSize2;

  /**
   * Constructs an AnimationBuilderImpl given the input.
   * @param model the model of animator
   */
  public AnimationBuilderImpl(Model model) {
    this.model = model;
  }

  @Override
  public ModelImpl build() {
    return (ModelImpl) this.model;
  }

  @Override
  public AnimationBuilder<ModelImpl> setBounds(int x, int y, int width, int height) {
    this.backgroundX = x;
    this.backgroundY = y;
    this.backgroundSize1 = width;
    this.backgroundSize2 = height;
    return this;
  }
  
  /**
   * Returns the background info.
   * @return the background info
   */
  public String getBackgroundSize() {
    return String.format("%d, %d, %d, %d", this.backgroundX, this.backgroundY, this.backgroundSize1,
        this.backgroundSize2);
    
  }

  @Override
  public AnimationBuilder<ModelImpl> declareShape(String name, String type) {
       
    if (type.equals("rectangle")) {
      Shape rect = new Rectangle(name, ShapeType.Rectangle, new Point2D(0, 0), 0, 0,
          new ColorRGB(0, 0, 0), 0, 0);
      this.model.addShape(rect);
    } else if (type.equals("ellipse") || type.equals("oval")) {
      Shape oval = new Oval(name, ShapeType.Oval, new Point2D(0, 0), 0, 0, new ColorRGB(0, 0, 0), 0,
          0);
      this.model.addShape(oval);
    }
    
    return this;
  }

  @Override
  public AnimationBuilder<ModelImpl> addMotion(String name, int t1, int x1, int y1, int w1, int h1,
      int r1, int g1, int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2)
      throws IllegalArgumentException {
    
    // throw exception if the model doesn't have this motion's related shape
    boolean hasRelatedShape = false;

    for (Shape shape : this.model.getAllShapes()) {
      if (shape.getName().equals(name)) {
        hasRelatedShape = true;
      }
    }
    if (!hasRelatedShape) {
      throw new IllegalArgumentException("Don't have this shape.");
    }
    
    // initialize the shape's start state
    for (Shape shape: this.model.getAllShapes()) {
      if (shape.getName().equals(name)) {
        if (!shape.isInitialized()) {
          shape.setPosition(new Point2D(x1, y1));
          shape.setColor(new ColorRGB(r1, g1, b1));
          shape.setSize1(w1);
          shape.setSize2(h1);
          shape.setInitialized(true);
        }
      }
    }
    
    boolean noAnimation = true;

    // filter the motion's type according to the inputs
    if (x1 != x2 || y1 != y2) {
      Moving newmove = new Moving(name, t1, t2, new Point2D(x1, y1), new Point2D(x2, y2));
      model.addAnimation(newmove);
      noAnimation = false;
    }

    else if (w1 != w2 || h1 != h2) {
      Scaling newscale = new Scaling(name, t1, t2, w1, h1, w2, h2);
      model.addAnimation(newscale);
      noAnimation = false;
    }

    else if (r1 != r2 || g1 != g2 || b1 != b2) {
      ChangingColor newchanging = new ChangingColor(name, t1, t2, new ColorRGB(r1, g1, b1),
          new ColorRGB(r2, g2, b2));
      model.addAnimation(newchanging);
      noAnimation = false;
    }

    

    return this;
  }

}
