package cs3500.animator.view;

//TODO: Design the functionality that all views will share
/**
 * The  for our views of the Excellence Animator. All three views implement this interface
 * to ensure they share functionality.
 */
public interface ExcellenceView {

  /**
   * Sets the tickRate for this animation. If this isn't called, the default tickRate remains
   * at one tick per second.
   *
   * @param rate   The new tickRate we are setting for this animation
   * @throws IllegalArgumentException if you pass it zero or a negative
   */
  void setTickRate(int rate);

  /**
   * Make this view visible. Call this after we construct this view. Not really used in the two
   * text-based views.
   */
  void makeVisible();

  /**
   * Refresh this view to show any changes.
   */
  void refresh();

  //TODO: There's more that this needs to do, it needs all functionality for all views, then
  // in those views we just don't use the parts that don't apply.
}
