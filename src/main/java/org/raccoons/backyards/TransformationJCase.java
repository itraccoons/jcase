package org.raccoons.backyards;

import java.awt.Point;


@SuppressWarnings("InstanceMethodNamingConvention"
)

public class TransformationJCase {
  /**
   * Some text here.
   *
   * @param args  XXX
   */
  public static void main(String[] args) {

    Point2D myPoint2D = new Point2D(9, 23);
    //Circle myCircle = new Circle(myPoint2D, 45);
    System.out.println(myPoint2D);
    //System.out.println(myCircle);

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
