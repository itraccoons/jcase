package org.raccoons.backyards;

import javax.annotation.Nullable;

public class Point3D extends Point {
  // The z coordinate
  private double coordinateZ;

  public Point3D() {
    this(0,0,0);
  }

  public Point3D(double x, double y, double z) {
    super(x, y, z);
    //this.coordinateX = x;
    //this.coordinateY = y;
    this.coordinateZ = z;

  }

  public void setZ(double z) {
    this.coordinateZ = z;
  }

  public double getZ() {
    return this.coordinateZ;
  }

  @Override
  public void setLocation(double... coordinates) {
    this.coordinateX = coordinates[0];
    this.coordinateY = coordinates[1];
    this.coordinateZ = coordinates[2];
  }

  public void setLocation(Point3D p) {
    setLocation(p.coordinateX, p.coordinateY, p.coordinateZ);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Point3D) {
      Point3D p = (Point3D) o;
      return this.coordinateX == p.coordinateX
                     && this.coordinateY == p.coordinateY
                     && this.coordinateZ == p.coordinateZ;
    }
    return false;
  }

  @Override
  public String toString() {
    return getClass().getSimpleName()
                   + "("
                   + this.coordinateX + "; " + this.coordinateY + "; " + this.coordinateZ
                   + ")";
  }
}
