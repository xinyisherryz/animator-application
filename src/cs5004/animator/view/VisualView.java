package cs5004.animator.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.Timer;

import cs5004.animator.model.Model;
import cs5004.animator.model.shape.Shape;

/**
 * This class represents the visual view.
 * @author xinyizhang
 *
 */
public class VisualView extends JFrame implements View, ActionListener {
  
  private static final long serialVersionUID = 1L;
  private GUIPanel guiPanel;
  private Model model;
  private int speed;
  private ViewForm type;
  private Timer timer;
  private JScrollPane jsp;
  
  private int boardX;
  private int boardY;
  private int boardWidth;
  private int boardHeight;
  private int now;

  /**
   * Constructs a visual view given the inputs.
   * @param model the model of the animator
   * @param speed the speed of the animation view
   */
  public VisualView(Model model, String speed) {
    super("VISUAL VIEW");

    this.model = model;
    this.type = ViewForm.Visual;
    this.speed = Integer.valueOf(speed);

    int delay = 1000 / this.speed;
    this.timer = new Timer(delay, this);
    this.now = 0;

    this.setSize(1500, 1500);
    this.setLocation(50, 50);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.guiPanel = new GUIPanel(this.model.getAllShapes());
    this.guiPanel.setSize(1000, 1000);
    this.jsp = new JScrollPane(this.guiPanel);
    this.jsp.setSize(20, 20);
    this.jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    this.jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    this.add(guiPanel);

    this.setVisible(true);
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {

    if (e.getSource() instanceof Timer && this.now <= this.model.getEndTime()) {
      this.now += speed;

      List<Shape> refreshList = this.model.getAllShapesUpdate(this.now);
      List<Shape> visibleList = new ArrayList<Shape>();
      for (Shape shape : refreshList) {
        if (this.now > shape.getVisibleTime()) {
          visibleList.add(shape);
        }
      }

      this.guiPanel.refreshShapes(visibleList);
      this.guiPanel.repaint();
    } else if (e.getSource() instanceof Timer && this.now > this.model.getEndTime()) {
      this.timer.stop();

    }

  }

  @Override
  public ViewForm getViewType() {
    return this.type;
  }

  /**
   * Returns the board info.
   * @return the board info
   */
  public String getBoardInfo() {
    return String.format("%d, %d, %d, %d", this.boardX, this.boardY, 
        this.boardWidth, this.boardHeight);
  }
  
  /**
   * Returns the JScrollPane.
   * @return the JScrollPane
   */
  public JScrollPane getJSP() {
    return this.jsp;
  }
  
  @Override
  public void run() {
    this.timer.start();
  }

}
