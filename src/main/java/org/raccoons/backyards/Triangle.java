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
  private Point2D pointA;
  private Point2D pointB;
  private Point2D pointC;

  /**
   * Constructs and initializes a triangle at the points origin a(0; 0), b(0; 1), c(1;0)
   * of the coordinate space.
   */
  public Triangle() throws Exception {
    this(new Point2D(0,0), new Point2D(0,1), new Point2D(1,0));
  }

  /**
   * Constructs and initializes a triangle with the location as the specified three Point2D
   * points.
   *
   * @param pointA First triangle point
   * @param pointB Second triangle point
   * @param pointC Third triangle point
   */
  public Triangle(Point2D pointA, Point2D pointB, Point2D pointC) throws Exception {
    this.pointA = pointA;
    this.pointB = pointB;
    this.pointC = pointC;

    if (isCollinear()) {
      throw new Exception("Points are collinear and does not determines two-dimensional triangle");
    }
  }

  /**
   * Method to check if three points non-collinear and determines two-dimensional triangle.
   * For three points, slope of any pair of points must be same as other pair.
   * (y3 - y2)/(x3 - x2) = (y2 - y1)/(x2 - x1).
   * In other words, (y3 - y2)(x2 - x1) = (y2 - y1)(x3 - x2)
   * Returns "True" when three points is collinear.
   */
  private boolean isCollinear() {
    return (pointC.getY() - pointB.getY()) * (pointB.getX() - pointA.getX())
                   == (pointB.getY() - pointA.getY()) * (pointC.getX() - pointB.getX());
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
   * Returns a string representation of this triangle and its location in the (x,y) coordinate
   * space.
   */
  @Override
  public String toString() {
    return getClass().getName()
                   + "["
                   + "a(" + this.pointA.getX() + "; " + this.pointA.getY() + "), "
                   + "b(" + this.pointB.getX() + "; " + this.pointB.getY() + "), "
                   + "c(" + this.pointC.getX() + "; " + this.pointC.getY() + ")"
                   + "]";
  }
}
