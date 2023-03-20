public class RefMethod {

  public static double getSum(double[] array) {
    double sum = 0.0;
    for (int i = 0; i < array.length; i++) {
      sum += array[i];
    }

    return sum;
  }

  public static double getAverage(double[] array) {
    double sum = 0.0;
    for (int i = 0; i < array.length; i++) {
      sum += array[i];
    }

    return (sum / array.length);
  }

  public static int getValueOfLastElement(int[] array) {
    return array[array.length - 1];
  }

  public static int getMinValue(int[] array) {
    int currentMinValue = array[0];
    for (int val : array) {
      if (currentMinValue > val) {
        currentMinValue = val;
      }
    }

    return currentMinValue;
  }

  public static int getMaxValue(int[] array) {
    int currentMaxValue = array[0];
    for (int val : array) {
      if (currentMaxValue < val) {
        currentMaxValue = val;
      }
    }

    return currentMaxValue;
  }

  public static int[] getMinMaxValue(int[] array) {
    int[] minMax = { getMinValue(array), getMaxValue(array) };

    return minMax;
  }

  public static String getLongestString(String[] array) {
    String longestString = "";
    int longestIndex = 0;

    for (int i = 0; i < array.length; i++) {
      if (array[i].length() > longestString.length()) {
        longestString = array[i];
        longestIndex = i;
      } else if (
        array[i].length() == longestString.length() && i > longestIndex
      ) {
        longestString = array[i];
        longestIndex = i;
      }
    }
    return longestString;
  }

  public static int[] getInversedArray(int[] array) {
    int[] reversedArray = array;

    int left = 0;
    int right = reversedArray.length - 1;
    while (left < right) {
      int temp = reversedArray[left];
      reversedArray[left] = reversedArray[right];
      reversedArray[right] = temp;
      left++;
      right--;
    }

    return reversedArray;
  }

  public static void main(String[] args) {
    //inisialisasi sejumlah Array untuk testing
    double[] arrayOfDouble = { 2.3, 4.5, 6.7, 8.9, 10.1 };
    int[] arrayOfInt = { 17, 81, 24, 23, 81, 90, 65, 69, 44, 31, 32 };
    String[] arrayOfString = {
      "Sardjito",
      "Kardono",
      "Herman Yohanes",
      "Wreksodiningrat",
      "Darmo",
    };

    //#1. Pemanggilan getSum()
    System.out.println("Jumlah dari arrayOfDouble:" + getSum(arrayOfDouble));

    //#2. Pemanggilan getAverage()
    System.out.println(
      "Rerata dari arrayOfDouble: " + getAverage(arrayOfDouble)
    );

    //#3. Pemanggilan getValueOfLastElement()
    System.out.println(
      "Elemen terakhir dari arrayOfInt: " + getValueOfLastElement(arrayOfInt)
    );

    //#4. Pemanggilan getMinValue()
    System.out.println(
      "Elemen terkecil dari arrayOfInt: " + getMinValue(arrayOfInt)
    );

    //#5. Pemanggilan getMaxValue()
    System.out.println(
      "Elemen terbesar dari arrayOfInt: " + getMaxValue(arrayOfInt)
    );

    //#6. Pemanggilan getMinMaxValue()
    System.out.println(
      "Elemen terkecil dan terbesar dari arrayOfInt: " +
      getMinMaxValue(arrayOfInt)[0] + " - " + 
      getMinMaxValue(arrayOfInt)[1]
    );

    //#7. Pemanggilan getLongestString()
    System.out.println(
      "Elemen String terpanjang dari arrayOfString: " +
      getLongestString(arrayOfString)
    );

    //#8. Pemanggilan getInversedArray()
    System.out.println(
      "Reversed array dari arrayOfInt:"
    );
    System.out.print("[");
    for(int val : getInversedArray(arrayOfInt)){
      System.out.print(val + " ");
    }
    System.out.print("]");
  }
}
