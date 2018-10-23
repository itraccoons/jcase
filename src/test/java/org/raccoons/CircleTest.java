package org.raccoons;

import java.awt.Point;
import org.junit.Assert;
import org.junit.Test;
import org.raccoons.backyards.Circle;

public class CircleTest {
  @Test
  public void testGetCenter() {
    Point myPoint = new Point(9, 23);
    Circle myCircle = new Circle(9,23, 45);
    Assert.assertEquals(myPoint, myCircle.getCenter());
    Assert.assertEquals(45, myCircle.getRadius());
  }
}
