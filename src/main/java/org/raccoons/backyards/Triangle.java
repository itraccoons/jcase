/*
 * Copyright (C) 2018
 *
 * Need to put here copyright notes
 */

package org.raccoons.backyards;

import javax.annotation.Nullable;

/**
 * Need to put here description what class implements.
 * notes: First sentence of Javadoc ending period is "." even if just one word!!!
 *
 * @author Oleksii Kucheruk
 * @since 2018-12-04
 */
public class Triangle {
  // Three points of triangle
  private Point pointA;
  private Point pointB;
  private Point pointC;

  /**
   * Constructs and initializes a triangle at the points origin a(0; 0), b(0; 1), c(1;0)
   * of the coordinate space.
   *
   * @throws IllegalArgumentException if three points does not determine triangle
   */
  public Triangle() throws IllegalArgumentException {
    // this(new Point2D(0,0), new Point2D(0,1), new Point2D(1,0));
    throw new IllegalArgumentException(
            getClass().getSimpleName() + " constructor call without arguments is not allowed");
  }

  /**
   * Constructs and initializes a triangle with the location as the specified three Point
   * points.
   *
   * @param pointA First triangle point
   * @param pointB Second triangle point
   * @param pointC Third triangle point
   * @throws       IllegalArgumentException if three points does not determine triangle
   */
  public Triangle(Point pointA, Point pointB, Point pointC) throws IllegalArgumentException {
    if (isCollinear(pointA, pointB, pointC)) {
      throw new IllegalArgumentException("Points does not determines triangle");
    }

    this.pointA = pointA;
    this.pointB = pointB;
    this.pointC = pointC;
  }

  /**
   * Check if three points are collinear and does not determines two-dimensional triangle.
   * For three points, slope of any pair of points must be same as other pair.
   * (y3 - y2)/(x3 - x2) = (y2 - y1)/(x2 - x1).
   * In other words, (y3 - y2)(x2 - x1) = (y2 - y1)(x3 - x2)
   *
   * @param pointA First triangle point
   * @param pointB Second triangle point
   * @param pointC Third triangle point
   * @return       true when three points are collinear.
   */
  private static boolean isCollinear(Point pointA, Point pointB, Point pointC) {
    if (allInstanceOf(Point2D.class, pointA, pointB, pointC)) {
      return (pointC.getY() - pointB.getY()) * (pointB.getX() - pointA.getX())
                     == (pointB.getY() - pointA.getY()) * (pointC.getX() - pointB.getX());
    } else if (allInstanceOf(Point3D.class, pointA, pointB, pointC)) {
      return false;
    } else {
      return false;
    }
  }

  private static boolean allInstanceOf(Class<?> cls, Object... objs) {
    for (Object o : objs) {
      if (!cls.isInstance(o)) {
        return false;
      }
    }
    return true;
  }

  /**
   * need to read J.Bloch "effective java se"
   * @return hash of triangle
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * Determines whether or not two triangles are equal.
   *
   * @param  obj an object to be compared with this triangle
   * @return     true if the object to be compared is an instance of Triangle and has the same
   *             values; false otherwise.
   */
  @Override
  public boolean equals(@Nullable Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj instanceof Triangle) {
      Triangle t = (Triangle) obj;
      return this.pointA.equals(t.pointA)
                     && this.pointB.equals(t.pointB)
                     && this.pointC.equals(t.pointC);
    }
    return false;
  }

  /**
   * Returns a string representation of this triangle and its location in the (x,y) or (x,y,z)
   * coordinate space.
   */
  @Override
  public String toString() {
    return getClass().getSimpleName()
                   + "["
                   + this.pointA.toString() + ", "
                   + this.pointB.toString() + ", "
                   + this.pointC.toString()
                   + "]";
  }
}
