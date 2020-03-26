package cs3500.animator.view;

import cs3500.excellence.hw05.ExcellenceOperations;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import javax.swing.JFrame;
import javax.swing.Timer;

//TODO: Implement this entire class

/**
 * A animated view for our animation program. Displays a fully animated version of the given
 * animation.
 */
public class ViewAnimation extends JFrame implements ExcellenceView {

  ViewPanel panel;
  int tickRate;
  int tick;
  int[] canvasInfo;

  //TODO: JavaDoc
  ViewAnimation(ExcellenceOperations model) {
    this.tickRate = 1;
    this.tick = 0;

    //get the canvas info from the model and set up the width and height
    this.canvasInfo = model.getCanvasInfo();
    this.setSize(canvasInfo[2], canvasInfo[3]);

    //set up the panel
    this.setLayout(new BorderLayout());
    panel = new ViewPanel(model);
    panel.setPreferredSize(new Dimension(500, 500));
    this.add(panel, BorderLayout.CENTER);
    this.pack();

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  @Override
  public void setTickRate(int rate) {
    if (rate <= 0) {
      throw new IllegalArgumentException(
          "You've set the tick rate to 0 or less, which is not allowed!");
    }
    tickRate = rate;
  }

  @Override
  public void refresh() {
    panel.setTick(tick);
    panel.repaint();
  }

  @Override
  public void go(PrintStream out) {

    //TODO: JavaDoc
    //set up the ActionListener that fires every tick
    ActionListener onTick = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        refresh();
        tick++;
      }
    };

    //Set up the clock that ticks
    Timer timer = new Timer(1000 / tickRate, onTick);

    //set this view to being visible
    this.setVisible(true);

    //start the clock, and by extension the animation
    timer.start();
  }
}
