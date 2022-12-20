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
import cs5004.animator.view.TextView;
import cs5004.animator.view.ViewForm;

/**
 * This test is for text view.
 * @author xinyizhang
 *
 */
public class TextViewTest {

  /**
   * Test the getViewType method.
   */
  @Test
  public void testGetViewType() {
    Model model = new ModelImpl();
    TextView text = new TextView(model, "2", "output.txt");
    assertEquals(ViewForm.Text, text.getViewType());
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
    TextView text = new TextView(model, "2", "output.txt");
    String expected = "Create Rectangle R with corner at (20.0 , 35.0), "
        + "width 80.0 and height 120.0, Color: (1.0, 0.0, 0.0)\n"
        + "Create Oval C with center at (78.0 , 19.0), radius 130.0 and 90.0, "
        + "Color: (1.0, 0.0, 1.0)\n"
        + "\n" + "R appears at time t=1 and disappears at time t=60\n"
        + "C appears at time t=10 and disappears at time t=80\n" + "\n"
        + "R moves from (80.0, 90.0) to (30.0, 60.0) from time t=1 to t=50\n"
        + "R changes width from 500.0 to 210.0 changes height from 300.0 to 90.0 "
        + "from time t=3 to t=60\n"
        + "C changes width from 100.0 to 400.0 changes height from 160.0 to 200.0 "
        + "from time t=12 to t=70\n"
        + "C changes color from (1, 0, 0) to (0, 1, 0) from time t=30 to t=50" 
        + "\n";
    assertEquals(expected, text.toString());
  }
}
