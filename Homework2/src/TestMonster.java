public class TestMonster {
  public static void main(String[] args) {
    //create instances of three monsters (m1,m2,m3) and initialize their fields
    Monster m1 = new Monster();
    m1.name = "Bunyip";
    m1.hp = 150;
    m1.mp = 75;
    m1.item = "Bunyip's Scale";

    Monster m2 = new Monster();
    m2.name = "Rugaru";
    m1.hp = 150;
    m1.mp = 100;
    m1.item = "Rugaru's Ear";

    Monster m3 = new Monster();
    m3.name = "Wendigo";
    m3.hp = 125;
    m3.mp = 200;
    m3.item = "Wendigo's Claw";

    //declare an array monsters with type Monster and size = 3
    Monster[] monsters = new Monster[3];

    //initialize the array with m1,m2,m3
    monsters[0] = m1;
    monsters[1] = m2;
    //monsters[2] = m3; monsters[] initialization on index 2 is cancelled

    //print all monsters in the array
    for (int i = 0; i < monsters.length; i++) {
      System.out.println(
        "A monster has appeared! " +
        monsters[i].name +
        " HP:" +
        monsters[i].hp +
        " MP:" +
        monsters[i].mp
      );
    }
  }
}
