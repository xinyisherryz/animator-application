import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import cs5004.animator.model.shape.ColorRGB;
import cs5004.animator.model.shape.Oval;
import cs5004.animator.model.shape.Point2D;
import cs5004.animator.model.shape.Rectangle;
import cs5004.animator.model.shape.Shape;
import cs5004.animator.model.shape.ShapeType;

/**
 * This test is for interface Shape.
 * @author xinyizhang
 *
 */
public class ShapeTest {

  private Point2D point1;
  private Point2D point2;
  private ColorRGB color1;
  private ColorRGB color2;
  private Shape rec;
  private Shape oval;
  
  /**
   * Set up objects for testing.
   */
  @Before
  public void setUp() {
    point1 = new Point2D(20, 35);
    point2 = new Point2D(78, 19);
    color1 = new ColorRGB(1, 0, 0);
    color2 = new ColorRGB(1, 0, 1);
    rec = new Rectangle("R", ShapeType.Rectangle, point1, 80, 120, color1,
        1, 60);
    oval = new Oval("C", ShapeType.Oval, point2, 130, 90, color2,
        10, 80);
  }
  
  /**
   * Test the rectangle constructor.
   */
  @Test
  public void testRectangleConstructor() {
    Shape rec1 = new Rectangle("R", ShapeType.Rectangle, new Point2D(50, 100), 80, 120,
        new ColorRGB(1, 0, 0), 1, 60);
    String expected = "Name: R" + "\n" + "Type: Rectangle" + "\n"
        + "Min corner: (50.0, 100.0), Width: 80.0, Height: 120.0, Color: (1.0, 0.0, 0.0)" + "\n"
        + "Appears at t=1" + "\n" + "Disappears at t=60" + "\n";

    assertEquals(expected, rec1.toString());
  }

  /**
   * Test the oval constructor.
   */
  @Test
  public void testOvalConstructor() {
    Shape oval1 = new Oval("C", ShapeType.Oval, new Point2D(100, 100), 130, 90,
        new ColorRGB(1, 0, 1), 1, 80);
    String expected = "Name: C" + "\n" + "Type: Oval" + "\n"
        + "Center: (100.0, 100.0), X radius: 130.0, Y radius: 90.0, Color: (1.0, 0.0, 1.0)" + "\n"
        + "Appears at t=1" + "\n" + "Disappears at t=80" + "\n";
    assertEquals(expected, oval1.toString());
  }

  /**
   * Test the getName method.
   */
  @Test
  public void testGetName() {
    assertEquals("R", rec.getName());
    assertEquals("C", oval.getName());
  }
  
  /**
   * Test the getType method.
   */
  @Test
  public void testGetType() {
    assertEquals(ShapeType.Rectangle, rec.getType());
    assertEquals(ShapeType.Oval, oval.getType());
  }
  
  /**
   * Test the type to string.
   */
  @Test
  public void testTypeToString() {
    assertEquals(ShapeType.Rectangle.toString(), "Rectangle");
    assertEquals(ShapeType.Oval.toString(), "Oval");
  }
  
  /**
   * Test the getter for position.
   */
  @Test
  public void testGetPosition() {
    assertEquals(point1, rec.getPosition());
    assertEquals(point2, oval.getPosition());
  }
  
  /**
   * Test the getter for size 1.
   */
  @Test
  public void testGetSize1() {
    assertEquals(80, rec.getSize1(), 0.001);
    assertEquals(130, oval.getSize1(), 0.001);
  }
  
  /**
   * Test the getter for size 2.
   */
  @Test
  public void testGetSize2() {
    assertEquals(120, rec.getSize2(), 0.001);
    assertEquals(90, oval.getSize2(), 0.001);
  }
  
  /**
   * Test the getter for color.
   */
  @Test
  public void testGetColor() {
    assertEquals(color1, rec.getColor());
    assertEquals(color2, oval.getColor());
  }
  
  /**
   * Test the getter for appear time.
   */
  @Test
  public void testGetAppearTime() {
    assertEquals(1, rec.getAppearTime());
    assertEquals(10, oval.getAppearTime());
  }
  
  /**
   * Test the getter for disappear time.
   */
  @Test
  public void testGetDisappearTime() {
    assertEquals(60, rec.getDisappearTime());
    assertEquals(80, oval.getDisappearTime());
  }
  
  /**
   * Test the setter for position.
   */
  @Test
  public void testSetPosition() {
    Point2D newPoint = new Point2D(9, 9);
    rec.setPosition(newPoint);
    assertEquals(newPoint, rec.getPosition());
    
    oval.setPosition(newPoint);
    assertEquals(9, oval.getPosition().getX(), 0.001);
  }
  
  /**
   * Test the setter for size 1.
   */
  @Test
  public void testSetSize1() {
    rec.setSize1(233);
    assertEquals(233, rec.getSize1(), 0.001);
    
    oval.setSize1(100);
    assertEquals(100, oval.getSize1(), 0.001);
  }
  
  /**
   * Test the setter for size 2.
   */
  @Test
  public void testSetSize2() {
    rec.setSize2(300);
    assertEquals(300, rec.getSize2(), 0.001);
    
    oval.setSize2(278);
    assertEquals(278, oval.getSize2(), 0.001);
  }
  
  /**
   * Test the setter for color.
   */
  @Test
  public void testSetColor() {
    ColorRGB newColor = new ColorRGB(0, 0, 1);
    rec.setColor(newColor);
    assertEquals(newColor, rec.getColor());
    
    oval.setColor(newColor);
    assertEquals(0, oval.getColor().getR(), 0.001);
    assertEquals(0, oval.getColor().getG(), 0.001);
    assertEquals(1, oval.getColor().getB(), 0.001);
  }
  
  /**
   * Test the setter for appear time.
   */
  @Test
  public void testSetAppearTime() {
    rec.setAppearTime(50);
    assertEquals(50, rec.getAppearTime());
    oval.setAppearTime(33);
    assertEquals(33, oval.getAppearTime());
  }
  
  /**
   * Test the setter for disappear time.
   */
  @Test
  public void testSetDisappearTime() {
    rec.setDisappearTime(101);
    assertEquals(101, rec.getDisappearTime());
    oval.setDisappearTime(99);
    assertEquals(99, oval.getDisappearTime());
  }
}
