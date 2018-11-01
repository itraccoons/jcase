package org.raccoons.backyards;

import java.io.Serializable;

@SuppressWarnings("WeakerAccess"
)

public class Point2D implements Cloneable {

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
    setLocation(p.getX(), p.getY());
  }

  public double getX() {
    return coordinateX;
  }

  public double getY() {
    return coordinateY;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
//    try {
      return super.clone();
//    } catch (CloneNotSupportedException e) {
//      throw new InternalError(e);
//    }
  }

  /**
   *  Compares two points for equality. This returns true if they have the
   * same coordinates.
   *
   * @param o the point to compare
   * @return true if it is equal
   */
  @Override
  public boolean equals(Object o) {
    if (! (o instanceof Point2D)) {
      return false;
    }
    Point2D p = (Point2D) o;
    return getX() == p.getX() && getY() == p.getY();
  }

  @Override
  public String toString() {
    return getClass().getName() + "[x=" + coordinateX + ",y=" + coordinateY + "]";
  }
}
