package cs3500.animator.view;

import cs3500.excellence.hw05.ExcellenceOperations;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

//TODO: JavaDoc
public class ViewPanel extends JPanel {

  private ExcellenceOperations model;

  //TODO: JavaDoc for constructor
  public ViewPanel(ExcellenceOperations model) {
    super();
    this.setBackground(Color.WHITE);
    this.model = model;
  }

  /**
   * Override the paintComponent method of the JPanel. This is where things are drawn each tick, and
   * is called each tick.
   *
   * @param g Graphics object that handles drawing the graphics
   */
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;

    //this is where we draw the frames

  }
}
