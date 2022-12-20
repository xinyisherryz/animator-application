package cs5004.animator.model.animation;

/**
 * This enum represents the forms of the animations.
 * @author xinyizhang
 *
 */
public enum AnimationForm {
  Moving, Scaling, ChangingColor;
  
  @Override
  public String toString() {
    return this.name();
  }
}
