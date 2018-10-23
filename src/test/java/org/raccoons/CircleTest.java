package org.raccoons;

import java.awt.Point;
import org.junit.Assert;
import org.junit.Test;
import org.raccoons.backyards.Circle;

public class CircleTest {
  @Test
  public void testGetCenter() {
    Point myPoint = new Point(9, 23);
    Circle myCircle = new Circle(myPoint, 45);
    Assert.assertEquals("Raccoon1", myPoint, myCircle.getCenter());
    Assert.assertEquals("Raccoon1", 45, myCircle.getRadius());
  }
}
