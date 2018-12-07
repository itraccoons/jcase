package org.raccoons.backyards;

public abstract class Point {
  // The x, y coordinates
  public double coordinateX;
  public double coordinateY;

  public Point() {
    this(0,0);
  }

  /** Constructs and initializes a point at the (x,y) coordinate space. */
  public Point(double x, double y) {
    this.coordinateX = x;
    this.coordinateY = y;
  }

  /** Constructs and initializes a point at the (x,y,z) coordinate space. */
  public Point(double x, double y, double z) {
    this.coordinateX = x;
    this.coordinateY = y;
    // this.coordinateZ = z;
  }

  public void setX(double x) {
    this.coordinateX = x;
  }

  public void setY(double y) {
    this.coordinateY = y;
  }

  public double getX() {
    return this.coordinateX;
  }

  public double getY() {
    return this.coordinateY;
  }

  public abstract void setLocation(double... coordinates);

  // public abstract void setLocation(Point p);
}
