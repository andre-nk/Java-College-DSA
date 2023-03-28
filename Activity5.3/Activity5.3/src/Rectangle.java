public class Rectangle {
  //deklarasi fields
  double width;
  double height;
  double x0;
  double y0;

  //deklarasi constructor dengan parameter width dan height
  public Rectangle(double width, double height) {
    this.width = width;
    this.height = height;
  }

  //deklarasi overload constructor dengan parameter size
  public Rectangle(double size) {
    this.width = size;
    this.height = size;
  }

  //deklarasi method getArea
  public double getArea() {
    return this.width * this.height;
  }

  //deklarasi method isLargerThan
  public boolean isLargerThan(Rectangle r) {
    return this.getArea() > r.getArea();
  }

  //deklarasi method isIntersectingWith
  public boolean isIntersectingWith(Rectangle r) {
    //deklarasi variabel koordinat 4 sudut dari r1
    double left1 = this.x0;
    double right1 = this.x0 + this.width;
    double top1 = this.y0;
    double bottom1 = this.y0 + this.height;

    //deklarasi variabel koordinat 4 sudut dari r2
    double left2 = r.x0;
    double right2 = r.x0 + r.width;
    double top2 = r.y0;
    double bottom2 = r.y0 + r.height;

    return !(
      left1 >= right2 || right1 <= left2 || top1 >= bottom2 || bottom1 <= top2
    );
  }
}
