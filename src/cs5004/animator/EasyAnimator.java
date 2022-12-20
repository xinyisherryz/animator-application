package cs5004.animator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import cs5004.animator.controller.ControllerImpl;
import cs5004.animator.model.Model;
import cs5004.animator.model.ModelImpl;
import cs5004.animator.util.AnimationBuilder;
import cs5004.animator.util.AnimationBuilderImpl;
import cs5004.animator.util.AnimationReader;

/**
 * This class represents the easy animator.
 * @author xinyizhang
 *
 */
public final class EasyAnimator {

  /**
   * This is the entry point for the easy animator program.
   * @param args the command-line arguments to run the configuration
   */
  public static void main(String[] args) {
    
    String view = "";
    String speed = "";
    String input = "";
    String output = "";

    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-in")) {
        input = args[i + 1];
      } else if (args[i].equals("-out")) {
        output = args[i + 1];
      } else if (args[i].equals("-view")) {
        view = args[i + 1];
      } else if (args[i].equals("-speed")) {
        speed = args[i + 1];
      }
    }
    
    Model model = new ModelImpl();
    AnimationBuilder<ModelImpl> animationBuilder = new AnimationBuilderImpl(model);
    
    try {
      model =  (Model) AnimationReader.parseFile(new FileReader("src/" + input), animationBuilder);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    
    ControllerImpl controller = new ControllerImpl(model, output, speed, view);
    controller.play();
    
  }
  
  
  
}
