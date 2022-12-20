package cs5004.animator.view;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import cs5004.animator.model.Model;
import cs5004.animator.model.animation.Animation;
import cs5004.animator.model.animation.AnimationForm;
import cs5004.animator.model.animation.Scaling;
import cs5004.animator.model.animation.Moving;
import cs5004.animator.model.animation.ChangingColor;
import cs5004.animator.model.shape.Shape;
import cs5004.animator.model.shape.ShapeType;

/**
 * This class represents the SVG view.
 * @author xinyizhang
 *
 */
public class SvgView implements View {
  
  private Model m;
  private double speed;
  private String output;
  private ViewForm viewForm;
  
  /**
   * Constructs a SVG view given the inputs.
   * @param model the model of animator
   * @param speed the speed of the animation view
   * @param output the output of this view
   */
  public SvgView(Model model, String speed, String output) {
    this.m = model;
    this.speed = Double.valueOf(speed);
    this.output = output;
    this.viewForm = ViewForm.Svg;
  }
  
  @Override
  public String toString() {
    StringBuilder strBuilder = new StringBuilder();

    // head of the svg file:
    strBuilder.append(
        "<svg width=\"1200\" height=\"1200\" version=\"1.1\"\n  xmlns=\"http://www.w3.org/2000/svg\">\n");

    for (Shape shape : this.m.getAllShapes()) {
      if (shape.getType() == ShapeType.Oval) {
        String addStr = String.format(
            "\n<ellipse id=\"%s\" cx=\"%.0f\" cy=\"%.0f\" rx=\"%.0f\" ry=\"%.0f\" "
                + " fill=\"rgb(%.0f, %.0f, %.0f)\" visibility=\"visible\">\n ",
            shape.getName(), shape.getPosition().getX(), shape.getPosition().getY(),
            shape.getSize1(), shape.getSize2(), shape.getColor().getR(), shape.getColor().getG(),
            shape.getColor().getB());
        strBuilder.append(addStr);
      } else if (shape.getType() == ShapeType.Rectangle) {
        String addStr = String.format(
            "\n<rect id=\"%s\" x=\"%.0f\" y=\"%.0f\" width=\"%.0f\" height=\"%.0f\" "
                + " fill=\"rgb(%.0f, %.0f, %.0f)\" visibility=\"visible\">\n ",
            shape.getName(), shape.getPosition().getX(), shape.getPosition().getY(),
            shape.getSize1(), shape.getSize2(), shape.getColor().getR(), shape.getColor().getG(),
            shape.getColor().getB());
        strBuilder.append(addStr);
      }

      int factorDelay = (int) ((int) 1000 / this.speed);

      for (Animation anima : this.m.getAllAnimations()) {
        if (shape.getName().equals(anima.getShapeName())) {
          if (anima.getAnimationForm() == AnimationForm.ChangingColor) {
            String addStr = String.format(
                "\n<animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\""
                    + " attributeName=\"fill\" from=\"rgb(%.1f,%.1f,%.1f)\" "
                    + "to=\"rgb(%.1f,%.1f,%.1f)\" fill=\"freeze\" />\n\n",
                anima.getStartTime() * factorDelay,
                (anima.getEndTime() - anima.getStartTime()) * factorDelay,
                ((ChangingColor) anima).getStartColor().getR(),
                ((ChangingColor) anima).getStartColor().getG(),
                ((ChangingColor) anima).getStartColor().getB(),
                ((ChangingColor) anima).getEndColor().getR(),
                ((ChangingColor) anima).getEndColor().getG(),
                ((ChangingColor) anima).getEndColor().getB());
            strBuilder.append(addStr);
          } else if (anima.getAnimationForm() == AnimationForm.Moving) {

            if (shape.getType() == ShapeType.Rectangle) {
              String addStr = String.format(
                  "\n<animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\"  "
                      + "attributeName=\"x\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />\n"
                      + "<animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\"  "
                      + "attributeName=\"y\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />\n\n",
                  anima.getStartTime() * factorDelay,
                  (anima.getEndTime() - anima.getStartTime()) * factorDelay,
                  ((Moving) anima).getStartPoint().getX(), ((Moving) anima).getEndPoint().getX(),
                  anima.getStartTime() * factorDelay,
                  (anima.getEndTime() - anima.getStartTime()) * factorDelay,
                  ((Moving) anima).getStartPoint().getY(), ((Moving) anima).getEndPoint().getY());
              strBuilder.append(addStr);
            }

            if (shape.getType() == ShapeType.Oval) {
              String addStr = String.format(
                  "\n<animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\"  "
                      + "attributeName=\"cx\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />\n"
                      + "<animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\"  "
                      + "attributeName=\"cy\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />\n\n",
                  anima.getStartTime() * factorDelay,
                  (anima.getEndTime() - anima.getStartTime()) * factorDelay,
                  ((Moving) anima).getStartPoint().getX(), ((Moving) anima).getEndPoint().getX(),
                  anima.getStartTime() * factorDelay,
                  (anima.getEndTime() - anima.getStartTime()) * factorDelay,
                  ((Moving) anima).getStartPoint().getY(), ((Moving) anima).getEndPoint().getY());
              strBuilder.append(addStr);
            }

          } else if (anima.getAnimationForm() == AnimationForm.Scaling) {

            if (shape.getType() == ShapeType.Rectangle) {
              String addStr = String.format(
                  "\n<animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\"  "
                      + "attributeName=\"width\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />\n"
                      + "<animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\"  "
                      + "attributeName=\"height\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />\n\n",
                  anima.getStartTime() * factorDelay,
                  (anima.getEndTime() - anima.getStartTime()) * factorDelay,
                  ((Scaling) anima).getFromSize1(), ((Scaling) anima).getToSize1(),
                  anima.getStartTime() * factorDelay,
                  (anima.getEndTime() - anima.getStartTime()) * factorDelay,
                  ((Scaling) anima).getFromSize2(), ((Scaling) anima).getToSize2());
              strBuilder.append(addStr);
            }

            if (shape.getType() == ShapeType.Oval) {
              String addStr = String.format(
                  "\n<animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\"  "
                      + "attributeName=\"rx\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />\n"
                      + "<animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\"  "
                      + "attributeName=\"ry\" from=\"%.1f\" to=\"%.1f\" fill=\"freeze\" />\n\n",
                  anima.getStartTime() * factorDelay,
                  (anima.getEndTime() - anima.getStartTime()) * factorDelay,
                  ((Scaling) anima).getFromSize1(), ((Scaling) anima).getToSize1(),
                  anima.getStartTime() * factorDelay,
                  (anima.getEndTime() - anima.getStartTime()) * factorDelay,
                  ((Scaling) anima).getFromSize2(), ((Scaling) anima).getToSize2());
              strBuilder.append(addStr);
            }

          }
        }
      }

      if (shape.getType() == ShapeType.Oval) {
        strBuilder.append("</ellipse>");
      } else if (shape.getType() == ShapeType.Rectangle) {
        strBuilder.append("</rect>");
      }
    }

    strBuilder.append("</svg>");
    return strBuilder.toString();
  }
  
  @Override
  public ViewForm getViewType() {
    return this.viewForm;
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
