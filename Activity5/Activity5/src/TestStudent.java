public class TestStudent {
  public static void main(String[] args){
    System.out.println("StudentCard:");
    StudentCard sc = new StudentCard();
    sc.id = 123;
    sc.name = "John";
    sc.printInfo();
    
    System.out.println("");
    System.out.println("IStudentCard:");
    IStudentCard isc = new IStudentCard();
    isc.id = 456;
    isc.name = "Mary";
    isc.nationality = "Czech";
    isc.printInfo();
  }
}
