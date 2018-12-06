package org.raccoons.backyards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SuppressWarnings("InstanceMethodNamingConvention")

// @SpringBootApplication
public class TransformationJCase {
  /**
   * App entry point.
   *
   * @param args    an array of command-line arguments for the application
   */
  public static void main(String[] args) {
    // SpringApplication.run(TransformationJCase.class, args);

    Point2D myPoint2D_1 = new Point2D(0,0),
            myPoint2D_2 = new Point2D(0,1),
            myPoint2D_3 = new Point2D(0,2);

    try {
      Triangle myTriangle = new Triangle(myPoint2D_1, myPoint2D_2, myPoint2D_3);
      System.out.println(myTriangle);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
