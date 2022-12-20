package cs5004.animator.model.shape;

/**
 * This class represents color, specified with (red, green, blue).
 * @author xinyizhang
 *
 */
public class ColorRGB {

  private double r;
  private double g;
  private double b;
  
  /**
   * Constructs a ColorRGB given the red, green, and blue.
   * @param r red
   * @param g green
   * @param b blue
   */
  public ColorRGB(double r, double g, double b) {
    this.r = r;
    this.g = g;
    this.b = b;
  }
  
  /**
   * Returns the red color.
   * @return the red
   */
  public double getR() {
    return this.r;
  }
  
  /**
   * Returns the green color.
   * @return the green
   */
  public double getG() {
    return this.g;
  }
  
  /**
   * Returns the blue color.
   * @return blue
   */
  public double getB() {
    return this.b;
  }
  
  @Override
  public String toString() {
    return String.format("(%.1f, %.1f, %.1f)", this.r, this.g, this.b);
  }
}
