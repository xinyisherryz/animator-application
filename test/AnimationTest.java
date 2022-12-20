import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cs5004.animator.model.animation.Animation;
import cs5004.animator.model.animation.ChangingColor;
import cs5004.animator.model.animation.Moving;
import cs5004.animator.model.animation.Scaling;
import cs5004.animator.model.shape.ColorRGB;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Point2D;
import cs5004.animator.model.shape.ShapeType;

/**
 * This test is for the animation interface.
 * @author xinyizhang
 *
 */
public class AnimationTest {

  /**
   * Test the moving constructor.
   */
  @Test
  public void testMovingConstructor() {
    Animation moving1 = new Moving("R", 1, 50, new Point2D(80, 90), new Point2D(30, 60));
    String expected = "R moves from (80.0, 90.0) to (30.0, 60.0) from time t=1 to t=50" + "\n";
    assertEquals(expected, moving1.toString());
  }

  /**
   * Test the scaling constructor.
   */
  @Test
  public void testScalingConstructor() {
    Animation scalingR = new Scaling("R", 3, 60, 500, 300, 210, 90);
    String expected = "R scales from Width: 500.0, Height: 300.0 to Width: 210.0, "
        + "Height: 90.0 from time t=3 to t=60" + "\n";
    assertEquals(expected, scalingR.toString());

    Animation scalingC = new Scaling("C", 12, 70, 100, 160, 400, 200);
    expected = "C scales from X radius: 100.0, Y radius: 160.0 to X radius: 400.0, "
        + "Y radius: 200.0 from time t=12 to t=70" + "\n";
    assertEquals(expected, scalingC.toString());
  }

  /**
   * Test the changing color constructor.
   */
  @Test
  public void testChangingColorConstructor() {
    Animation changingColor1 = new ChangingColor("C", 30, 50, new ColorRGB(1, 0, 0),
        new ColorRGB(0, 1, 0));
    String expected = "C changes color from (1.0, 0.0, 0.0) to (0.0, 1.0, 0.0) "
        + "from time t=30 to t=50"
        + "\n";
    assertEquals(expected, changingColor1.toString());
  }

  /**
   * Test the change shape method.
   */
  @Test
  public void testChangeShape() {
    Oval oval = new Oval("C", ShapeType.Oval, new Point2D(0, 0), 100, 300, new ColorRGB(1, 0, 0), 0,
        1000);
    Animation changingColor1 = new ChangingColor("C", 0, 50, new ColorRGB(0, 0, 0),
        new ColorRGB(100, 100, 100));
    changingColor1.changeShape(oval, 25);
    assertEquals(oval.getColor().getR(), 50, 0.0001);

    Animation moving1 = new Moving("C", 0, 50, new Point2D(0, 0), new Point2D(30, 60));
    moving1.changeShape(oval, 25);
    assertEquals(oval.getPosition().getX(), 15, 0.0001);

    Animation scalingC = new Scaling("C", 0, 50, 100, 200, 300, 400);
    scalingC.changeShape(oval, 25);
    assertEquals(oval.getSize1(), 200, 0.0001);

  }
}
