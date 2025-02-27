package cs3500.excellence.hw05;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents 2D shapes that can be animated. Each has a list of "Changes" that keep track of what
 * they should look like and where they should be at any given time.
 */
public abstract class Shape {

  public String name;
  public ArrayList<ArrayList<Integer>> changes;

  /**
   * Default constructor for Shapes. Takes in a name.
   *
   * @param name the name of this shape
   */
  public Shape(String name) {
    this.name = name;
    this.changes = new ArrayList<>();
  }

  /**
   * Adds a change to this shape, with the given starting position, size, and color at the given
   * time, that goes to the given position, size, and color at the given time. This change must be
   * either before the start of the current first change, or after the current last change for this
   * shape, ensuring there are no gaps in the animation. If the end time is before the start time,
   * throw and error. If either the start or end time overlap with an existing change, throws an
   * error. If any of the start and end and values of the new change do not line up with an existing
   * one, throw and error.
   *
   * @param t1 Starting time
   * @param x1 Starting x position
   * @param y1 Starting y position
   * @param w1 Starting width
   * @param h1 Starting height
   * @param r1 Starting red color value
   * @param g1 Starting green color value
   * @param b1 Starting blue color value
   * @param t2 Ending time
   * @param x2 Ending x position
   * @param y2 Ending y position
   * @param w2 Ending width
   * @param h2 Ending height
   * @param r2 Ending red color value
   * @param g2 Ending green color value
   * @param b2 Ending blue color value
   * @throws IllegalArgumentException when change is illogical
   * @throws IllegalArgumentException when given time values overlap existing changes
   * @throws IllegalArgumentException when given values are not the same as previous or next change
   */
  public void addChange(int t1, int x1, int y1, int w1, int h1, int r1, int g1, int b1, int t2,
      int x2, int y2, int w2, int h2, int r2, int g2, int b2) {
    checkMoveIsLogical(t1, t2, w2, h2, r2, g2, b2);
    //if there's existing changes logged, check to make sure it fits in with them
    if (changes.size() > 0) {
      //is the end time of the proposed change the same as the first change in the list?
      if (t2 == changes.get(0).get(0)) {
        //if so, we're putting it at the front, so check that values line up
        ArrayList<Integer> friend = changes.get(0);
        checkSameValues(x2, y2, w2, h2, r2, g2, b2, friend.get(1), friend.get(2), friend.get(3),
            friend.get(4), friend.get(5), friend.get(6), friend.get(7));
        //then add the change to the start of the list if it works
        changes.add(0, new ArrayList<>(Arrays.asList(t1, x1, y1, w1, h1, r1, g1, b1, t2,
            x2, y2, w2, h2, r2, g2, b2)));
      } else {
        //otherwise, check if we need to put this at the end of the list of changes
        //Check if the start time for this change is the same as the end
        // time of the last change
        if (t1 == changes.get(changes.size() - 1).get(8)) {
          //if so, we're putting it at the back, so check that values line up
          ArrayList<Integer> friend = changes.get(changes.size() - 1);
          checkSameValues(x1, y1, w1, h1, r1, g1, b1, friend.get(9), friend.get(10), friend.get(11),
              friend.get(12), friend.get(13), friend.get(14), friend.get(15));
          //then add the change if it works
          changes.add(new ArrayList<>(Arrays.asList(t1, x1, y1, w1, h1, r1, g1, b1, t2,
              x2, y2, w2, h2, r2, g2, b2)));
        } else {
          //Throw a time error, since something timeline-wise hasn't lined up
          throw new IllegalArgumentException(
              "You've broken time! Your new change doesn't fit at the start or end of the"
                  + "existing changes, time-wise.");
        }
      }
    } else {
      //if there's nothing else to check against, just add it.
      changes.add(new ArrayList<>(Arrays.asList(t1, x1, y1, w1, h1, r1, g1, b1, t2,
          x2, y2, w2, h2, r2, g2, b2)));
    }
  }

  /**
   * Helper method, checks that each value pair is equal. This is called to make sure that no values
   * are mismatched when adding a new change.
   *
   * @param x1 First x position to check
   * @param y1 First y position to check
   * @param w1 First width to check
   * @param h1 First height to check
   * @param r1 First red value to check
   * @param g1 First green value to check
   * @param b1 First blue value to check
   * @param x2 Second x position to check
   * @param y2 Second y position to check
   * @param w2 Second width to check
   * @param h2 Second height to check
   * @param r2 Second red value to check
   * @param g2 Second green value to check
   * @param b2 Second blue value to check
   */
  private void checkSameValues(int x1, int y1, int w1, int h1, int r1, int g1, int b1,
      int x2, int y2, int w2, int h2, int r2, int g2, int b2) {
    if (x1 != x2 || y1 != y2 || w1 != w2 || h1 != h2 || r1 != r2 || g1 != g2 || b1 != b2) {
      throw new IllegalArgumentException("Something doesn't line up with those values!");
    }
  }

  /**
   * Helper method, checks that a given move is logically possible. So, the end is after the start,
   * scales are not negative, and colors are in acceptable ranges.
   *
   * @param t1 Starting time
   * @param t2 Ending time
   * @param w2 Ending width
   * @param h2 Ending height
   * @param r2 Ending red color value
   * @param g2 Ending green color value
   * @param b2 Ending blue color value
   * @throws IllegalArgumentException if any value is outside of bounds or illogical
   */
  private void checkMoveIsLogical(int t1, int t2, int w2, int h2, int r2, int g2, int b2) {
    //check that the time makes sense
    if (t1 < 0) {
      throw new IllegalArgumentException(
          "Time 1 can't be less than 0!");
    }
    if (t1 > t2) {
      throw new IllegalArgumentException(
          "Time 2 cannot be before Time 1 in a change!");
    }
    //check that the size makes sense
    if (w2 <= 0 || h2 <= 0) {
      throw new IllegalArgumentException("Width and/or Height cannot be Zero or Negative!");
    }
    //check that the colors make sense
    if (r2 < 0 || r2 > 255 || b2 < 0 || b2 > 255 || g2 < 0 || g2 > 255) {
      throw new IllegalArgumentException("Width and/or Height cannot be Zero or Negative!");
    }
  }

  /**
   * Removes the first change from this shape.
   *
   * @throws IllegalStateException when trying to call this when there's no changes in this shape
   */
  public void removeFirstChange() {
    if (changes.size() == 0) {
      throw new IllegalStateException("There's no changes to remove!");
    } else {
      changes.remove(0);
    }
  }

  /**
   * Removes the last change in the from this shape.
   *
   * @throws IllegalStateException when trying to call this when there's no changes in this shape
   */
  public void removeLastChange() {
    if (changes.size() == 0) {
      throw new IllegalStateException("There's no changes to remove!");
    } else {
      changes.remove(changes.size() - 1);
    }
  }

  /**
   * Returns a list of all changes as text.
   *
   * @return a string describing this shape and all of it's changes
   */
  public String getChanges() {
    return null;
  }
}
