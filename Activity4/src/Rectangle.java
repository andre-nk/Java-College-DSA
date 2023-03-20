public class Rectangle {
  double width;
  double height;

  //constructor
  public Rectangle(double width, double height) {
    this.width = width;
    this.height = height;
  }

  public double getArea() {
    return this.width * this.height;
  }

  public Boolean isLarger(Rectangle rectB) {
    if ((this.width * this.height) > (rectB.width * rectB.height)) {
      return true;
    } else {
      return false;
    }
  }
}

