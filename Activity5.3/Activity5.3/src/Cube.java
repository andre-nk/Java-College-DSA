public class Cube extends Rectangle {
  //deklarasi fields tambahan: length (lebar)
  double length;

  //modifikasi constructor
  public Cube(double height, double width, double length) {
    super(width, height);
    this.length = length;
  }

  //modifikasi constructor dengan parameter size
  public Cube(double size) {
    super(size);
    this.length = size;
  }

  //modifikasi method getArea
  public double getArea() {
    return (
      2 *
      (
        (this.length * this.width) +
        (this.width * this.height) +
        (this.height * this.length)
      )
    );
  }

  //modifikasi method getVolume
  public double getVolume() {
    return this.height * this.width * this.height;
  }

  //modifikasi method isLargerThan
  public boolean isLargerThan(Cube c) {
    return this.getVolume() > c.getVolume();
  }

  //modifikasi method isIntersectingWith
  public boolean isIntersectingWith(Cube c) {
    //deklarasi variabel koordinat 3 dimensi dari c1
    double x1 = this.x0;
    double y1 = this.y0;
    double z1 = this.length;

    //deklarasi variabel koordinat 3 dimensi dari c2
    double x2 = c.x0;
    double y2 = c.y0;
    double z2 = c.length;

    if (x1 + this.width < x2 || x2 + c.width < x1) {
      return false;
    }

    if (y1 + this.height < y2 || y2 + c.height < y1) {
      return false;
    }

    if (z1 + this.length < z2 || z2 + c.length < z1) {
      return false;
    }

    return true;
  }
}
