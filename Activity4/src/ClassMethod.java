public class ClassMethod {

  public static void printStudentInfo(Student s) {
    System.out.println("Nama siswa: " + s.name);
    System.out.println("Umur siswa: " + s.age);
  }

  public static Boolean isSameAge(Student s0, Student s1) {
    return s0.age == s1.age;
  }

  public static Student getYoungestStudent(Student[] students) {
    Student currentYoungestStudent = students[0];

    for (Student student : students) {
      if (student.age < currentYoungestStudent.age) {
        currentYoungestStudent = student;
      }
    }

    return currentYoungestStudent;
  }

  public static double getRectangleArea(Rectangle r) {
    return r.height * r.width;
  }

  public static Rectangle getSquare(double d) {
    return new Rectangle(d, d);
  }

  public static void main(String[] args) {
    //inisialisasi beberapa variabel untuk testing
    Student student1 = new Student("Ahmad Siddiq Priaji", 19);
    Student student2 = new Student("Muhammad Hariish Hafiiz", 18);
    Student[] students = {
      //generate 10 student secara random
      new Student("Ahmad Siddiq Priaji", 19),
      new Student("Muhammad Hariish Hafiiz", 18),
      new Student("Afif Naufal Taufiqi", 18),
      new Student("Adila Rahma Widja", 18),
      new Student("Maria Clareta Febriani", 18),
      new Student("Maritza Zahra Setiawan", 17),
    };
    Rectangle rect1 = new Rectangle(4, 5);

    //#1. printStudentInfo
    System.out.println("Print student info dari student1:");
    printStudentInfo(student1);

    //#2. isSameAge
    System.out.println(
      "Apakah umur student1 dan student2 sama? " + isSameAge(student1, student2)
    );

    //#3. getYoungestStudent
    System.out.println("Student termuda dari daftar students[] adalah:");
    printStudentInfo(getYoungestStudent(students));

    //#4. getRectangleArea
    System.out.println(
      "Luas dari Rectangle r adalah: " + getRectangleArea(rect1)
    );

    //#5. getSquare
    Rectangle square = getSquare(5);
    System.out.println(
      "Hasil instance Rectangle (square) dari ukuran d = 5 dalam bentuk reference adalah: " +
      square
    );
    System.out.println(
      "Luas dari instance Rectangle (square) dari ukuran 5 adalah: " +
      square.getArea()
    );
  }
}
