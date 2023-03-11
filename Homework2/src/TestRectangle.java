public class TestRectangle {
  public static void main(String args[]) {
    Rectangle[] rects = new Rectangle[10];
    Rectangle currentMaxRect = new Rectangle();
    currentMaxRect.height = 0;
    currentMaxRect.width = 0;

    Rectangle currentMinRect = new Rectangle();
    currentMinRect.height = 1;
    currentMinRect.width = 1;

    for (int i = 0; i < 10; i++) {
      rects[i] = new Rectangle();
      rects[i].width = Math.random();
      rects[i].height = Math.random();

      if (
        (currentMaxRect.height * currentMaxRect.width) <
        (rects[i].width * rects[i].height)
      ) {
        currentMaxRect = rects[i];
      }

      if (
        (currentMinRect.height * currentMinRect.width) >
        (rects[i].width * rects[i].height)
      ) {
        currentMinRect = rects[i];
      }
    }

    System.out.println("Largest Rectangle");
    System.out.println("width: " + currentMaxRect.width);
    System.out.println("height: " + currentMaxRect.height);
    System.out.println("area: " + currentMaxRect.height * currentMaxRect.width);

    System.out.println("Smallest Rectangle");
    System.out.println("width: " + currentMinRect.width);
    System.out.println("height: " + currentMinRect.height);
    System.out.println("area: " + currentMinRect.height * currentMinRect.width);
  }
}
