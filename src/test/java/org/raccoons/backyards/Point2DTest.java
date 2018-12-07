package org.raccoons.backyards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("WeakerAccess"
)
class Point2DTest {
  private Point2D expectedPoint;
  private Point2D testPoint;

  @BeforeEach
  public void init() {
    expectedPoint = new Point2D(0.1d, 0.2d);
    testPoint = new Point2D();
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
    testPoint.setLocation(0.1d, 0.2d);
    Assertions.assertEquals(0.1, testPoint.getX());
    Assertions.assertEquals(0.2, testPoint.getY());
  }

  @Test
  void testSetLocationWithPoint2D() {
    testPoint.setLocation(expectedPoint);
    Assertions.assertEquals(expectedPoint, testPoint);
  }

  @Test
  void testGetX() {
    Assertions.assertEquals(0, testPoint.getX());
  }

  @Test
  void testGetY() {
    Assertions.assertEquals(0, testPoint.getY());
  }

  @Test
  void testToString() {
    String expectedString = "Point2D(0.0; 0.0)";
    Assertions.assertEquals(expectedString, testPoint.toString());
  }

  @Test
  void equalsFailsIfWrongObjectProvided() {
    Object testObject = new Object();
    Assertions.assertFalse(expectedPoint.equals(testObject));
  }

  @Test
  void equalsFailsIfNoLogicalEquivalence() {
    Assertions.assertFalse(testPoint.equals(expectedPoint));
  }

  @Test
  void cloneFailsIfObjectsNotEquial() {
    try {
      testPoint = expectedPoint.clone();
    } catch (CloneNotSupportedException e) {
      throw new InternalError(e);
    }
    Assertions.assertEquals(expectedPoint, testPoint);
  }


}
