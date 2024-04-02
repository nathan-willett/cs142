package week9;

import java.util.Scanner;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class BounceBallControl extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    BallPane ballPane = new BallPane(); // Create a ball pane

    // Pause and resume animation
    ballPane.setOnMousePressed(e -> ballPane.pause());
    ballPane.setOnMouseReleased(e -> ballPane.play());

    // Increase and decrease animation   
    ballPane.setOnKeyPressed(e -> {
      if (e.getCode() == KeyCode.UP) {
        ballPane.increaseSpeed();
      } 
      else if (e.getCode() == KeyCode.DOWN) {
        ballPane.decreaseSpeed();
      }
    });

    // Create a scene and place it in the stage
    Scene scene = new Scene(ballPane, 250, 150);
    primaryStage.setTitle("BounceBallControl"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    
    // Must request focus after the primary stage is displayed
    ballPane.requestFocus();
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
    Scanner input = new Scanner(System.in);

    System.out.print("Enter point1's x-, y-coordinates: ");
    double x1 = input.nextDouble();
    double y1 = input.nextDouble();
    System.out.print("Enter point2's x-, y-coordinates: ");
    double x2 = input.nextDouble();
    double y2 = input.nextDouble();

    Point2D p1 = new Point2D(x1, y1); // Create a Point2D for (x1, y1)
    Point2D p2 = new Point2D(x2, y2); 
    System.out.println("p1 is " + p1.toString());
    System.out.println("p2 is " + p2.toString());
    System.out.println("The distance between p1 and p2 is " + 
      p1.distance(p2)); 
    System.out.println("The midpoint between p1 and p2 is " + 
      p1.midpoint(p2).toString());
  }
}