import static org.junit.Assert.assertEquals;

import org.junit.Test;

import cs5004.animator.controller.Controller;
import cs5004.animator.controller.ControllerImpl;
import cs5004.animator.model.Model;
import cs5004.animator.model.ModelImpl;
import cs5004.animator.view.ViewForm;

/**
 * This test is for the animator controller.
 * @author xinyizhang
 *
 */
public class ControllerTest {

  /**
   * Test the controller constructor.
   */
  @Test
  public void testConstructor() {
    Model model = new ModelImpl();
    Controller c = new ControllerImpl(model, "output.txt", "2", "text");
    String expected = "run view: Text at speed: 2, output to: output.txt" + "\n";
    assertEquals(expected, c.toString());
    
  }
  
  /**
   * Test the play method.
   */
  @Test
  public void testPlay() {
    Model model = new ModelImpl();
    ControllerImpl c = new ControllerImpl(model, "out.svg", "2", "svg");
    c.play();
    assertEquals(ViewForm.Svg, c.getView().getViewType());
  }

}
