import java.util.Random;

public class Monsters {
    private static String name;
    private static int damage;
    private static int health;
    private static int numberMonster;
    private static int prize;

    public Monsters(String name,int damage,int health,int prize) {
        Monsters.name=name;
        Monsters.damage=damage;
        Monsters.health=health;
        Monsters.prize=prize;
    }

    public static int getNumberMonster() {return numberMonster;}

    public static void setNumberMonster(int numberMonster) {Monsters.numberMonster = numberMonster;}

    public static int getPrize() {return prize;}

    public static void setPrize(int prize) {Monsters.prize = prize;}

    public static int getHealth() {
        return health;
    }

    public static String getName() {
        return name;
    }
    public static int getDamage() {
        return damage;
    }

    public static void setName(String name) {
        Monsters.name = name;
    }

    public static void setDamage(int damage) {
        Monsters.damage = damage;
    }
    public static void setHealth(int health) {
        Monsters.health = health;
    }

    public static void increase() {
        Random random = new Random();
        int select = random.nextInt(1,4);
        for (int i = 1; i <= select; i++) {
            numberMonster=i;


        }


    }
}