package org.raccoons.backyards;

import javax.annotation.Nullable;

@SuppressWarnings("WeakerAccess")

public class Circle {
  private Point2D center;
  private double radius;

  public Circle() {
    this(new Point2D(0, 0));
  }

  public Circle(double x, double y, double radius) {
    this(new Point2D(x, y), radius);
  }

  public Circle(Point2D center) {
    this(center, 1);
  }

  public Circle(Point2D center, double radius) {
    this.center = center;
    this.radius = radius;
  }

  public void setCenterTo(double x, double y) {
    this.setCenterTo(new Point2D(x, y));
  }

  public void setCenterTo(Point2D center) {
    this.center = center;
  }

  public Point2D getCenter() {
    return this.center;
  }

  public void setRadiusAs(double radius) {
    this.radius = radius;
  }

  public double getRadius() {
    return this.radius;
  }

  /**
   * Missing a Javadoc comment.
   */
  @Override
  public String toString() {
    return getClass().getName()
                   + "[x=" + this.center.getX()
                   + ",y=" + this.center.getY()
                   + ",r=" + this.radius
                   + "]";
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(@Nullable Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj instanceof Circle) {
      Circle c = (Circle)obj;
      // return this.center == c.center && this.radius == c.radius;
      return this.center.equals(c.center) && this.radius == c.radius;
    }
    return false;
  }
}
