package cs5004.animator.controller;

import cs5004.animator.model.Model;
import cs5004.animator.view.SvgView;
import cs5004.animator.view.TextView;
import cs5004.animator.view.View;
import cs5004.animator.view.ViewForm;
import cs5004.animator.view.VisualView;

/**
 * This class represents the console controller of animator.
 * @author xinyizhang
 *
 */
public class ControllerImpl implements Controller {
  
  private Model m;
  private String output;
  private ViewForm viewType;
  private String speed;
  private View view;
  
  
  /**
   * Constructs a ControllerImpl object given the inputs.
   * @param model the input model 
   * @param output the output of the controller
   * @param speed the speed of the animation 
   * @param viewType the type of view to run
   */
  public ControllerImpl(Model model, String output, String speed, String viewType) {
    this.m = model;
    if (viewType.equals("text")) {
      this.viewType = ViewForm.Text;
    } else if (viewType.equals("svg")) {
      this.viewType = ViewForm.Svg;
    } else if (viewType.equals("visual")) {
      this.viewType = ViewForm.Visual;
    }
    this.speed = speed;
    this.output = output;
  }
  
  @Override
  public void play() {
    if (this.viewType == ViewForm.Text) {
      TextView textView = new TextView(this.m, this.speed, this.output);
      this.view = textView;
      textView.run();
    } else if (this.viewType == ViewForm.Svg) {
      SvgView svgView = new SvgView(this.m, this.speed, this.output);
      this.view = svgView;
      svgView.run();
    } else if (this.viewType == ViewForm.Visual) {
      VisualView visualView = new VisualView(this.m, this.speed);
      this.view = visualView;
      visualView.run();
    }
  }
  
  @Override
  public String toString() {
    String description = "run view: " + this.viewType.name() + " at speed: " + this.speed
        + ", output to: " + this.output + "\n";
    return description;
  }
  
  /**
   * Returns the view that has created.
   * @return the created view
   */
  public View getView() {
    return this.view;
  }

}
