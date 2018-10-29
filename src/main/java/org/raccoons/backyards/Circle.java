package org.raccoons.backyards;

@SuppressWarnings("WeakerAccess"
)

public class Circle {
  private Point2D center;
  private int radius;

  public Circle() {
    this(new Point2D(0, 0));
  }

  public Circle(int x, int y, int radius) {
    this(new Point2D(x, y), radius);
  }

  public Circle(Point2D center) {
    this(center, 1);
  }

  public Circle(Point2D center, int radius) {
    this.setCenter(center);
    this.radius = radius;
  }

  public void setCenter(int x, int y) {
    this.setCenter(new Point2D(x, y));
  }

  public void setCenter(Point2D center) {
    this.center = center;
  }

  public void move(int x, int y) {
    this.setCenter(new Point2D(x, y));
  }

  public void move(Point2D center) {
    this.center = center;
  }

  public int getRadius() {
    return radius;
  }

  public Point2D getCenter() {
    return this.center;
  }

  public String toString() {
    return "Circle[" + this.center.toString() + ", " + this.radius + "]";
  }
}
