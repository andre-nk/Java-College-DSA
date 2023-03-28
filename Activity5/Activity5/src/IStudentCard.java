public class IStudentCard extends StudentCard {
  String nationality; //add nationality field

  void printInfo(){
    System.out.println(this.id);
    System.out.println(this.name);
    System.out.println(this.nationality);
  }
}
