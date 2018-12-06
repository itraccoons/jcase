package org.raccoons.backyards;

import javax.annotation.Nullable;

public class Triangle {
  /*
   * Three vertices/points/tops of triangle
   */
  private Point2D vertexA;
  private Point2D vertexB;
  private Point2D vertexC;

  /**
   * Constructs and initializes a triangle at the vertices origin a(0; 0), b(0; 1), c(1;0)
   * of the coordinate space.
   */
  public Triangle() {
    this(new Point2D(0,0), new Point2D(0,1), new Point2D(1,0));
  }

  /**
   * Constructs and initializes a triangle with the location as the specified three Point2D
   * vertices.
   *
   * @param pointA - First triangle vertex
   * @param pointB - Second triangle vertex
   * @param pointC - Third triangle vertex
   */
  public Triangle(Point2D pointA, Point2D pointB, Point2D pointC) {
    this.vertexA = pointA;
    this.vertexB = pointB;
    this.vertexC = pointC;
  }

  /**
   * Method to check if three points non-collinear and determines two-dimensional triangle.
   * For three points, slope of any pair of points must be same as other pair.
   * (y3 - y2)/(x3 - x2) = (y2 - y1)/(x2 - x1).
   * In other words, (y3 - y2)(x2 - x1) = (y2 - y1)(x3 - x2)
   * Returns "True" when three vertices is non-collinear.
   */
  private boolean isNonCollinear() {
    return (vertexC.getY() - vertexB.getY()) * (vertexB.getX() - vertexA.getX())
                   != (vertexB.getY() - vertexA.getY()) * (vertexC.getX() - vertexB.getX());
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  /**
   * Determines whether or not two triangles are equal.
   *
   * @param  obj an object to be compared with this Triangle
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
      return this.vertexA.equals(t.vertexA)
                     && this.vertexB.equals(t.vertexB)
                     && this.vertexC.equals(t.vertexC);
    }
    return false;
  }

  /**
   * Returns a string representation of this triangle and its location in the (x,y)coordinate
   * space.
   */
  @Override
  public String toString() {
    return getClass().getName()
                   + "["
                   + "a(" + this.vertexA.getX() + "; " + this.vertexA.getY() + "), "
                   + "b(" + this.vertexB.getX() + "; " + this.vertexB.getY() + "), "
                   + "c(" + this.vertexC.getX() + "; " + this.vertexC.getY() + ")"
                   + "]";
  }
}
