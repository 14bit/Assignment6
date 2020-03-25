package cs3500.excellence.hw05;

import java.util.ArrayList;

/**
 * Represents Rectangles that can be animated. Each has a list of "Changes" that keep track of what
 * they should look like and where they should be at any given time.
 */
public class Rectangle extends Shape {

  /**
   * Default constructor for Rectangles.
   *
   * @param name    the name of this shape
   */
  public Rectangle(String name) {
    super(name);
  }

  @Override
  public String getChanges() {
    StringBuilder output = new StringBuilder();
    output.append("Rectangle " + name + "\n");
    if (changes.size() != 0) {
      for (ArrayList<Integer> i: changes) {
        output.append("Change:" + i.toString() + "\n");
      }
    } else {
      output.append("No listed changes\n");
    }
    return output.toString();
  }
}
