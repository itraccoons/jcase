package org.raccoons.backyards;

@SuppressWarnings("WeakerAccess"
)

public class Point2D {

  /*
   * The x and y coordinates
   */
  private double coordinateX;
  private double coordinateY;

  public Point2D() {
  }

  public Point2D(double x, double y) {
    this.coordinateX = x;
    this.coordinateY = y;
  }

  public void setX(double x) {
    this.coordinateX = x;
  }

  public void setY(double y) {
    this.coordinateY = y;
  }

  public void setLocation(double x, double y) {
    this.coordinateX = x;
    this.coordinateY = y;
  }

  public void setLocation(Point2D p) {
    this.coordinateX = p.getX();
    this.coordinateY = p.getY();
  }

  public double getX() {
    return coordinateX;
  }

  public double getY() {
    return coordinateY;
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
    return getClass().getName() + "[x=" + coordinateX + ",y=" + coordinateY + "]";
  }
}
