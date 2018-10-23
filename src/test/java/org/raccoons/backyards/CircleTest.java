package org.raccoons.backyards;

import java.awt.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("WeakerAccess"
)

public class CircleTest {
  private Point myPoint;
  private Circle myCircle;

  @BeforeEach
  public void init() {
    myPoint = new Point(9, 23);
    myCircle = new Circle(9,23, 45);
  }

  @Test
  public void testGetCenter() {
    Assertions.assertEquals(myPoint, myCircle.getCenter());
  }

  @Test
  public void testGetRadius() {
    Assertions.assertEquals(45, myCircle.getRadius());
  }
}
