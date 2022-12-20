package cs5004.animator.view;

/**
 * This interface represents the view of animator.
 * @author xinyizhang
 *
 */
public interface View {

  /**
   * Returns the view's type.
   * @return the view's type.
   */
  ViewForm getViewType();
  
  /**
   * Runs the view.
   */
  void run();
}
