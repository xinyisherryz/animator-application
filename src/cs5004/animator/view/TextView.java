package cs5004.animator.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import cs5004.animator.model.Model;
import cs5004.animator.model.animation.Animation;
import cs5004.animator.model.animation.AnimationForm;
import cs5004.animator.model.animation.ChangingColor;
import cs5004.animator.model.animation.Moving;
import cs5004.animator.model.animation.Scaling;
import cs5004.animator.model.shape.Shape;
import cs5004.animator.model.shape.ShapeType;

/**
 * This class represents the text view.
 * @author xinyizhang
 *
 */
public class TextView implements View {
  
  private Model m;
  private double speed;
  private String output;
  private ViewForm viewForm;
  
  /**
   * Constructs a text view given the inputs.
   * @param model the model of the animator
   * @param speed the speed of this animation view
   * @param output the output of this view
   */
  public TextView(Model model, String speed, String output) {
    this.m = model;
    this.speed = Double.valueOf(speed);
    this.output = output;
    this.viewForm = ViewForm.Text;
  }
  
  @Override
  public ViewForm getViewType() {
    return this.viewForm;
  }
  
  /**
   * Returns the speed of this view.
   * @return the speed 
   */
  public double getSpeed() {
    return this.speed;
  }

  @Override
  public String toString() {
    String outputStr = "";

    for (Shape shape : this.m.getAllShapes()) {
      if (shape.getType() == ShapeType.Rectangle) {
        outputStr += "Create Rectangle " + shape.getName() + " with corner at ("
            + shape.getPosition().getX() + " , " + shape.getPosition().getY() + "), width "
            + shape.getSize1() + " and height " + shape.getSize2() + ", Color: ("
            + shape.getColor().getR() + ", " + shape.getColor().getG() + ", "
            + shape.getColor().getB() + ")\n";
      } else if (shape.getType() == ShapeType.Oval) {
        outputStr += "Create Oval " + shape.getName() + " with center at ("
            + shape.getPosition().getX() + " , " + shape.getPosition().getY() + "), radius "
            + shape.getSize1() + " and " + shape.getSize2() + ", Color: (" + shape.getColor().getR()
            + ", " + shape.getColor().getG() + ", " + shape.getColor().getB() + ")\n";
      }
    }

    outputStr += "\n";

    for (Shape shape : this.m.getAllShapes()) {
      outputStr += shape.getName() + " appears at time t=" + shape.getAppearTime()
          + " and disappears at time t=" + shape.getDisappearTime() + "\n";
    }

    outputStr += "\n";

    for (Animation anima : this.m.getAllAnimations()) {

      if (anima.getAnimationForm() == AnimationForm.Moving) {
        outputStr += anima.getShapeName() + " moves from ("
            + ((Moving) anima).getStartPoint().getX() + ", "
            + ((Moving) anima).getStartPoint().getY() + ") to ("
            + ((Moving) anima).getEndPoint().getX() + ", " + ((Moving) anima).getEndPoint().getY()
            + ") from time t=" + anima.getStartTime() + " to t=" + anima.getEndTime() + "\n";
      } else if (anima.getAnimationForm() == AnimationForm.Scaling) {
        outputStr += anima.getShapeName() + " changes width from "
            + ((Scaling) anima).getFromSize1() + " to " + ((Scaling) anima).getToSize1()
            + " changes height from " + ((Scaling) anima).getFromSize2() + " to "
            + ((Scaling) anima).getToSize2() + " from time t=" + anima.getStartTime() + " to t="
            + anima.getEndTime() + "\n";
      } else if (anima.getAnimationForm() == AnimationForm.ChangingColor) {
        outputStr += anima.getShapeName() + " changes color from "
            + String.format("(%.0f, %.0f, %.0f)", ((ChangingColor) anima).getStartColor().getR(),
                ((ChangingColor) anima).getStartColor().getG(),
                ((ChangingColor) anima).getStartColor().getB())
            + " to "
            + String.format("(%.0f, %.0f, %.0f)", ((ChangingColor) anima).getEndColor().getR(),
                ((ChangingColor) anima).getEndColor().getG(),
                ((ChangingColor) anima).getEndColor().getB())
            + " from time t=" + anima.getStartTime() + " to t=" + anima.getEndTime() + "\n";
      }
    }
    return outputStr;

  }

  @Override
  public void run() {
    
    if (this.output.equals("")) {
      System.out.println(this.toString());
    } else {
      try {
        File outPutFile = new File(this.output);
        try (FileWriter outPutWriter = new FileWriter(outPutFile)) {
          outPutWriter.write(this.toString());
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    
  }
}
