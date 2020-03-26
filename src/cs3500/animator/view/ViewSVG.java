package cs3500.animator.view;

//TODO: Implement this entire class

import cs3500.excellence.hw05.ExcellenceModel;
import cs3500.excellence.hw05.ExcellenceOperations;
import cs3500.excellence.hw05.Shape;
import java.io.PrintStream;

/**
 * A SVG view for our animation program. Outputs text in the style of an SVG file for the given
 * animation.
 */
public class ViewSVG implements ExcellenceView {

  private final ExcellenceOperations model;

  ViewSVG(ExcellenceOperations model) {
    this.model = model;
  }

  @Override
  public void setTickRate(int rate) {

  }

  @Override
  public void refresh() {

  }

  @Override
  public void go(PrintStream out) {

    //for every shape
    for (Shape s : model.returnShapeList()) {
      //if there are movements
      if (s.changes.size() > 0) {
        //for each change in the shape
        for (int i = 0; i < s.changes.size(); i++) {
          //write that there's a motion belonging to this shape...
          out.append("motion " + s.name);
          //...then write each number...
          for (int j : s.changes.get(i)) {
            out.append(" " + j);
          }
          //...and then go to a new line when done
          out.append("\n");
        }
      }
    }


  }


}
