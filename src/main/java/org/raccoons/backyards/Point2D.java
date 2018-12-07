package org.raccoons.backyards;

import javax.annotation.Nullable;

@SuppressWarnings("WeakerAccess")

public class Point2D extends Point implements Cloneable {
  public Point2D() {
    this(0,0);
  }

  public Point2D(double x, double y) {
    super(x, y);
  }

  @Override
  public void setLocation(double... coordinates) {
    this.coordinateX = coordinates[0];
    this.coordinateY = coordinates[1];
  }

  @Override
  public void setLocation(Point point) {
    if (point instanceof Point2D) {
      setLocation(point.coordinateX, point.coordinateY);
    } else {
      throw new IllegalArgumentException("XXX");
    }
  }

  @Override
  protected Point2D clone() throws CloneNotSupportedException {
    return (Point2D) super.clone();
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * Compares two points for equality. This returns true if they have the
   * same coordinates.
   *
   * @param o the point to compare
   * @return true if it is equal
   */
  @Override
  public boolean equals(@Nullable Object o) {
    if (! (o instanceof Point2D)) {
      return false;
    }
    Point2D p = (Point2D) o;
    return this.coordinateX == p.coordinateX && this.coordinateY == p.coordinateY;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName()
                   + "("
                   + this.coordinateX + "; " + this.coordinateY
                   + ")";
  }
}
