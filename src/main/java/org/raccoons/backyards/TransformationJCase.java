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

    Point2D myPoint2D1 = new Point2D();
    Point2D myPoint2D2 = new Point2D(1,1);
    Point2D myPoint2D3 = new Point2D(0,2);

    System.out.println(myPoint2D1);
    System.out.println(myPoint2D2);
    System.out.println(myPoint2D3);

    try (Triangle myTriangle = new Triangle(myPoint2D1, myPoint2D2, myPoint2D3)) {
      System.out.println(myTriangle);
    } catch (IllegalArgumentException e) {
      System.out.println(e);
    }
  }

}
