package org.raccoons.backyards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("WeakerAccess"
)

public class CircleTest {
  private Point2D expectedCenter;
  private Circle expectedCircle;
  private Circle testedCircle;

  /**
   * Missing a Javadoc comment.
   */
  @BeforeEach
  public void init() {
    expectedCenter = new Point2D(9, 23);
    expectedCircle = new Circle(expectedCenter, 45);
    testedCircle =  new Circle();
  }

  @Test
  void testSetCenter() {
    testedCircle.setCenterTo(expectedCenter);
    Assertions.assertEquals(expectedCenter, testedCircle.getCenter());
  }

  @Test
  public void testGetCenter() {
    testedCircle.setCenterTo(expectedCircle.getCenter());
    Assertions.assertEquals(expectedCircle.getCenter(), testedCircle.getCenter());
  }

  @Test
  void testSetRadius() {
    testedCircle.setCenterTo(expectedCircle.getCenter());
    testedCircle.setRadiusAs(expectedCircle.getRadius());
    Assertions.assertEquals(expectedCircle, testedCircle);
  }

  @Test
  public void testGetRadius() {
    testedCircle.setRadiusAs(expectedCircle.getRadius());
    Assertions.assertEquals(expectedCircle.getRadius(), testedCircle.getRadius());
  }


}
