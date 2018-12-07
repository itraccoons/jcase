package org.raccoons.backyards;

import javax.annotation.Nullable;

@SuppressWarnings("WeakerAccess")

public class Point2D extends Point implements Cloneable {
  public Point2D() {
    this(0,0);
  }

  /** Constructs and initializes a point at the (x,y) coordinate space. */
  public Point2D(double x, double y) {
    super(x, y);
    // this.coordinateX = x;
    // this.coordinateY = y;
  }

  @Override
  public void setLocation(double... coordinates) {
    this.coordinateX = coordinates[0];
    this.coordinateY = coordinates[1];
  }

  public void setLocation(Point2D p) {
    setLocation(p.coordinateX, p.coordinateY);
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
   * @return  true if it is equal
   */
  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Point2D) {
      Point2D p = (Point2D) o;
      return this.coordinateX == p.coordinateX && this.coordinateY == p.coordinateY;
    }
    return false;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName()
                   + "("
                   + this.coordinateX + "; " + this.coordinateY
                   + ")";
  }
}
