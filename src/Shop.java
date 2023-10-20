import java.util.Scanner;

public class Shop {

    public static void buyGun(){
            Gun gun = new Gun();
        if (Players.getMoney()>=Gun.getPrice()) {
            System.out.println(Gun.getName() + " Satin Alindi...");
            Players.setMoney(Players.getMoney() - Gun.getPrice());
            Players.gun = true;
            System.out.println(Players.getName() + " Kalan Altin :" + Players.getMoney());

        }else System.out.println("Yetersiz Bakiye..");
    }
    public static void buyRifle(){
        Rifle rifle=new Rifle();
        if (Players.getMoney()>=Rifle.getPrice()) {
            System.out.println(Rifle.getName() + " Satin Alindi...");
            Players.setMoney(Players.getMoney() - Rifle.getPrice());
            Players.rifle=true;
            System.out.println(Players.getName() + " Kalan Altin :" + Players.getMoney());
        }else System.out.println("Yetersiz Bakiye..");
    }
    public static void buyMachineliGun(){
        MachineGun machineGun=new MachineGun();
        if (Players.getMoney()>=MachineGun.getPrice()) {
            System.out.println(MachineGun.getName() + " Satin Alindi...");
            Players.machineGun=true;
            Players.setMoney(Players.getMoney() - MachineGun.getPrice());
            System.out.println(Players.getName() + " Kalan Altin :" + Players.getMoney());
        }else System.out.println("Yetersiz Bakiye..");
    }
    public static void buyLowArmor(){
        if (Players.getMoney()>=İnvertory.getLowArmorPrice()) {
            System.out.println(İnvertory.getLowArmor() + " Satin Alindi...");
            Players.lowArmor=true;
            Players.setMoney(Players.getMoney() - İnvertory.getLowArmorPrice());
            System.out.println(Players.getName() + " Kalan Altin :" + Players.getMoney());
        }else System.out.println("Yetersiz Bakiye..");
    }
    public static void buyMiddleArmor(){
        if (Players.getMoney()>=İnvertory.getMiddleArmorPrice()) {
            System.out.println(İnvertory.getMiddleArmor() + " Satin Alindi...");
            Players.middleArmor=true;
            Players.setMoney(Players.getMoney() - İnvertory.getMiddleArmorPrice());
            System.out.println(Players.getName() + " Kalan Altin :" + Players.getMoney());
        }else System.out.println("Yetersiz Bakiye..");
    }
    public static void buyHighArmor(){
        if (Players.getMoney()>=İnvertory.getHighArmorPrice()) {
            System.out.println(İnvertory.getHighArmor() + " Satin Alindi...");
            Players.highArmor=true;
            Players.setMoney(Players.getMoney() - İnvertory.getHighArmorPrice());
            System.out.println(Players.getName() + " Kalan Altin :" + Players.getMoney());
        }else System.out.println("Yetersiz Bakiye..");
    }
    public static void entrance() {

        System.out.println(Players.getName() + " Magazaya Hos Geldiniz...\nHangi Reyona Bakmak istersiniz?\n1-Silahlar\n2-Koruma Yelekleri");
        Scanner input = new Scanner(System.in);
        int select = input.nextInt();
        switch (select) {
                case 1:
                    Gun gun = new Gun();
                    System.out.println("1-Silah :" + Gun.getName() + " - Silahin Tipi :" + Gun.getType() + " - Silahin Verdigi Hasar :" + Gun.getDamage() + " - Fiyati :" + Gun.getPrice());
                    Rifle rifle = new Rifle();
                    System.out.println("2-Silah :" + Rifle.getName() + " - Silah Tipi :" + Rifle.getType() + " - Silahin Verdigi Hasar :" + Rifle.getDamage() + " - Fiyati :" + Rifle.getPrice());
                    MachineGun machineGun = new MachineGun();
                    System.out.println("3-Silah :" + MachineGun.getName() + " - Silahin Tipi :" + MachineGun.getType() + " - Silahin Verdigi Hasar :" + MachineGun.getDamage() + " - Fiyati :" + MachineGun.getPrice());
                    System.out.println("Almak istediginiz Silahi Seciniz :");
                    select=input.nextInt();
                    switch (select){
                        case 1:buyGun();break;
                        case 2:buyRifle();break;
                        case 3:buyMachineliGun();break;
                    }
                    break;
                    case 2:
                    System.out.println("1-A tipi Yelek :" + İnvertory.getLowArmor() + "Koruyuculuk Orani :" + İnvertory.getProtectionLowArmor() + "Fiyati :" + İnvertory.getLowArmorPrice());
                    System.out.println("2-B tipi Yelek :" + İnvertory.getMiddleArmor() + "Koruyuculuk Orani :" + İnvertory.getProtectionMiddleArmor() + "Fiyati :" + İnvertory.getMiddleArmorPrice());
                    System.out.println("3-C tipi Yelek :" + İnvertory.getHighArmor() + "Koruyucuk Orani :" + İnvertory.getProtectionHighArmor() + "Fiyati :" + İnvertory.getHighArmorPrice());
                    System.out.println("Almak istediginiz Yelegi Seciniz :");
                    input.nextInt();
                    switch (select){
                        case 1 :


                    }
                    break;
        }



    }



}

