package cs3500.animator.view;

//TODO: Implement this entire class (this one is the easiest, since we can just yoink the code from
// the model and put it here for the most part

import cs3500.excellence.hw05.ExcellenceOperations;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * A textual view for our animation program. Outputs a text description of the given animation.
 */
public class ViewText implements ExcellenceView {

  ViewText(ExcellenceOperations model) {

  }

  @Override
  public void setTickRate(int rate) {

  }

  @Override
  public void refresh() {

  }

  @Override
  public void go(PrintStream out) {
    out.append("We are writing directly to a file!\n");
    System.exit(0);
  }
}
