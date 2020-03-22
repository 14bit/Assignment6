package cs3500.animator.view;

/**
 * A factory for the different views. Used to figure out which view to create when setting one
 * up from the command line.
 */
public class ViewFactory {

  /**
   * Figure out which view is needed from the given string, and return it.
   *
   * @param viewString    The view that needs to be created
   * @return a new view of the correct type
   */
  public ExcellenceView getView(String viewString) {
    switch (viewString) {
      case "text":
        return new ViewText();
      case "visual":
        return new ViewAnimation();
      case "svg":
        return new ViewSVG();
      default:
        return null;
    }
  }
}
