package cs3500.excellence.hw05;

/**
 * This is the interface of the Excellence animator model. Implementations of this represent
 * animations.
 */
public interface ExcellenceOperations {

  /**
   * Adds the given Shape to the animation.
   *
   * @param s Shape to be added to the animation
   */
  void addShape(Shape s);

  /**
   * Removes the shape at the given shapeIndex in the animation.
   *
   * @param shapeIndex  The index of the shape you are removing
   * @throws IllegalArgumentException if the given shapeIndex does not exist
   */
  void removeShape(int shapeIndex);

  /**
   * Adds a new change to the shape at the given shapeIndex, with the given parameters. Throws an
   * error if there's no shape at that index.
   *
   * @param shapeIndex The index of the shape you are adding a change to
   * @param t1         Starting time of the change
   * @param x1         Starting x position of the change
   * @param y1         Starting y position of the change
   * @param w1         Starting width of the change
   * @param h1         Starting height of the change
   * @param r1         Starting red color value of the change
   * @param g1         Starting green color value of the change
   * @param b1         Starting blue color value of the change
   * @param t2         Ending time of the change
   * @param x2         Ending x position of the change
   * @param y2         Ending y position of the change
   * @param w2         Ending width of the change
   * @param h2         Ending height of the change
   * @param r2         Ending red color value of the change
   * @param g2         Ending green color value of the change
   * @param b2         Ending blue color value of the change
   * @throws IllegalArgumentException if the given shapeIndex does not exist
   */
  void addChangeToShape(int shapeIndex, int t1, int x1, int y1, int w1, int h1, int r1, int g1,
      int b1, int t2,
      int x2, int y2, int w2, int h2, int r2, int g2, int b2);

  /**
   * Removes either the first change or the last change of the shape at the given index. Throws an
   * error if it doesn't exist, or there are no changes.
   *
   * @param shapeIndex The index of the shape you are removing a change from
   * @param front      Are we removing the first change of this shape?
   * @throws IllegalArgumentException if the given shapeIndex does not exist
   * @throws IllegalArgumentException if there are no changes on this shape
   */
  void removeChangeFromShape(int shapeIndex, boolean front);

  /**
   * Displays all changes that all shapes have during the animation in text format.
   *
   * @return A formatted string of all shapes and their changes in the animation.
   */
  String displayLog();

}
