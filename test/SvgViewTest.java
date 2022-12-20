import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cs5004.animator.model.Model;
import cs5004.animator.model.ModelImpl;
import cs5004.animator.model.animation.Animation;
import cs5004.animator.model.animation.ChangingColor;
import cs5004.animator.model.animation.Moving;
import cs5004.animator.model.animation.Scaling;
import cs5004.animator.model.shape.ColorRGB;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Point2D;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.Shape;
import cs5004.animator.model.shape.ShapeType;
import cs5004.animator.view.SvgView;
import cs5004.animator.view.ViewForm;

/**
 * This test is for SVG view.
 * @author xinyizhang
 *
 */
public class SvgViewTest {

  /**
   * Test the getViewType method.
   */
  @Test
  public void testGetViewType() {
    Model model = new ModelImpl();
    SvgView svg = new SvgView(model, "2", "output.txt");
    assertEquals(ViewForm.Svg, svg.getViewType());
  }

  /**
   * Test the toString method.
   */
  @Test
  public void testToString() {
    Model model = new ModelImpl();
    Shape rec = new Rectangle("R", ShapeType.Rectangle, new Point2D(20, 35), 80, 120,
        new ColorRGB(1, 0, 0), 1, 60);
    Shape oval = new Oval("C", ShapeType.Oval, new Point2D(78, 19), 130, 90, new ColorRGB(1, 0, 1),
        10, 80);
    Animation moving = new Moving("R", 1, 50, new Point2D(80, 90), new Point2D(30, 60));
    Animation scalingR = new Scaling("R", 3, 60, 500, 300, 210, 90);
    Animation scalingC = new Scaling("C", 12, 70, 100, 160, 400, 200);
    Animation changingColor = new ChangingColor("C", 30, 50, new ColorRGB(1, 0, 0),
        new ColorRGB(0, 1, 0));
    model.addShape(rec);
    model.addShape(oval);
    model.addAnimation(moving);
    model.addAnimation(scalingR);
    model.addAnimation(scalingC);
    model.addAnimation(changingColor);
    SvgView svg = new SvgView(model, "2", "output.txt");
    String expected = "<svg width=\"1200\" height=\"1200\" version=\"1.1\"\n"
        + "  xmlns=\"http://www.w3.org/2000/svg\">\n" + "\n"
        + "<rect id=\"R\" x=\"20\" y=\"35\" width=\"80\" height=\"120\"  "
        + "fill=\"rgb(1, 0, 0)\" visibility=\"visible\">\n"
        + " \n"
        + "<animate attributeType=\"xml\" begin=\"500ms\" dur=\"24500ms\"  "
        + "attributeName=\"x\" from=\"80.0\" to=\"30.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"500ms\" dur=\"24500ms\"  "
        + "attributeName=\"y\" from=\"90.0\" to=\"60.0\" fill=\"freeze\" />\n"
        + "\n" + "\n"
        + "<animate attributeType=\"xml\" begin=\"1500ms\" dur=\"28500ms\"  "
        + "attributeName=\"width\" from=\"500.0\" to=\"210.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"1500ms\" dur=\"28500ms\"  "
        + "attributeName=\"height\" from=\"300.0\" to=\"90.0\" fill=\"freeze\" />\n"
        + "\n" + "</rect>\n"
        + "<ellipse id=\"C\" cx=\"78\" cy=\"19\" rx=\"130\" ry=\"90\"  "
        + "fill=\"rgb(1, 0, 1)\" visibility=\"visible\">\n"
        + " \n"
        + "<animate attributeType=\"xml\" begin=\"6000ms\" dur=\"29000ms\"  "
        + "attributeName=\"rx\" from=\"100.0\" to=\"400.0\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"6000ms\" dur=\"29000ms\"  "
        + "attributeName=\"ry\" from=\"160.0\" to=\"200.0\" fill=\"freeze\" />\n"
        + "\n" + "\n"
        + "<animate attributeType=\"xml\" begin=\"15000ms\" dur=\"10000ms\" "
        + "attributeName=\"fill\" from=\"rgb(1.0,0.0,0.0)\" to=\"rgb(0.0,1.0,0.0)\" "
        + "fill=\"freeze\" />\n"
        + "\n" + "</ellipse></svg>";
    assertEquals(expected, svg.toString());
  }
}
