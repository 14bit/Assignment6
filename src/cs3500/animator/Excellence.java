package cs3500.animator;

import cs3500.animator.util.AnimationReader;
import cs3500.animator.view.ExcellenceView;
import cs3500.animator.view.ViewFactory;
import cs3500.excellence.hw05.ExcellenceModel.Builder;
import cs3500.excellence.hw05.ExcellenceOperations;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//TODO: Implement this entire class
public class Excellence {

  private static FileReader input;
  private static Appendable out = System.out;
  private static String view;
  private static int speed = 1;

  //TODO: JavaDoc
  public static void main(String[] args) {

    //parse the command line arguments
    for (int i = 0; i < args.length; i++) {
      if (args[i].startsWith("-")) {
        try {
          switch (args[i]) {
            case "-in":
              input = new FileReader(args[i++]);
            case "-out":
              out = new FileWriter(args[i++]);
            case "-view":
              view = args[i++];
            case "-speed":
              speed = Integer.parseInt(args[i++]);
          }
        } catch (NullPointerException e) {
          //throw error for missing an argument
        } catch (NumberFormatException e) {
          //throw error for speed not being a number
        } catch (IllegalArgumentException e) {
          //throw error for an invalid input
        } catch (FileNotFoundException e) {
          //throw an error for not finding the file
          e.printStackTrace();
        } catch (IOException e) {
          //not being able to find the output file
          e.printStackTrace();
        }
      }
    }

    if (input == null || view == null) {
      //throw error for missing input or view!
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.pack();
      frame.setVisible(true);
      JOptionPane.showMessageDialog(frame,
          "You didn't provide either an input or a view!",
          "Missing Argument",
          JOptionPane.ERROR_MESSAGE);
      System.exit(0);
    }

    //returns our model, with the input file imported
    ExcellenceOperations ourModel = new AnimationReader().parseFile(input, new Builder());

    //Set up the view we are using with the factory and our constructed model
    ExcellenceView ourView = new ViewFactory().getView(view, ourModel);

    //Set the tickrate for the view
    ourView.setTickRate(speed);

    //make the view visible
    ourView.makeVisible();

    //Give the view the output, and set it going! The view takes over from here.
    ourView.go(out);
  }
}
