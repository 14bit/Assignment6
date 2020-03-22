package cs3500.excellence.hw05;

import java.util.ArrayList;

/**
 * Represents Ellipses that can be animated. Each has a list of "Changes" that keep track of what
 * they should look like and where they should be at any given time.
 */
public class Ellipse extends Shape {

  public ArrayList<ArrayList<Integer>> changes;

  /**
   * Default constructor for Ellipses. Takes no arguments.
   */
  public Ellipse() {
    this.changes = super.changes;
  }

  @Override
  public String getChanges() {
    StringBuilder output = new StringBuilder();
    output.append("Ellipse " + this.hashCode() + "\n");
    if (changes.size() != 0) {
      for (ArrayList<Integer> i : changes) {
        output.append("Change:" + i.toString() + "\n");
      }
    } else {
      output.append("No listed changes\n");
    }
    return output.toString();
  }

}
