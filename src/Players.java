import java.util.Random;
import java.util.Scanner;

public class Players {
    private static String name;
    private static int health=0;
    private static int damage=0;
    private static int money=0;
    private static int eat=0;
    private static int wood=0;
    private static int water=0;
    public static boolean gun, rifle, machineGun, lowArmor, middleArmor, highArmor, caveStatus,riverStatus,forestStatus,coalStatus = false;
    Players(String name, int health, int damage, int money, int eat, int water, int wood, boolean caveStatus,boolean riverStatus,boolean forestStatus,boolean coalStatus, boolean gun,
            boolean rifle, boolean machineGun, boolean lowArmor, boolean middleArmor, boolean highArmor) {
        this.name=name;
        this.health=health;
        this.damage=damage;
        this.money=money;
        this.eat=eat;
        this.water=water;
        this.wood=wood;
        this.caveStatus=caveStatus;
        this.riverStatus=riverStatus;
        this.forestStatus=forestStatus;
        this.coalStatus=coalStatus;
        this.gun=gun;
        this.rifle=rifle;
        this.machineGun=machineGun;
        this.lowArmor=lowArmor;
        this.middleArmor=middleArmor;
        this.highArmor=highArmor;

    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Players.name = name;
    }

    public static int getHealth() {
        return health;
    }

    public static void setHealth(int health) {
        Players.health = health;
    }

    public static int getDamage() {
        return damage;
    }

    public static void setDamage(int damage) {
        Players.damage = damage;
    }

    public static int getMoney() {
        return money;
    }

    public static void setMoney(int money) {
        Players.money = money;
    }

    public static int getEat() {
        return eat;
    }

    public static void setEat(int eat) {
        Players.eat = eat;
    }

    public static int getWood() {
        return wood;
    }

    public static void setWood(int wood) {
        Players.wood = wood;
    }

    public static int getWater() {
        return water;
    }

    public static void setWater(int water) {
        Players.water = water;
    }

    public static void homeComing() {

        System.out.println("Eve Yonlendiriliyorsunuz..\nEvinize ulastiniz artik Guvendesiniz..\nCan Basiliyor...");
        SafeArea.EmergencyAid();
        System.out.println("Caniniz Yenilendi :" +health);
    }
    public static void caveWar() {
        if (caveStatus){
            System.out.println("Lakosyon Tamamlandigi icin Tekrar Giris Yapilamiyor...");
        }

        while (!caveStatus) {
            Vampires vampires = new Vampires();
            System.out.println("Magara'da Mucadeleye Hazir Olun...");
            Monsters.increase();
            System.out.println("Dusman Sayisi :" + Monsters.getNumberMonster() + "\n" + "Ganimet :" + Cave.getLoot() + "\n Mucadele Basliyor...");
            Random random = new Random();
            while (Monsters.getNumberMonster() != 0 && health > 0&&!caveStatus&&!riverStatus&&!forestStatus&&!coalStatus) {
                int secim = random.nextInt(2);
                switch (secim) {
                    case 0:
                        if (gun ||rifle ||machineGun) {
                            System.out.println(name+ " Ates Etti");
                            Monsters.setHealth(Monsters.getHealth() - İnvertory.getDamage());
                            if (Monsters.getHealth() > 0) {
                                System.out.println(Monsters.getName() + " Kalan Cani :" + Monsters.getHealth());
                            } else {
                                Monsters.setHealth(0);
                                Monsters.setNumberMonster(Monsters.getNumberMonster() - 1);
                                System.out.println(Monsters.getName() + " Hakladiniz..\nKalan " + Monsters.getName() + " sayisi : " + Monsters.getNumberMonster());
                                money+=Monsters.getPrize();
                                Monsters.setHealth(14);
                                if (Monsters.getNumberMonster() == 0) {
                                    System.out.println("Magara " + Monsters.getName() + " 'lerden Temizlendi...\nElde edilen Ganimet :" + Cave.getLoot());
                                    eat+=1;
                                    caveStatus = true;
                                    System.out.println("Savasciniz :" +name + "\nSavascinizin Saglik Durumu :" +health + "\nSavascinizin Kuvveti :" +damage+ "\nAltin Mikrari :" +money + "\nLoot'unuz :\nYemek :" + eat + "\nSu :" +water + "\nOdun :" +wood);
                                    if (health<15){
                                        System.out.println("Caniniz Azaliyor...\t\tEve Gitmek ister misiniz ?");
                                        Scanner input=new Scanner(System.in);
                                        GameMeneger.select=input.nextInt();
                                        switch (GameMeneger.select){
                                            case 1:
                                                homeComing();
                                                break;
                                            case 2:continue;

                                        }
                                    }
                                    if (caveStatus&&riverStatus&&forestStatus&&coalStatus){
                                        System.out.println("Tebrikler Tum Lokasyonlar Basari ile Tamamlandi..");
                                        break;
                                    }
                                    System.out.println("Bi Sonraki Bolumu Seciniz :\n1-Nehir\n2-Orman\n3-Maden");
                                    Scanner input = new Scanner(System.in);
                                    GameMeneger.select = input.nextInt();
                                    switch (GameMeneger.select) {
                                        case 1:
                                            riverWar();
                                            break;
                                        case 2:
                                            forestWar();
                                            break;
                                        case 3:
                                            coalWar();
                                            break;
                                    }

                                }
                            }

                        } else {
                            System.out.println(name+ " Darbe Vurdu..");
                            Monsters.setHealth(Monsters.getHealth() -damage);
                            if (Monsters.getHealth() > 0) {
                                System.out.println(Monsters.getName() + " Kalan Cani :" + Monsters.getHealth());
                            } else {
                                Monsters.setHealth(0);
                                Monsters.setNumberMonster(Monsters.getNumberMonster() - 1);
                                System.out.println(Monsters.getName() + " Hakladiniz..\nKalan " + Monsters.getName() + " sayisi : " + Monsters.getNumberMonster());
                                money+=Monsters.getPrize();
                                Monsters.setHealth(14);
                                if (Monsters.getNumberMonster() == 0) {
                                    System.out.println("Magara " + Monsters.getName() + " 'lerden Temizlendi...\nElde edilen Ganimet :" + Cave.getLoot());
                                    eat+=1;
                                    caveStatus = true;
                                    System.out.println("Savasciniz :" +name + "\nSavascinizin Saglik Durumu :" +health + "\nSavascinizin Kuvveti :" +damage+ "\nAltin Mikrari :" +money + "\nLoot'unuz :\nYemek :" + eat + "\nSu :" +water + "\nOdun :" +wood);
                                    if (health<15){
                                        System.out.println("Caniniz Azaliyor...\t\tEve Gitmek ister misiniz ?");
                                        Scanner input=new Scanner(System.in);
                                        GameMeneger.select=input.nextInt();
                                        switch (GameMeneger.select){
                                            case 1:
                                               homeComing();
                                               break;
                                            case 2:continue;

                                        }
                                    }
                                    if (caveStatus&&riverStatus&&forestStatus&&coalStatus){
                                        System.out.println("Tebrikler Tum Lokasyonlar Basari ile Tamamlandi..");
                                        break;
                                    }
                                    System.out.println("Bi Sonraki Bolumu Seciniz :\n1-Nehir\n2-Orman\n3-Maden");
                                    Scanner input = new Scanner(System.in);
                                    GameMeneger.select = input.nextInt();
                                    switch (GameMeneger.select) {

                                        case 1:
                                            riverWar();
                                            break;
                                        case 2:
                                            forestWar();
                                            break;
                                        case 3:
                                            coalWar();
                                            break;
                                    }

                            }

                            }


                        }
                    break;

                    case 1:
                        if (!lowArmor||!middleArmor||!highArmor){
                            System.out.println(Monsters.getName()+" Darbe Vurdu..");
                            health=health-Monsters.getDamage();

                            if (health>0){
                                System.out.println(name+" Kalan Cani :"+health);

                            }else {
                                health=0;
                                System.out.println(name+" Kalan Cani :"+health);
                                if (health==0){
                                    System.out.println("Oyunu Kaybettiniz...");

                                }
                            }
                        }
                        if (lowArmor) {
                            System.out.println(Monsters.getName() + " Darbe Vurdu..");
                            Monsters.setDamage(Monsters.getDamage() - İnvertory.getProtectionLowArmor());
                            health =- Monsters.getDamage();

                            if (health>0){
                                System.out.println(name + " Kalan Cani :" + health);
                            }else {
                                health=0;
                                System.out.println(name+"Kalan Cani :"+health+"\nOyunu Kaybettiniz..");
                            }
                        }
                        if (middleArmor) {
                            System.out.println(Monsters.getName() + " Darbe Vurdu..");
                            Monsters.setDamage(Monsters.getDamage() - İnvertory.getProtectionMiddleArmor());
                            health =- Monsters.getDamage();
                            System.out.println(name+ " Kalan Cani :" +health);
                            if (health>0){
                                System.out.println(name + " Kalan Cani :" + health);
                            }else {
                                health=0;
                                System.out.println(name+"Kalan Cani :"+health+"\nOyunu Kaybettiniz..");
                            }

                        }
                        if (highArmor) {
                            Monsters.setDamage(Monsters.getDamage() - İnvertory.getProtectionHighArmor());
                            health =- Monsters.getDamage();
                            System.out.print(name + " Kalan Cani :" + health);
                            if (health>0){
                                System.out.println(name + " Kalan Cani :" + health);
                            }else {
                                health=0;
                                System.out.println(name+"Kalan Cani :"+health+"\nOyunu Kaybettiniz..");
                            }
                        }
                    break;
                }

            }


        }

    }






    public static void riverWar() {
        if (riverStatus){
            System.out.println("Lakosyon Tamamlandigi icin Tekrar Giris Yapilamiyor...");
        }
       while (!riverStatus) {
           Zombies zombies = new Zombies();
           System.out.println("Nehir'de Mucadeleye Hazir Olun...");
           Monsters.increase();
           System.out.println("Dusman Sayisi :" + Monsters.getNumberMonster() + "\n" + "Ganimet :" + River.getLoot() + "\n Mucadele Basliyor...");
           Random random = new Random();
           while (Monsters.getNumberMonster() != 0 &&health > 0) {
               int secim = random.nextInt(2);
               switch (secim) {
                   case 0:
                       if (gun||rifle||machineGun){
                           System.out.println(name+" Ates Etti");
                           Monsters.setHealth(Monsters.getHealth()-İnvertory.getDamage());
                           if (Monsters.getHealth()>0){
                               System.out.println(Monsters.getName()+" Kalan Cani :"+Monsters.getHealth());
                           }else {
                               Monsters.setHealth(0);
                               System.out.println(Monsters.getName()+" Kalan Cani :"+Monsters.getHealth());
                               Monsters.setNumberMonster(Monsters.getNumberMonster() - 1);
                               System.out.println(Monsters.getName() + " Hakladiniz..\nKalan " + Monsters.getName() + " sayisi : " + Monsters.getNumberMonster());
                               money+=Monsters.getPrize();
                               Monsters.setHealth(10);
                               if (Monsters.getNumberMonster() == 0) {
                                   System.out.println("Nehir " + Monsters.getName() + " 'lerden Temizlendi...\nElde edilen Ganimet :" + River.getLoot());
                                   eat+=1;
                                   riverStatus = true;
                                   System.out.println("Savasciniz :" +name + "\nSavascinizin Saglik Durumu :" +health + "\nSavascinizin Kuvveti :" +damage+ "\nAltin Mikrari :" +money + "\nLoot'unuz :\nYemek :" + eat + "\nSu :" +water + "\nOdun :" +wood);
                                   if (health<15){
                                       System.out.println("Caniniz Azaliyor...\t\tEve Gitmek ister misiniz ?");
                                       Scanner input=new Scanner(System.in);
                                       GameMeneger.select=input.nextInt();
                                       switch (GameMeneger.select){
                                           case 1:
                                               homeComing();
                                               break;
                                           case 2:continue;

                                       }
                                   }
                                   if (caveStatus&&riverStatus&&forestStatus&&coalStatus){
                                       System.out.println("Tebrikler Tum Lokasyonlar Basari ile Tamamlandi..");
                                       break;
                                   }
                                   System.out.println("Bi Sonraki Bolumu Seciniz :\n1-Magara\n2-Orman\n3-Maden");
                                   Scanner input = new Scanner(System.in);
                                   GameMeneger.select = input.nextInt();
                                   switch (GameMeneger.select) {
                                       case 1:
                                           caveWar();
                                           break;
                                       case 2:
                                           forestWar();
                                           break;
                                       case 3:
                                           coalWar();
                                           break;
                                   }

                               }
                           }

                       }else {
                           System.out.println(name+" Darbe Vurdu..");
                           Monsters.setHealth(Monsters.getHealth()-damage);
                           if (Monsters.getHealth() > 0) {
                               System.out.println(Monsters.getName() + " Kalan Cani :" + Monsters.getHealth());
                           } else {
                               Monsters.setHealth(0);
                               Monsters.setNumberMonster(Monsters.getNumberMonster() - 1);
                               System.out.println(Monsters.getName() + " Hakladiniz..\nKalan " + Monsters.getName() + " sayisi : " + Monsters.getNumberMonster());
                               money += Monsters.getPrize();
                               Monsters.setHealth(10);
                               if (Monsters.getNumberMonster() == 0) {
                                   System.out.println("Nehir " + Monsters.getName() + " 'lerden Temizlendi...\nElde edilen Ganimet :" + River.getLoot());
                                   eat=+1;
                                   riverStatus=true;
                                   System.out.println("Savasciniz :" +name + "\nSavascinizin Saglik Durumu :" +health + "\nSavascinizin Kuvveti :" + damage + "\nAltin Mikrari :" + money + "\nLoot'unuz :\nYemek :" + eat + "\nSu :" + water + "\nOdun :" +wood);
                                   if (health<15){
                                       System.out.println("Caniniz Azaliyor...\t\tEve Gitmek ister misiniz ?");
                                       Scanner input=new Scanner(System.in);
                                       GameMeneger.select=input.nextInt();
                                       switch (GameMeneger.select){
                                           case 1:
                                               homeComing();
                                               break;
                                           case 2:continue;

                                       }
                                   }
                                   if (caveStatus&&riverStatus&&forestStatus&&coalStatus){
                                       System.out.println("Tebrikler Tum Lokasyonlar Basari ile Tamamlandi..");
                                       break;
                                   }
                                   System.out.println("Bi Sonraki Bolumu Seciniz :\n1-Magara\n2-Orman\n3-Maden");
                                   Scanner input = new Scanner(System.in);
                                   GameMeneger.select = input.nextInt();
                                   switch (GameMeneger.select) {
                                       case 1: caveWar();break;
                                       case 2: forestWar();break;
                                       case 3: coalWar();break;
                                   }

                               }
                           }


                       }

                   break;
                   case 1:
                       if (!lowArmor||!middleArmor||!highArmor){
                           System.out.println(Monsters.getName()+" Darbe Vurdu..");
                           health=health-Monsters.getDamage();
                           if (health>0){
                               System.out.println(name+" Kalan Cani :"+health);
                           }else {
                               health=0;
                               System.out.println(name+" Kalan Cani :"+health);
                               if (health==0){
                                   System.out.println("Oyunu Kaybettiniz...");

                               }
                           }
                       }
                       if (lowArmor) {
                           System.out.println(Monsters.getName() + " Darbe Vurdu..");
                           Monsters.setDamage(Monsters.getDamage() - İnvertory.getProtectionLowArmor());
                           health =- Monsters.getDamage();
                           if (health>0){
                               System.out.println(name + " Kalan Cani :" + health);
                           }else {
                               health=0;
                               System.out.println(name+"Kalan Cani :"+health+"\nOyunu Kaybettiniz..");
                           }
                       }
                       if (middleArmor) {
                           System.out.println(Monsters.getName() + " Darbe Vurdu..");
                           Monsters.setDamage(Monsters.getDamage() - İnvertory.getProtectionMiddleArmor());
                           health =- Monsters.getDamage();
                           if (health>0){
                               System.out.println(name + " Kalan Cani :" + health);
                           }else {
                               health=0;
                               System.out.println(name+"Kalan Cani :"+health+"\nOyunu Kaybettiniz..");
                           }

                       }
                       if (highArmor) {
                           Monsters.setDamage(Monsters.getDamage() - İnvertory.getProtectionHighArmor());
                           health =- Monsters.getDamage();
                           if (health>0){
                               System.out.println(name + " Kalan Cani :" + health);
                           }else {
                               health=0;
                               System.out.println(name+"Kalan Cani :"+health+"\nOyunu Kaybettiniz..");
                           }
                       }
                       break;

               }


           }

       }

    }

    public static void forestWar() {
        if (forestStatus){
            System.out.println("Lakosyon Tamamlandigi icin Tekrar Giris Yapilamiyor...");
        }
       while (!forestStatus) {
           Bears bears = new Bears();
           System.out.println("Orman'da Mucadeleye Hazir Olun...");
           Monsters.increase();
           System.out.println("Dusman Sayisi :" + Monsters.getNumberMonster() + "\n" + "Ganimet :" + Forest.getLoot() + "\n Mucadele Basliyor...");
           Random random = new Random();
           while (Monsters.getNumberMonster() != 0 && health > 0) {
               int secim = random.nextInt(2);
               switch (secim) {
                   case 0:
                       if (gun||rifle||machineGun){
                           System.out.println(name+" Ates Etti");
                           Monsters.setHealth(Monsters.getHealth()-İnvertory.getDamage());
                           if (Monsters.getHealth()>0){
                               System.out.println(Monsters.getName()+" Kalan Cani :"+Monsters.getHealth());
                           }else {
                               Monsters.setHealth(0);
                               System.out.println(Monsters.getName()+" Kalan Cani :"+Monsters.getHealth());
                               Monsters.setNumberMonster(Monsters.getNumberMonster() - 1);
                               System.out.println(Monsters.getName() + " Hakladiniz..\nKalan " + Monsters.getName() + " sayisi : " + Monsters.getNumberMonster());
                               money+=Monsters.getPrize();
                               Monsters.setHealth(20);
                               if (Monsters.getNumberMonster() == 0) {
                                   System.out.println("Orman " + Monsters.getName() + " 'lerden Temizlendi...\nElde edilen Ganimet :" + Forest.getLoot());
                                   eat+=1;
                                   forestStatus = true;
                                   System.out.println("Savasciniz :" +name + "\nSavascinizin Saglik Durumu :" +health + "\nSavascinizin Kuvveti :" +damage+ "\nAltin Mikrari :" +money + "\nLoot'unuz :\nYemek :" + eat + "\nSu :" +water + "\nOdun :" +wood);
                                   if (health<15){
                                       System.out.println("Caniniz Azaliyor...\t\tEve Gitmek ister misiniz ?");
                                       Scanner input=new Scanner(System.in);
                                       GameMeneger.select=input.nextInt();
                                       switch (GameMeneger.select){
                                           case 1:
                                               homeComing();
                                               break;
                                           case 2:continue;

                                       }
                                   }
                                   if (caveStatus&&riverStatus&&forestStatus&&coalStatus){
                                       System.out.println("Tebrikler Tum Lokasyonlar Basari ile Tamamlandi..");
                                       break;
                                   }
                                   System.out.println("Bi Sonraki Bolumu Seciniz :\n1-Magara\n2-Nehir\n3-Maden");
                                   Scanner input = new Scanner(System.in);
                                   GameMeneger.select = input.nextInt();
                                   switch (GameMeneger.select) {
                                       case 1:
                                           caveWar();
                                           break;
                                       case 2:
                                           riverWar();
                                           break;
                                       case 3:
                                           coalWar();
                                           break;
                                   }

                               }
                           }

                       }else {
                           System.out.println(name+" Darbe Vurdu..");
                           Monsters.setHealth(Monsters.getHealth()-damage);
                           if (Monsters.getHealth() > 0) {
                               System.out.println(Monsters.getName() + " Kalan Cani :" + Monsters.getHealth());
                           } else {
                               Monsters.setHealth(0);
                               Monsters.setNumberMonster(Monsters.getNumberMonster() - 1);
                               System.out.println(Monsters.getName() + " Hakladiniz..\nKalan " + Monsters.getName() + " sayisi : " + Monsters.getNumberMonster());
                               money += Monsters.getPrize();
                               Monsters.setHealth(20);
                               if (Monsters.getNumberMonster() == 0) {
                                   System.out.println("Orman " + Monsters.getName() + " 'lerden Temizlendi...\nElde edilen Ganimet :" + Forest.getLoot());
                                   eat=+1;
                                   forestStatus=true;
                                   System.out.println("Savasciniz :" +name + "\nSavascinizin Saglik Durumu :" +health + "\nSavascinizin Kuvveti :" + damage + "\nAltin Mikrari :" + money + "\nLoot'unuz :\nYemek :" + eat + "\nSu :" + water + "\nOdun :" +wood);
                                   if (health<15){
                                       System.out.println("Caniniz Azaliyor...\t\tEve Gitmek ister misiniz ?");
                                       Scanner input=new Scanner(System.in);
                                       GameMeneger.select=input.nextInt();
                                       switch (GameMeneger.select){
                                           case 1:
                                               homeComing();
                                               break;
                                           case 2:continue;

                                       }
                                   }
                                   if (caveStatus&&riverStatus&&forestStatus&&coalStatus){
                                       System.out.println("Tebrikler Tum Lokasyonlar Basari ile Tamamlandi..");
                                       break;
                                   }
                                   System.out.println("Bi Sonraki Bolumu Seciniz :\n1-Nehir\n2-Magara\n3-Maden");
                                   Scanner input = new Scanner(System.in);
                                   GameMeneger.select = input.nextInt();
                                   switch (GameMeneger.select) {
                                       case 1: riverWar();break;
                                       case 2: caveWar();break;
                                       case 3: coalWar();break;
                                   }

                               }
                           }


                       }

                       break;
                   case 1:
                       if (!lowArmor||!middleArmor||!highArmor){
                           System.out.println(Monsters.getName()+" Darbe Vurdu..");
                           health=health-Monsters.getDamage();

                           if (health>0){
                               System.out.println(name+" Kalan Cani :"+health);
                           }else {
                               health=0;
                               System.out.println(name+" Kalan Cani :"+health);
                               if (health==0){
                                   System.out.println("Oyunu Kaybettiniz...");

                               }
                           }
                       }
                       if (lowArmor) {
                           System.out.println(Monsters.getName() + " Darbe Vurdu..");
                           Monsters.setDamage(Monsters.getDamage() - İnvertory.getProtectionLowArmor());
                           health =- Monsters.getDamage();

                           if (health>0){
                               System.out.println(name + " Kalan Cani :" + health);
                           }else {
                               health=0;
                               System.out.println(name+"Kalan Cani :"+health+"\nOyunu Kaybettiniz..");
                           }
                       }
                       if (middleArmor) {
                           System.out.println(Monsters.getName() + " Darbe Vurdu..");
                           Monsters.setDamage(Monsters.getDamage() - İnvertory.getProtectionMiddleArmor());
                           health =- Monsters.getDamage();
                           System.out.println(name+ " Kalan Cani :" +health);
                           if (health>0){
                               System.out.println(name + " Kalan Cani :" + health);
                           }else {
                               health=0;
                               System.out.println(name+"Kalan Cani :"+health+"\nOyunu Kaybettiniz..");
                           }

                       }
                       if (highArmor) {
                           Monsters.setDamage(Monsters.getDamage() - İnvertory.getProtectionHighArmor());
                           health =- Monsters.getDamage();
                           System.out.print(name + " Kalan Cani :" + health);
                           if (health>0){
                               System.out.println(name + " Kalan Cani :" + health);
                           }else {
                               health=0;
                               System.out.println(name+"Kalan Cani :"+health+"\nOyunu Kaybettiniz..");
                           }
                       }


                       break;
               }
           }
       }

    }

    public static void coalWar() {
        if (coalStatus){
            System.out.println("Lakosyon Tamamlandigi icin Tekrar Giris Yapilamiyor...");
        }
       while (!coalStatus) {
           Snake snake = new Snake();
           Random random=new Random();
           int number=random.nextInt(100);
           if (number>95){
               MachineGun machineGun1=new MachineGun();
               Players.machineGun=true;
               System.out.println("Tebrikler.."+ İnvertory.getName()+" Silahini Aldiniz..");


           }
           if (number>83&&number<90){
               Rifle rifle1=new Rifle();
               Players.rifle=true;
               System.out.println("Tebrikler.."+İnvertory.getName()+" Silahini Aldiniz..");
           }
           if (number>70&&number<80){
               Gun gun1=new Gun();
               Players.gun=true;
               System.out.println("Tebrikler.."+İnvertory.getName()+" Silahini Aldiniz..");
           }
           if (number<5){
               Players.highArmor=true;
               System.out.println("Tebrikler.."+İnvertory.getHighArmor()+" Aldiniz..");
           }
           if (number<20&&number>10){
               Players.middleArmor=true;
               System.out.println("Tebikler..."+İnvertory.getMiddleArmor()+" Aldiniz..");
           }
           if (number<30){
               Players.lowArmor=true;
               System.out.println("Tebikler..."+İnvertory.getLowArmor()+" Aldiniz..");
           }
           System.out.println("Maden'de Mucadeleye Hazir Olun...");
           Monsters.increase();
           System.out.println("Dusman Sayisi :" + Monsters.getNumberMonster() + "\n Mucadele Basliyor...");
           while (Monsters.getNumberMonster() != 0 && health > 0) {

               int secim = random.nextInt(2);
               switch (secim) {
                   case 0:
                       if (gun||rifle||machineGun){
                           System.out.println(name+" Ates Etti");
                           Monsters.setHealth(Monsters.getHealth()-İnvertory.getDamage());
                           if (Monsters.getHealth()>0){
                               System.out.println(Monsters.getName()+" Kalan Cani :"+Monsters.getHealth());
                           }else {
                               Monsters.setHealth(0);
                               System.out.println(Monsters.getName()+" Kalan Cani :"+Monsters.getHealth());
                               Monsters.setNumberMonster(Monsters.getNumberMonster() - 1);
                               System.out.println(Monsters.getName() + " Hakladiniz..\nKalan " + Monsters.getName() + " sayisi : " + Monsters.getNumberMonster());
                               money+=Monsters.getPrize();
                               Monsters.setHealth(12);
                               if (Monsters.getNumberMonster() == 0) {
                                   System.out.println("Maden " + Monsters.getName() + " 'lerden Temizlendi...");
                                   eat+=1;
                                   coalStatus = true;
                                   System.out.println("Savasciniz :" +name + "\nSavascinizin Saglik Durumu :" +health + "\nSavascinizin Kuvveti :" +damage+ "\nAltin Mikrari :" +money + "\nLoot'unuz :\nYemek :" + eat + "\nSu :" +water + "\nOdun :" +wood);
                                   if (health<15){
                                       System.out.println("Caniniz Azaliyor...\t\tEve Gitmek ister misiniz ?");
                                       Scanner input=new Scanner(System.in);
                                       GameMeneger.select=input.nextInt();
                                       switch (GameMeneger.select){
                                           case 1:
                                               homeComing();
                                               break;
                                           case 2:continue;

                                       }
                                   }
                                   if (caveStatus&&riverStatus&&forestStatus&&coalStatus){
                                       System.out.println("Tebrikler Tum Lokasyonlar Basari ile Tamamlandi..");
                                       break;
                                   }
                                   System.out.println("Bi Sonraki Bolumu Seciniz :\n1-Magara\n2-Orman\n3-Nehir");
                                   Scanner input = new Scanner(System.in);
                                   GameMeneger.select = input.nextInt();
                                   switch (GameMeneger.select) {
                                       case 1:
                                           caveWar();
                                           break;
                                       case 2:
                                           forestWar();
                                           break;
                                       case 3:
                                           riverWar();
                                           break;
                                   }

                               }
                           }

                       }else {
                           System.out.println(name+" Darbe Vurdu..");
                           Monsters.setHealth(Monsters.getHealth()-damage);
                           if (Monsters.getHealth() > 0) {
                               System.out.println(Monsters.getName() + " Kalan Cani :" + Monsters.getHealth());
                           } else {
                               Monsters.setHealth(0);
                               Monsters.setNumberMonster(Monsters.getNumberMonster() - 1);
                               System.out.println(Monsters.getName() + " Hakladiniz..\nKalan " + Monsters.getName() + " sayisi : " + Monsters.getNumberMonster());
                               money += Monsters.getPrize();
                               Monsters.setHealth(12);
                               if (Monsters.getNumberMonster() == 0) {
                                   System.out.println("Maden " + Monsters.getName() + " 'lerden Temizlendi...");
                                   eat=+1;
                                   coalStatus=true;
                                   System.out.println("Savasciniz :" +name + "\nSavascinizin Saglik Durumu :" +health + "\nSavascinizin Kuvveti :" + damage + "\nAltin Mikrari :" + money + "\nLoot'unuz :\nYemek :" + eat + "\nSu :" + water + "\nOdun :" +wood);
                                   if (health<15){
                                       System.out.println("Caniniz Azaliyor...\t\tEve Gitmek ister misiniz ?");
                                       Scanner input=new Scanner(System.in);
                                       GameMeneger.select=input.nextInt();
                                       switch (GameMeneger.select){
                                           case 1:
                                               homeComing();
                                               break;
                                           case 2:continue;

                                       }
                                   }
                                   if (caveStatus&&riverStatus&&forestStatus&&coalStatus){
                                       System.out.println("Tebrikler Tum Lokasyonlar Basari ile Tamamlandi..");
                                       break;
                                   }
                                   System.out.println("Bi Sonraki Bolumu Seciniz :\n1-Nehir\n2-Orman\n3-Magara");
                                   Scanner input = new Scanner(System.in);
                                   GameMeneger.select = input.nextInt();
                                   switch (GameMeneger.select) {
                                       case 1: riverWar();break;
                                       case 2: forestWar();break;
                                       case 3: caveWar();break;
                                   }

                               }
                           }


                       }

                       break;
                   case 1:
                       if (!lowArmor||!middleArmor||!highArmor){
                           System.out.println(Monsters.getName()+" Darbe Vurdu..");
                           health=health-Monsters.getDamage();

                           if (health>0){
                               System.out.println(name+" Kalan Cani :"+health);
                           }else {
                               health=0;
                               System.out.println(name+" Kalan Cani :"+health);
                               if (health==0){
                                   System.out.println("Oyunu Kaybettiniz...");

                               }
                           }
                       }
                       if (lowArmor) {
                           System.out.println(Monsters.getName() + " Darbe Vurdu..");
                           Monsters.setDamage(Monsters.getDamage() - İnvertory.getProtectionLowArmor());
                           health =- Monsters.getDamage();

                           if (health>0){
                               System.out.println(name + " Kalan Cani :" + health);
                           }else {
                               health=0;
                               System.out.println(name+"Kalan Cani :"+health+"\nOyunu Kaybettiniz..");
                           }
                       }
                       if (middleArmor) {
                           System.out.println(Monsters.getName() + " Darbe Vurdu..");
                           Monsters.setDamage(Monsters.getDamage() - İnvertory.getProtectionMiddleArmor());
                           health =- Monsters.getDamage();
                           System.out.println(name+ " Kalan Cani :" +health);
                           if (health>0){
                               System.out.println(name + " Kalan Cani :" + health);
                           }else {
                               health=0;
                               System.out.println(name+"Kalan Cani :"+health+"\nOyunu Kaybettiniz..");
                           }

                       }
                       if (highArmor) {
                           Monsters.setDamage(Monsters.getDamage() - İnvertory.getProtectionHighArmor());
                           health =- Monsters.getDamage();
                           System.out.print(name + " Kalan Cani :" + health);
                           if (health>0){
                               System.out.println(name + " Kalan Cani :" + health);
                           }else {
                               health=0;
                               System.out.println(name+"Kalan Cani :"+health+"\nOyunu Kaybettiniz..");
                           }
                       }


                       break;
               }
           }
       }
    }
}