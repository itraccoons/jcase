package org.raccoons.backyards;

@SuppressWarnings("WeakerAccess"
)

public class Point2D {

  /*
   * The x and y coordinates
   */
  private double x;
  private double y;

  public Point2D() {
  }

  public Point2D(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public void setX(double x) {
    this.x = x;
  }

  public void setY(double y) {
    this.y = y;
  }

  public void setLocation(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public void setLocation(Point2D p) {
    this.x = p.getX();
    this.y = p.getY();
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj instanceof Point2D) {
      Point2D p = (Point2D)obj;
      return getX() == p.getX() && getY() == p.getY();
    }
    return false;
  }

  @Override
  public String toString() {
    return getClass().getName() + "[x=" + x + ",y=" + y + "]";
  }
}
