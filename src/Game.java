import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Macera Oyununa Hoşgeldiniz !");
        System.out.print("Lütfen bir isim giriniz : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println("Sayın " + player.getName() + " bu karanlık ve sisli adaya hoşgeldiniz !");
        System.out.println("Lütfen karakter seçiniz...");
        player.selectChar();
        player.printInfo();
        Location location = null;
        while (true){
            Location[] locationList = {new SafeHouse(player), new ToolStore(player), new Pharmacist(player), new Cave(player), new Forest(player), new River(player), new Mine(player)};
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.println("Bölgeler");

            for (Location local : locationList) {
                System.out.println("ID: " + local.getId() + "\t Ad: " + local.getName() + " --> " + local.getDescription());
            }
            System.out.println("0 - Çıkış Yap --> Oyunu sonlandır!");
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.print("Lütfen bir bölge seçiniz : ");
            int selectLoc = input.nextInt();
            switch (selectLoc){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Pharmacist(player);
                    break;
                case 4:
                    if(!player.getInventory().getIsFood()){
                        location = new Cave(player);
                    }else{
                        location = new SafeHouse(player);
                    }
                    System.out.println("Zaten bu bölgeden ödül kazandınız. Daha giremezsiniz. Güvenli eve döndürüleceksiniz!");
                    System.out.println();
                    break;
                case 5:
                    if(!player.getInventory().getIsFireWood()){
                        location = new Forest(player);
                    }else{
                        location = new SafeHouse(player);
                    }
                    System.out.println("Zaten bu bölgeden ödül kazandınız. Daha giremezsiniz. Güvenli eve döndürüleceksiniz!");
                    System.out.println();
                    break;
                case 6:
                    if(!player.getInventory().getIsWater()){
                        location = new River(player);
                    }else{
                        location = new SafeHouse(player);
                    }
                    System.out.println("Zaten bu bölgeden ödül kazandınız. Daha giremezsiniz. Güvenli eve döndürüleceksiniz!");
                    System.out.println();
                    break;
                case 7:
                    location = new Mine(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz !");
            }

            if(location == null){
                System.out.println("Bu karanlık ve sisli adadan çabuk vazgeçtin !");
                break;
            }

            if(!location.onLocation()){
                System.out.println("GAME OVER");
                break;
            }

        }

    }

}
