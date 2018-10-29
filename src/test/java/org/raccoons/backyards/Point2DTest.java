package org.raccoons.backyards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("WeakerAccess"
)
class Point2DTest {
  private Point2D testPoint;

  @BeforeEach
  public void init() {
    testPoint = new Point2D(9, 23);
  }

  @Test
  void testSetX() {
    testPoint.setX(1);
    Assertions.assertEquals(1, testPoint.getX());
  }

  @Test
  void testSetY() {
    testPoint.setY(1);
    Assertions.assertEquals(1, testPoint.getY());
  }

  @Test
  void testSetLocationWithDouble() {
    testPoint.setLocation(1, 1);
    Assertions.assertEquals(1, testPoint.getX());
    Assertions.assertEquals(1, testPoint.getY());
  }

  @Test
  void testSetLocationWithPoint2D() {
    Point2D p = new Point2D(1, 1);
    testPoint.setLocation(p);
    Assertions.assertEquals(p, testPoint);
  }

  @Test
  void getX() {
    Assertions.assertEquals(9, testPoint.getX());
  }

  @Test
  void getY() {
    Assertions.assertEquals(23, testPoint.getY());
  }
}
