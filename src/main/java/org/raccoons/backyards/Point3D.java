package org.raccoons.backyards;

public class Point3D extends Point  {

  public Point3D() {
    this(0,0,0);
  }

  public Point3D(double x, double y, double z) {
    super(x, y, z);
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

  @Override
  public void setLocation(Point point) {
    if (point instanceof Point3D) {
      setLocation(point.coordinateX, point.coordinateY, point.coordinateZ);
    } else {
      throw new IllegalArgumentException("XXX");
    }
  }

  @Override
  public String toString() {
    return getClass().getSimpleName()
                   + "("
                   + this.coordinateX + "; " + this.coordinateY + "; " + this.coordinateZ
                   + ")";
  }
}
