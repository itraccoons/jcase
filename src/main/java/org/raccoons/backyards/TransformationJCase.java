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

    Point myPoint2 = new Point2D();

    Point a2 = new Point2D();
    Point b2 = new Point2D();
    Point c2 = new Point2D(0,2);

    b2.setLocation(a2.coordinateX + 1, a2.coordinateY);
    System.out.println(a2 + "-" + b2 + "-" + c2);

    Point a3 = new Point3D();
    Point b3 = new Point3D();
    Point c3 = new Point3D(10,11,12);

    b3.setLocation(a3.coordinateX + 10, a3.coordinateY, a3.coordinateZ);
    System.out.println(a3 + "-" + b3 + "-" + c3);

    try {
      Triangle myTriangleIn2D = new Triangle(a2, b2, c2);
      System.out.println(myTriangleIn2D);

      Triangle myTriangleIn3D = new Triangle(a3, b3, c3);
      System.out.println(myTriangleIn3D);
    } catch (IllegalArgumentException e) {
      System.out.println(e);
    }

  }

}
