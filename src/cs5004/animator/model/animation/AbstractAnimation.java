package cs5004.animator.model.animation;

/**
 * This class represents the abstract animation.
 * @author xinyizhang
 *
 */
public abstract class AbstractAnimation implements Animation {

  protected String shapeName;
  protected AnimationForm animation;
  protected int startTime;
  protected int endTime;
  
  /**
   * Constructs an abstract animation given the inputs.
   * 
   * @param shapeName the name of the shape in this animation
   * @param animation the form of the animation
   * @param startTime the start time of this animation
   * @param endTime   the end time of this animation
   * @throws IllegalArgumentException if the start time is later than the end
   *                                  time, or start/end time is less than zero,
   *                                  or the shape name is null
   */
  public AbstractAnimation(String shapeName, AnimationForm animation, int startTime, int endTime)
      throws IllegalArgumentException {
    if (endTime < startTime) {
      throw new IllegalArgumentException("Start time should be earlier than end time.");
    }
    if (startTime < 0 || endTime <= 0) {
      throw new IllegalArgumentException("Invalid time.");
    }
    if (shapeName == null) {
      throw new IllegalArgumentException("Invalid shape input.");
    }
    this.shapeName = shapeName;
    this.animation = animation;
    this.startTime = startTime;
    this.endTime = endTime;
  }
  
  @Override
  public String getShapeName() {
    return this.shapeName;
  }

  @Override
  public AnimationForm getAnimationForm() {
    return this.animation;
  }

  @Override
  public int getStartTime() {
    return this.startTime;
  }

  @Override
  public int getEndTime() {
    return this.endTime;
  }
  
  /**
   * Returns a middle state of an animation.
   * @param startTime start time
   * @param endTime end time
   * @param midTime mid time
   * @param startCondition start condition of the value
   * @param endCondition end condition of the value
   * @return middleCondition the middle condition of the value
   */
  public double getMiddle(int startTime, int endTime, int midTime, double startCondition,
      double endCondition) {
    double middleCondition = startCondition
        + (endCondition - startCondition) / (endTime - startTime) * (midTime - startTime);
    return middleCondition;
  }

}
