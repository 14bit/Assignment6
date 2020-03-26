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

  int[] canvasInfo;
  private final ExcellenceOperations model;

  ViewSVG(ExcellenceOperations model) {
    this.model = model;
    
    this.canvasInfo = model.getCanvasInfo();
  }

  @Override
  public void setTickRate(int rate) {

  }

  @Override
  public void refresh() {

  }

  @Override
  public void go(PrintStream out) {
    out.append("<svg width=\"" + canvasInfo[0] + "\" height=\"" + canvasInfo[4] + " version=\"1.1\" " + "xmnls=\"http://www.w3.org/2000/svg\">"
    //for every shape
    for (Shape s : model.returnShapeList()) {
      if (s instanceof Rectangle) {
        out.append("<rect id=\"" + s.name + "\" x=\"" + s.x1 + "\" y=\"" + s.y1 + "\" width=\" + s.w1 + "\" height=\"" + s.h1 + "\" fill=\"rgb(" + s.r1 + "." + s.g1 + "." + s.b1 + ")\" visibility=\"visible\" >" + \n");
      } else if (s instanceof Ellipse) {
        out.append("<ellipse id=\"" + s.name + "\" cx=\"" + s.x1 + "\" cy=\"" + s.y1 + "\" rx=\" + s.w1 + "\" ry=\"" + s.h1 + "\" fill=\"rgb(" + s.r1 + "." + s.g1 + "." + s.b1 + ")\" visibility=\"visible\" >" + \n");
      }
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
    System.exit(0);
  }
}
