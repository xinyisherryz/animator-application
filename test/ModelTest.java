import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

//import org.junit.Before;
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

/**
 * This class is for testing the animator model.
 * @author xinyizhang
 *
 */
public class ModelTest {

  /**
   * Test the model constructor.
   */
  @Test
  public void testConstructor() {
    Model m = new ModelImpl();
    assertEquals("", m.toString());
    assertTrue(m.getAllAnimations().isEmpty());
    assertTrue(m.getAllShapes().isEmpty());
  }

  /**
   * Test the addShape method.
   */
  @Test
  public void testAddShape() {
    Shape rec = new Rectangle("R", ShapeType.Rectangle, new Point2D(20, 35), 80, 120,
        new ColorRGB(1, 0, 0), 1, 60);
    Shape oval = new Oval("C", ShapeType.Oval, new Point2D(78, 19), 130, 90, new ColorRGB(1, 0, 1),
        10, 80);
    Model m = new ModelImpl();
    m.addShape(oval);
    m.addShape(rec);

    String expected = "Shapes:\n\n" + "Name: C\n" + "Type: Oval\n"
        + "Center: (78.0, 19.0), X radius: 130.0, Y radius: 90.0, "
        + "Color: (1.0, 0.0, 1.0)\n"
        + "Appears at t=10\n" + "Disappears at t=80\n" + "\n" 
        + "Name: R\n" + "Type: Rectangle\n"
        + "Min corner: (20.0, 35.0), Width: 80.0, Height: 120.0, "
        + "Color: (1.0, 0.0, 0.0)\n"
        + "Appears at t=1\n" + "Disappears at t=60\n" + "\n";
    assertEquals(expected, m.toString());
  }

  /**
   * Test the addAnimatio method.
   */
  @Test
  public void testAddAnimation() {
    Animation moving = new Moving("R", 12, 50, new Point2D(80, 90), new Point2D(30, 60));
    Animation scalingR = new Scaling("R", 3, 60, 500, 300, 210, 90);
    Animation scalingC = new Scaling("C", 6, 70, 100, 160, 400, 200);
    Animation changingColor = new ChangingColor("C", 30, 50, new ColorRGB(1, 0, 0),
        new ColorRGB(0, 1, 0));
    Model m = new ModelImpl();
    m.addAnimation(moving);
    m.addAnimation(scalingR);
    m.addAnimation(scalingC);
    m.addAnimation(changingColor);

    String expected = "R scales from Width: 500.0, Height: 300.0 to Width: 210.0, "
        + "Height: 90.0 from time t=3 to t=60\n"
        + "C scales from X radius: 100.0, Y radius: 160.0 to X radius: 400.0, "
        + "Y radius: 200.0 from time t=6 to t=70\n"
        + "R moves from (80.0, 90.0) to (30.0, 60.0) from time t=12 to t=50\n"
        + "C changes color from (1.0, 0.0, 0.0) to (0.0, 1.0, 0.0) from time t=30 to t=50\n";
    assertEquals(expected, m.toString());

  }

  /**
   * Test the getAllShapesUpdate method.
   */
  @Test
  public void testGetAllShapesUpdate() {
    Shape rec = new Rectangle("R", ShapeType.Rectangle, new Point2D(10, 20), 80, 120,
        new ColorRGB(10, 10, 10), 0, 1000);
    Shape oval = new Oval("C", ShapeType.Oval, new Point2D(20, 40), 40, 60,
        new ColorRGB(100, 100, 100), 0, 1000);
    Model m = new ModelImpl();
    m.addShape(oval);
    m.addShape(rec);

    Animation moving = new Moving("R", 100, 300, new Point2D(10, 20), new Point2D(30, 40));
    Animation scalingR = new Scaling("R", 0, 60, 80, 120, 100, 140);
    Animation scalingR1 = new Scaling("R", 100, 300, 100, 140, 200, 200);
    Animation scalingC = new Scaling("C", 100, 300, 40, 60, 100, 120);
    Animation changingColor = new ChangingColor("C", 100, 300, new ColorRGB(10, 10, 10),
        new ColorRGB(50, 50, 50));

    m.addAnimation(moving);
    m.addAnimation(scalingR);
    m.addAnimation(scalingR1);
    m.addAnimation(scalingC);
    m.addAnimation(changingColor);

    List<Shape> updatedShape = m.getAllShapesUpdate(200);
    for (Shape shape : updatedShape) {
      if (shape.getName().equals("R")) {
        assertEquals(shape.getPosition().getX(), 20, 0.001);
        assertEquals(shape.getPosition().getY(), 30, 0.001);
        assertEquals(shape.getSize1(), 150, 0.001);
        assertEquals(shape.getSize2(), 170, 0.001);
      }
      if (shape.getName().equals("C")) {
        assertEquals(shape.getSize1(), 70, 0.001);
        assertEquals(shape.getSize2(), 90, 0.001);
        assertEquals(shape.getColor().getR(), 30, 0.001);
      }
    }

  }
}
