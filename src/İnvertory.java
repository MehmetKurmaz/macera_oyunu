public class İnvertory {
    private static String name;
    private static String type;
    private static int damage;
    private static int price;

    public static int getPrice() {
        return price;
    }

    public static void setPrice(int price) {
        İnvertory.price = price;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        İnvertory.name = name;
    }

    public static String getType() {
        return type;
    }

    public static void setType(String type) {
        İnvertory.type = type;
    }

    public static int getDamage() {
        return damage;
    }

    public static void setDamage(int damage) {
        İnvertory.damage = damage;
    }

    İnvertory(String name, String type, int damage,int price) {
        İnvertory.name=name;
        İnvertory.type=type;
        İnvertory.damage=damage;
        İnvertory.price=price;
    }



    private static String lowArmor="1.Seviye Yelek";
    private static int lowArmorPrice=45;
    private static int protectionLowArmor=2;
    private static String middleArmor="2.Seviye Yelek";
    private static int middleArmorPrice=60;
    private static int protectionMiddleArmor=4;
    private static String highArmor="3.Seviye Yelek";
    private static int highArmorPrice=75;

    public static void setLowArmor(String lowArmor) {
        İnvertory.lowArmor = lowArmor;
    }

    public static int getLowArmorPrice() {
        return lowArmorPrice;
    }

    public static void setLowArmorPrice(int lowArmorPrice) {
        İnvertory.lowArmorPrice = lowArmorPrice;
    }

    public static void setProtectionLowArmor(int protectionLowArmor) {
        İnvertory.protectionLowArmor = protectionLowArmor;
    }

    public static void setMiddleArmor(String middleArmor) {
        İnvertory.middleArmor = middleArmor;
    }

    public static int getMiddleArmorPrice() {
        return middleArmorPrice;
    }

    public static void setMiddleArmorPrice(int middleArmorPrice) {
        İnvertory.middleArmorPrice = middleArmorPrice;
    }

    public static void setProtectionMiddleArmor(int protectionMiddleArmor) {
        İnvertory.protectionMiddleArmor = protectionMiddleArmor;
    }

    public static void setHighArmor(String highArmor) {
        İnvertory.highArmor = highArmor;
    }

    public static int getHighArmorPrice() {
        return highArmorPrice;
    }

    public static void setHighArmorPrice(int highArmorPrice) {
        İnvertory.highArmorPrice = highArmorPrice;
    }

    public static void setProtectionHighArmor(int protectionHighArmor) {
        İnvertory.protectionHighArmor = protectionHighArmor;
    }

    private static int protectionHighArmor=6;

    public static String getLowArmor() {
        return lowArmor;
    }

    public static int getProtectionLowArmor() {
        return protectionLowArmor;
    }

    public static String getMiddleArmor() {
        return middleArmor;
    }

    public static int getProtectionMiddleArmor() {
        return protectionMiddleArmor;
    }

    public static String getHighArmor() {
        return highArmor;
    }

    public static int getProtectionHighArmor() {
        return protectionHighArmor;
    }
}
