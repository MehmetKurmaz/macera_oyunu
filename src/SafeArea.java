public class SafeArea {
    private static int id=1;
    private static String home;
    private static int emergencyAid;
    public static int getId(){return id;}

    public static int getEmergencyAid(){
        return emergencyAid;
    }
    public static void EmergencyAid(){
        for (int i=Players.getHealth();i<=100;i++){
            Players.setHealth(i);
        }

    }
}
