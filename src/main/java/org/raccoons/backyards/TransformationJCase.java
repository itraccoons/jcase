package org.raccoons.backyards;

import java.awt.Point;
import java.util.Scanner;

@SuppressWarnings("InstanceMethodNamingConvention"
)

public class TransformationJCase {
  /**
   * Some text here.
   */
  public static void main(String[] args) {
    Point myPoint = new Point(9, 23);
    Circle myCircle = new Circle(myPoint, 45);


    System.out.println("myCircle is " + myCircle);
    System.out.println("myCircle radius is " + myCircle.getRadius());
    System.out.println("myCircle located at " + myCircle.getCenter());

    myCircle.move(1,1);
    System.out.println("myCircle is " + myCircle);

    myCircle.move(myPoint);
    System.out.println("myCircle is " + myCircle);

  }
}
