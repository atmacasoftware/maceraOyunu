public class Pharmacist extends NormalLoc{
    public Pharmacist(Player player) {
        super(player, 3, "Eczacı", "Sağlığını doldurmak için ilaç alabilirsiniz.");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Mağazaya Hoşgeldiniz !");
        boolean showMenu = true;
        while (showMenu){
            System.out.println("1 - İlaç Al");
            System.out.println("2 - Çıkış Yap");
            System.out.print("Seçim yapınız : ");
            int selectCase = input.nextInt();

            while (selectCase > 2 || selectCase < 1){
                System.out.print("Geçersiz değer girdiniz. Tekrar giriniz : ");
                selectCase = input.nextInt();
            }

            switch (selectCase){
                case 1:
                    printMedicine();
                    buyMedicine();
                    break;
                case 2:
                    System.out.println("Bir daha bekleriz.");
                    showMenu = false;
                    break;

            }
        }
        return true;
    }

    public void printMedicine(){
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("İlaçlar");
        for(Medicine m: Medicine.medicines()){
            System.out.println("ID: " + m.getId() + " Ad: " + m.getName() + " <Para : " + m.getPrice() + " , Sağlığa Etkisi: " + m.getEffect() + ">");
        }
        System.out.println("0 - Çıkış Yap");
    }

    public void buyMedicine(){
        System.out.print("Bir ilaç seçiniz : ");
        int selectMedicineID = input.nextInt();
        while (selectMedicineID > Medicine.medicines().length || selectMedicineID < 1){
            System.out.print("Geçersiz değer girdiniz. Tekrar giriniz : ");
            selectMedicineID = input.nextInt();
        }

        if(selectMedicineID != 0){
            Medicine selectedMedicine = Medicine.getMedicineObjById(selectMedicineID);

            if(selectedMedicine != null){
                if(selectedMedicine.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli paranız bulunmamaktadır.");
                }else{
                    // Satın almanın gerçekleştiği alan
                    System.out.println(selectedMedicine.getName() + " ilacını satın aldınız !");
                    if (selectedMedicine.getEffect() > this.getPlayer().getHealth()){
                        this.getPlayer().setHealth(this.getPlayer().getOrginalHealth());
                        System.out.println("Sağlığını tamamen yenilendi.");
                    }else{
                        this.getPlayer().setHealth(this.getPlayer().getHealth() + selectedMedicine.getEffect());
                        System.out.println("Sağlığını " + selectedMedicine.getEffect() + " arttı.");
                    }
                    System.out.println();
                    int balance = this.getPlayer().getMoney() - selectedMedicine.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                }
            }
        }
    }

}
