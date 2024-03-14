public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, 2, "Eşya Mağazası", "Silah veya Zırh satın alabilirsiniz.");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya Hoşgeldiniz !");
        boolean showMenu = true;
        while (showMenu){
            System.out.println("1 - Silahlar");
            System.out.println("2 - Zırhlar");
            System.out.println("3 - Çıkış Yap");
            System.out.print("Seçim yapınız : ");
            int selectCase = input.nextInt();

            while (selectCase > 3 || selectCase < 1){
                System.out.print("Geçersiz değer girdiniz. Tekrar giriniz : ");
                selectCase = input.nextInt();
            }

            switch (selectCase){
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Bir daha bekleriz.");
                    showMenu = false;
                    break;

            }
        }
        return true;
    }

    public void printWeapon(){
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("Silahlar");
        for(Weapon w: Weapon.weapons()){
            System.out.println("ID: " + w.getId() + " Ad: " + w.getName() + " <Para : " + w.getPrice() + " , Hasar: " + w.getDamage() + ">");
        }
        System.out.println("0 - Çıkış Yap");
    }

    public void buyWeapon(){
        System.out.print("Bir silah seçiniz : ");
        int selectWeaponID = input.nextInt();
        while (selectWeaponID > Weapon.weapons().length || selectWeaponID < 1){
            System.out.print("Geçersiz değer girdiniz. Tekrar giriniz : ");
            selectWeaponID = input.nextInt();
        }

        if(selectWeaponID != 0){
            Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponID);

            if(selectedWeapon != null){
                if(selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli paranız bulunmamaktadır.");
                }else{
                    // Satın almanın gerçekleştiği alan
                    System.out.println(selectedWeapon.getName() + " silahını satın aldınız !");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println();
                    System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }
        }
    }

    public void printArmor(){
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("Zırhlar");
        for(Armor a: Armor.armors()){
            System.out.println("ID: " + a.getId() + " Ad: " + a.getName() + " <Para : " + a.getPrice() + " , Zırh : " + a.getBlock() + " >");
        }
    }

    public void buyArmor(){
        System.out.print("Bir zırh seçiniz : ");
        int selectArmorID = input.nextInt();
        while (selectArmorID > Armor.armors().length || selectArmorID < 1){
            System.out.print("Geçersiz değer girdiniz. Tekrar giriniz : ");
            selectArmorID = input.nextInt();
        }

        if(selectArmorID != 0){
            Armor selectedArmor = Armor.getArmorObjById(selectArmorID);

            if(selectedArmor != null){
                if(selectedArmor.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli paranız bulunmamaktadır.");
                }else{
                    // Satın almanın gerçekleştiği alan
                    System.out.println(selectedArmor.getName() + " zırhını satın aldınız !");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println();
                    System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                }
            }
        }
    }
}
