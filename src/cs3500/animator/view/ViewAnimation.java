package cs3500.animator.view;

import cs3500.excellence.hw05.ExcellenceModel;
import cs3500.excellence.hw05.ExcellenceOperations;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;

//TODO: Implement this entire class

/**
 * A animated view for our animation program. Displays a fully animated version of the given
 * animation.
 */
public class ViewAnimation extends JFrame implements ExcellenceView {

  ViewPanel panel;
  int tickRate;

  ViewAnimation(ExcellenceOperations model) {
    this.panel = new ViewPanel(model);
    this.tickRate = 1;
  }

  @Override
  public void setTickRate(int rate) {
    tickRate = rate;
  }

  @Override
  public void makeVisible() {
    this.setVisible(true);
  }

  @Override
  public void refresh() {
    panel.repaint();
  }

  @Override
  public void go(Appendable ap) {
    //this is where the clock goes and we do ticks to call refresh()
  }
}
