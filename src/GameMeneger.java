import java.util.Random;
import java.util.Scanner;

public class GameMeneger {
   static int select;


   public static void newGame() {
      System.out.println("Macera Oyununa Hos Geldiniz...\nKarakter Seciniz :\n1.Okcu\n2.Sovalye\n3.Samuray");
      Scanner input = new Scanner(System.in);
      GameMeneger.select = input.nextInt();


      switch (select) {
         case 1:
            Okcu okcu = new Okcu();
            System.out.println("Savasciniz :" + Players.getName() + "\n" + "Savascinizin Saglik Durumu :" + Players.getHealth() + "\nSavascinizin Kuvveti :" + Players.getDamage() + "\nAltin Mikrari :" + Players.getMoney() + "\nLoot'unuz :\nYemek :" + Loot.getEat() + "\nSu :" + Loot.getWater() + "\nOdun :" + Loot.getWood());
            while ( Players.getHealth()> 0) {
               System.out.println("Lokasyonunuzu Seciniz :\n1-Magara\n2-Nehir\n3-Orman\n4-Maden\n5-Magaza");
               GameMeneger.select = input.nextInt();
               switch (select) {
                  case 1:
                     Players.caveWar();
                     break;
                  case 2:
                     Players.riverWar();
                     break;
                  case 3:
                     Players.forestWar();
                     break;
                  case 4:
                     Players.coalWar();
                     break;
                  case 5:
                     Shop.entrance();
                     break;
               }
               if (Players.caveStatus&&Players.riverStatus&&Players.forestStatus&&Players.coalStatus){
                  System.out.println("Tebrikler Tum Lokasyonlar Basari ile Tamamlandi..");
                  break;
               }
            }
            break;

         case 2:
            Sovalye sovalye = new Sovalye();
            System.out.println("Savasciniz :" + Players.getName() + "\n" + "Savascinizin Saglik Durumu :" + Players.getHealth() + "\nSavascinizin Kuvveti :" + Players.getDamage() + "\nAltin Mikrari :" + Players.getMoney() + "\nLoot'unuz :\nYemek :" + Loot.getEat() + "\nSu :" + Loot.getWater() + "\nOdun :" + Loot.getWood());
            while (Players.getHealth() > 0) {
               System.out.println("Savas Lokasyonunuzu Seciniz :\n1-Magara\n2-Nehir\n3-Orman\n4-Maden\n5-Magaza");
               GameMeneger.select = input.nextInt();
               switch (select) {
                  case 1:
                     Players.caveWar();
                     break;
                  case 2:
                     Players.riverWar();
                     break;
                  case 3:
                     Players.forestWar();
                     break;
                  case 4:
                     Players.coalWar();
                     break;
                  case 5:
                     Shop.entrance();
                     break;
               }
               if (Players.caveStatus&&Players.riverStatus&&Players.forestStatus&&Players.coalStatus){
                  System.out.println("Tebrikler Tum Lokasyonlar Basari ile Tamamlandi..");
                  break;
               }

            }
            break;
         case 3:
            Samuray samuray = new Samuray();
            System.out.println("Savasciniz :" + Players.getName() + "\n" + "Savascinizin Saglik Durumu :" + Players.getHealth() + "\nSavascinizin Kuvveti :" + Players.getDamage() + "\nAltin Mikrari :" + Players.getMoney() + "\nLoot'unuz :\nYemek :" + Loot.getEat() + "\nSu :" + Loot.getWater() + "\nOdun :" + Loot.getWood());
            while (Players.getHealth() > 0) {
               System.out.println("Savas Lokasyonunuzu Seciniz :\n1-Magara\n2-Nehir\n3-Orman\n4-Maden\n5-Magaza");
               GameMeneger.select = input.nextInt();
               switch (select) {
                  case 1:
                     Players.caveWar();
                     break;
                  case 2:
                     Players.riverWar();
                     break;
                  case 3:
                     Players.forestWar();
                     break;
                  case 4:
                     Players.coalWar();
                     break;
                  case 5:
                     Shop.entrance();
                     break;
               }
               if (Players.caveStatus&&Players.riverStatus&&Players.forestStatus&&Players.coalStatus){
                  System.out.println("Tebrikler Tum Lokasyonlar Basari ile Tamamlandi..");
                  break;
               }

            }
            break;

      }

   }


}