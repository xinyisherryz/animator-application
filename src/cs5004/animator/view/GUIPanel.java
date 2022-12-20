package cs5004.animator.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;
import java.util.Objects;

import javax.swing.JPanel;

import cs5004.animator.model.shape.Shape;
import cs5004.animator.model.shape.ShapeType;

/**
 * This class represents the panel for visual view.
 * @author xinyizhang
 *
 */
public class GUIPanel extends JPanel {
  
  private static final long serialVersionUID = 1L;
  private List<Shape> shapeList;

  /**
   * Constructs a GUI panel.
   * @param shapeList a list of shapes
   */
  public GUIPanel(List<Shape> shapeList) {
    super(true);
    this.setBackground(Color.WHITE);
    this.setPreferredSize(new Dimension(1000, 1000));
    this.shapeList = shapeList;
  }
  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    for (Shape shape : this.shapeList) {
      g.setColor(new Color((int) shape.getColor().getR(), (int) shape.getColor().getG(),
          (int) shape.getColor().getB()));

      if (shape.getType().equals(ShapeType.Oval)) {
        g.fillOval((int) shape.getPosition().getX(), (int) shape.getPosition().getY(),
            (int) shape.getSize1(), (int) shape.getSize2());
        g.drawOval((int) shape.getPosition().getX(), (int) shape.getPosition().getY(),
            (int) shape.getSize1(), (int) shape.getSize2());
      } else if (shape.getType().equals(ShapeType.Rectangle)) {
        g.fillRect((int) shape.getPosition().getX(), (int) shape.getPosition().getY(),
            (int) shape.getSize1(), (int) shape.getSize2());
        g.drawRect((int) shape.getPosition().getX(), (int) shape.getPosition().getY(),
            (int) shape.getSize1(), (int) shape.getSize2());
      }
    }

  }
  
  /**
   * Update the shapes received.
   * @param shapeList the list of shapes
   */
  public void refreshShapes(List<Shape> shapeList) {
    this.shapeList = (Objects.requireNonNull(shapeList));
  }
  
}
