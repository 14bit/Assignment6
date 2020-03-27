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
        out.append("<rect id=\"" + s.name + "\" x=\"" + s.changes.get(0).get(1) + "\" y=\"" + s.changes.get(0).get(2) + "\" width=\"" + s.changes.get(0).get(3) + "\" height=\"" + s.changes.get(0).get(4) + "\" fill=\"rgb(" + s.changes.get(0).get(5) + "." + s.changes.get(0).get(6) + "." + s.changes.get(0).get(7) + ")\" visibility=\"visible\" >" + "\n");
      } else if (s instanceof Ellipse) {
        out.append("<ellipse id=\"" + s.name + "\" cx=\"" + s.changes.get(0).get(1) + "\" cy=\"" + s.changes.get(0).get(2) + "\" rx=\"" + (s.changes.get(0).get(3) / 2) + "\" ry=\"" + (s.changes.get(0).get(4) / 2) + "\" fill=\"rgb(" + s.changes.get(0).get(5) + "." + s.changes.get(0).get(6) + "." + s.changes.get(0).get(7) + ")\" visibility=\"visible\" >" + "\n");
      }
      //if there are movements
      if (s.changes.size() > 0) {
        //for each change in the shape
        for (int i = 0; i < s.changes.size() + 1; i++) {
          //write that there's a motion belonging to this shape...
          if (s instanceof Rectangle) {
            for (int l = 1; l < 8; l++) {
          out.append("<animate attributeType=\"xml\" begin=\"" s.changes.get(i).get(0) + "ms\" dur=\"" (s.changes.get(i).get(8) - s.changes.get(i).get(0)) + "ms\" attributeName=\"");
          if (s.changes.get(i).get(l) != s.changes.get(i).get(l + 8)) {
            out.append("x\" from=\"" + s.changes.get(i).get(l) + "\" to=\"" s.changes.get(i).get(l + 8) + "\" fill=\"freeze\" />" + "\n");
          } else if (s.changes.get(i).get(l) != s.changes.get(i).get(l + 8)) {
            out.append("y\" from=\"" + s.changes.get(i).get(l) + "\" to=\"" s.changes.get(i).get(l + 8) + "\" fill=\"freeze\" />" + "\n");
          } else if (s.changes.get(i).get(l) != s.changes.get(i).get(l + 8)) {
            out.append("w\" from=\"" + s.changes.get(i).get(l) + "\" to=\"" s.changes.get(i).get(l + 8) + "\" fill=\"freeze\" />" + "\n");
          } else if (s.changes.get(i).get(l) != s.changes.get(i).get(l + 8)) {
            out.append("h\" from=\"" + s.changes.get(i).get(l) + "\" to=\"" s.changes.get(i).get(l + 8) + "\" fill=\"freeze\" />" + "\n");
          } else if (s.changes.get(i).get(l) != s.changes.get(i).get(l + 8)) {
            out.append("r\" from=\"" + s.changes.get(i).get(l) + "\" to=\"" s.changes.get(i).get(l + 8) + "\" fill=\"freeze\" />" + "\n");
          } else if (s.changes.get(i).get(l) != s.changes.get(i).get(l + 8)) {
            out.append("g\" from=\"" + s.changes.get(i).get(l) + "\" to=\"" s.changes.get(i).get(l + 8) + "\" fill=\"freeze\" />" + "\n");
          } else if (s.changes.get(i).get(l) != s.changes.get(i).get(l + 8)) {
            out.append("b\" from=\"" + s.changes.get(i).get(l) + "\" to=\"" s.changes.get(i).get(l + 8) + "\" fill=\"freeze\" />" + "\n");
          }
            out.append("</rect>");
           
          } else if (s instanceof Ellipse) {
            out.append("<animate attributeType=\"xml\" begin=\"" s.changes.get(i).get(0) + "ms\" dur=\"" (s.changes.get(i).get(8) - s.changes.get(i).get(0)) + "ms\" attributeName=\"");
            if (s.changes.get(i).get(l) != s.changes.get(i).get(l + 8)) {
            out.append("cx\" from=\"" + s.changes.get(i).get(l) + "\" to=\"" s.changes.get(i).get(l + 8) + "\" fill=\"freeze\" />" + "\n");
          } else if (s.changes.get(i).get(l) != s.changes.get(i).get(l + 8)) {
            out.append("cy\" from=\"" + s.changes.get(i).get(l) + "\" to=\"" s.changes.get(i).get(l + 8) + "\" fill=\"freeze\" />" + "\n");
          } else if (s.changes.get(i).get(l) != s.changes.get(i).get(l + 8)) {
            out.append("rx\" from=\"" + (s.changes.get(i).get(l) / 2) + "\" to=\"" (s.changes.get(i).get(l + 8) / 2) + "\" fill=\"freeze\" />" + "\n");
          } else if (s.changes.get(i).get(l) != s.changes.get(i).get(l + 8)) {
            out.append("ry\" from=\"" + (s.changes.get(i).get(l) / 2) + "\" to=\"" (s.changes.get(i).get(l + 8) / 2) + "\" fill=\"freeze\" />" + "\n");
          } else if (s.changes.get(i).get(l) != s.changes.get(i).get(l + 8)) {
            out.append("r\" from=\"" + s.changes.get(i).get(l) + "\" to=\"" s.changes.get(i).get(l + 8) + "\" fill=\"freeze\" />" + "\n");
          } else if (s.changes.get(i).get(l) != s.changes.get(i).get(l + 8)) {
            out.append("g\" from=\"" + s.changes.get(i).get(l) + "\" to=\"" s.changes.get(i).get(l + 8) + "\" fill=\"freeze\" />" + "\n");
          } else if (s.changes.get(i).get(l) != s.changes.get(i).get(l + 8)) {
            out.append("b\" from=\"" + s.changes.get(i).get(l) + "\" to=\"" s.changes.get(i).get(l + 8) + "\" fill=\"freeze\" />" + "\n");
          }
            out.append("</ellipse>");
          }
          }
          out.append("</sva>");
        }
      }
    }
    System.exit(0);
  }
}
