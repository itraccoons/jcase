package org.raccoons.backyards;

import java.awt.Point;


@SuppressWarnings("InstanceMethodNamingConvention"
)

public class TransformationJCase {
  /**
   * App entry point.
   *
   * @param args    an array of command-line arguments for the application
   */
  public static void main(String[] args) {

    Point2D myPoint2D = new Point2D(9, 23);
    Circle myCircle = new Circle();
    System.out.println(myPoint2D);
    System.out.println(myCircle);

    /*

    System.out.println("myCircle is " + myCircle);
    System.out.println("myCircle radius is " + myCircle.getRadius());
    System.out.println("myCircle located at " + myCircle.getCenter());

    myCircle.move(1,1);
    System.out.println("myCircle is moved by (x,y) to " + myCircle);

    myCircle.move(myPoint);
    System.out.println("myCircle is moved by myPoint to " + myCircle);
  */
  }
}
