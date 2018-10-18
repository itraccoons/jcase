package org.raccoons.backyards;

import java.awt.Point;

@SuppressWarnings("WeakerAccess"
)

public class Circle {
  private Point center;
  private int radius;

  public Circle() {
    this(new Point(0, 0));
  }

  public Circle(int x, int y, int radius) {
    this(new Point(x, y), radius);
  }

  public Circle(Point center) {
    this(center, 1);
  }

  public Circle(Point center, int radius) {
    this.setCenter(center);
    this.radius = radius;
  }

  public void setCenter(int x, int y) {
    this.setCenter(new Point(x, y));
  }

  public void setCenter(Point center) {
    this.center = center;
  }

  public void move(int x, int y) {
    this.setCenter(new Point(x, y));
  }

  public void move(Point center) {
    this.center = center;
  }

  public int getRadius() {
    return radius;
  }

  public Point getCenter() {
    return this.center;
  }

  public String toString() {
    return "Circle[" + this.center.toString() + ", " + this.radius + "]";
  }
}
