package cs3500.animator.view;

import cs3500.excellence.hw05.ExcellenceOperations;
import cs3500.excellence.hw05.Shape;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

//TODO: JavaDoc
public class ViewPanel extends JPanel {

  private ExcellenceOperations model;
  int tick;

  //TODO: JavaDoc for constructor
  public ViewPanel(ExcellenceOperations model) {
    super();
    this.setBackground(Color.WHITE);
    this.model = model;
    this.tick = 0;
  }

  //TODO: JavaDoc
  public void setTick(int tick) {
    this.tick = tick;
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
    //use tick to get the current tick based on the clock
    //cycle through all the shapes in this animation
    for (Shape s : model.returnShapeList()) {
      //does this shape render at all?
      if (s.changes.size() > 0) {
        //does this shape render this tick?
        if (tick >= s.changes.get(0).get(0) && tick < +s.changes.get(s.changes.size() - 1).get(8)) {
          //cycle through movements on this shape
          for (int i = 0; i < s.changes.size(); i++) {
            //does the current tick mean to use this movement?
            if (tick >= s.changes.get(i).get(0) && tick <= s.changes.get(i).get(8)) {

              //render the shape at this moment
              g2d.drawString(s.name + " is visible!", 50, 50);

            }
          }
        }
      }

      //the start tick of this movement on this shape
      //s.changes.get(i).get(0);

      //the end tick of this movement on this shape
      //s.changes.get(i).get(8);
    }
  }
}
