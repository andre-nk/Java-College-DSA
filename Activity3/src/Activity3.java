public class Activity3 {

  //1. Random number 1 - 100
  private static int getRandomNumber() {
    return (int) (Math.random() * 100);
  }

  //2. Absolute value tanpa Math.abs()
  private static double getAbsoluteValue(double value) {
    double absNum;

    if (value < 0) {
      absNum = -value;
    } else {
      absNum = value;
    }

    return absNum;
  }

  //3. Faktorial
  private static int getFactorial(int n) {
    int result = 1;
    for (int i = 1; i <= n; i++) {
      result *= i;
    }
    return result;
  }

  //4. Print Cuaca secara Random
  private static String getWeatherForecast() {
    String[] time = { "Today", "Tomorrow", "The day after tomorrow" };
    String[] weather = { "Sunny", "Cloudy", "Rainy", "Snowy" };
    return (
      time[(int) (Math.random() * time.length)] +
      " is " +
      weather[(int) (Math.random() * weather.length)]
    );
  }

  //5. Print Salam secara Random dan menerima Nama
  private static String getRandomMessage(String name) {
    String[] time = { "Good morning", "Good afternoon", "Good evening" };
    return time[(int) (Math.random() * time.length)] + " " + name;
  }

  //6. Cek Bilangan Genap
  private static Boolean isEvenNumber(int value) {
    return value % 2 == 0;
  }

  //7. Cek Nilai Terkecil dengan Math.min
  private static double getMinValue(double a, double b) {
    if (a < b) {
      return a;
    }

    return b;
  }

  //8. Cek Nilai Absolute sama dari Dua Variabel
  private static Boolean isSameAbsoluteValue(int i, int j) {
    if (i == -j || i == j) {
      return true;
    } else {
      return false;
    }
  }

  //9. Print Salam dengan Parameter apakah Anak-anak
  private static void getMessage(String name, Boolean isKid) {
    if (isKid) {
      System.out.println("Halo Dek " + name);
    } else {
      System.out.println("Halo Pak " + name);
    }
  }

  //10. Return Total dari 3 Bilangan
  private static double getSum(double a, double b, double c) {
    return a + b + c;
  }

  //11. Return Rata-rata dari 3 Bilangan
  private static double getAverage(double a, double b, double c) {
    return ((a + b + c) / 3);
  }

  public static void main(String[] args) throws Exception {
    //1. Random number 1 - 100
    System.out.println("Random number (1-100): " + getRandomNumber());

    //2. Absolute value dengan Math
    System.out.println(
      "Nilai absolut dari (-5.55): " + getAbsoluteValue(-5.55)
    );

    //3. Faktorial
    System.out.println(getFactorial(7));

    //4. Cuaca
    System.out.println("Prakiraan cuaca dengan acak:");
    System.out.println(getWeatherForecast());

    //5. Salam
    System.out.println("Print salam dengan nama `Andreas`");
    System.out.println(getRandomMessage("Andreas"));

    //6. Cek Bilangan Genap
    System.out.println("Cek bilangan genap (input: 7)");
    System.out.println(isEvenNumber(7));

    //7. Cek Nilai Terkecil dengan Math.min
    System.out.println("Nilai terkecil (5.5 dan 6.6):");
    System.out.println(getMinValue(5.5, 6.6));

    //8. Cek Nilai Absolute sama dari Dua Variabel
    System.out.println("Cek apakah kedua nilai sama dalam mutlak (-5 dan 5):");
    System.out.println(isSameAbsoluteValue(-5, 5));

      //9. Print Salam dengan Parameter apakah Anak-anak
    System.out.println("Salam dengan parameter anak-anak (false):");
    getMessage("Milzam", false);

    //10. Return Total dari 3 Bilangan
    System.out.println("Jumlahan tiga bilangan acak (dg. getRandomNumber())");
    System.out.println(
      getSum(getRandomNumber(), getRandomNumber(), getRandomNumber())
    );

    //   //11. Return Rata-rata dari 3 Bilangan
    System.out.println("Rerata tiga bilangan acak (dg. getRandomNumber())");
    System.out.println(
      getAverage(getRandomNumber(), getRandomNumber(), getRandomNumber())
    );
  }
}
