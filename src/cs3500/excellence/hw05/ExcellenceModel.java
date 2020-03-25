package cs3500.excellence.hw05;

import cs3500.animator.util.AnimationBuilder;
import cs3500.animator.util.AnimationReader;
import java.util.ArrayList;

/**
 * A model that represents an animation created with our Excellence animator.
 */
public class ExcellenceModel implements ExcellenceOperations {

  ArrayList<Shape> shapeArrayList = new ArrayList<>();

  //TODO: Set up canvas size and things, we forgot to do that last time

  @Override
  public void addShape(Shape s) {
    shapeArrayList.add(s);
  }

  @Override
  public void removeShape(String name) {

    for (Shape s : shapeArrayList) {
      if (s.name == name) {
        shapeArrayList.remove(s);
        return;
      }
    }
    throw new IllegalArgumentException("There's no shape named that!");
  }

  @Override
  public void addChangeToShape(String name, int t1, int x1, int y1, int w1, int h1, int r1,
      int g1,
      int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2) {
    for (Shape s : shapeArrayList) {
      if (s.name == name) {
        shapeArrayList.get(shapeArrayList.indexOf(s))
            .addChange(t1, x1, y1, w1, h1, r1, g1, b1, t2, x2, y2, w2, h2, r2, g2, b2);
        return;
      }
    }
    throw new IllegalArgumentException("There's no shape named that!");
  }

  @Override
  public void removeChangeFromShape(String name, boolean front) {

    for (Shape s : shapeArrayList) {
      if (s.name == name) {
        if (front) {
          shapeArrayList.get(shapeArrayList.indexOf(s))
              .removeFirstChange();
        } else {
          shapeArrayList.get(shapeArrayList.indexOf(s))
              .removeLastChange();
        }
        return;
      }
    }
    throw new IllegalArgumentException("There's no shape named that!");
  }

  @Override
  public String displayLog() {
    StringBuilder output = new StringBuilder();
    for (Shape s : shapeArrayList) {
      output.append(s.getChanges());
    }
    return output.toString();
  }

  //TODO: All of this class needs to be implemented

  /**
   * The implementation of the AnimationBuilder interface. Used to translate inputs from
   * AnimationReader into a form that this model can understand!
   */
  public static final class Builder implements AnimationBuilder<ExcellenceOperations> {

    ExcellenceOperations model;

    Builder() {
      ExcellenceOperations model = new ExcellenceModel();
    }

    @Override
    public ExcellenceOperations build() {
      return null;
    }

    @Override
    public AnimationBuilder<ExcellenceOperations> setBounds(int x, int y, int width, int height) {
      return null;
    }

    @Override
    public AnimationBuilder<ExcellenceOperations> declareShape(String name, String type) {
      switch (type) {
        case "rectangle":
          model.addShape(new Rectangle(name));
        case "ellipse":
          model.addShape(new Ellipse(name));
      }
      return this;
    }

    @Override
    public AnimationBuilder<ExcellenceOperations> addMotion(String name, int t1, int x1, int y1,
        int w1, int h1, int r1, int g1, int b1, int t2, int x2, int y2, int w2, int h2, int r2,
        int g2, int b2) {
      return null;
    }

    @Override
    public AnimationBuilder<ExcellenceOperations> addKeyframe(String name, int t, int x, int y,
        int w, int h, int r, int g, int b) {
      return null;
    }
    // FILL IN HERE
  }

}