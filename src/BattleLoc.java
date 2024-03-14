import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, int id, String name, String description, Obstacle obstacle, String award, int maxObstacle) {
        super(player, id, name, description);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("Şuan buradasınız : " + this.getName());
        System.out.println("Dikkatli Ol! Burada " + obsNumber + " tane " + this.getObstacle().getName() + " yaşıyor !");
        System.out.print("(S) Savaş veya (K) kaç : ");
        String selectCase = input.nextLine().toUpperCase();
        if (selectCase.equals("S") && combat(obsNumber)) {
            //Start combat
            System.out.println(this.getName() + " bölgesindeki tüm canavarları öldürdünüz !");
            return true;
        }

        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("Öldünüz.");
            return false;
        }

        return true;
    }

    public boolean combat(int obsNumber) {
        for (int i = 0; i < obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOrginalHealth());
            playerStats();
            obstacleStats(i + 1);
            if (isFindFirstHit()) {
                System.out.println("İlk vuruş hakkı sizde.");
                kill();
            } else {
                System.out.println("İlk vuruş hakkı " + this.getObstacle().getName() + " adlı canavarda");
                if (this.getObstacle().getHealth() > 0) {
                    System.out.println();
                    System.out.println("Canavar size " + this.getObstacle().getDamage() + " hasar vurdu.");
                    int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getArmor().getBlock();
                    if (obstacleDamage < 0) {
                        obstacleDamage = 0;
                    }
                    this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                    afterHit();
                }
                kill();
            }
            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("Düşmanı yendiniz ! ");
                System.out.println(this.getObstacle().getAward() + " para kazandınız !");
                updateMoney();
            } else {
                return false;
            }
        }
        // Tüm canavarlar öldükten sonra ödülü alma.
        pickedItem();
        return true;
    }

    boolean isFindFirstHit() {
        double randomNumber = Math.random() * 100;
        if (randomNumber <= 50) {
            return true;
        } else {
            return false;
        }
    }

    public boolean kill(){
        while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
            System.out.print("(V) Vur veya (K) Kaç : ");
            String selectCombat = input.nextLine().toUpperCase();
            if (selectCombat.equals("V")) {
                System.out.println("Siz vurdunuz !");
                this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                afterHit();
                if (this.getObstacle().getHealth() > 0) {
                    System.out.println();
                    System.out.println("Canavar size vurdu !");
                    int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getArmor().getBlock();
                    if (obstacleDamage < 0) {
                        obstacleDamage = 0;
                    }
                    this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                    afterHit();
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public void pickedItem() {
        String getAward = getAward();
        if (getAward.equals("food")) {
            getPlayer().getInventory().setFood(true);
        }

        if (getAward.equals("water")) {
            getPlayer().getInventory().setWater(true);
        }

        if (getAward.equals("firewood")) {
            getPlayer().getInventory().setFireWood(true);
        }

        if (this.getName().equals("Maden")) {
            this.getRandomSpecialItem();
        }
    }

    public void getRandomSpecialItem() {
        int randomItem = new Random().nextInt(100);
        if (randomItem < 15) {
            randomItem = new Random().nextInt(100);
            this.winWeapon(randomItem);
        } else if (randomItem < 30) {
            randomItem = new Random().nextInt(100);
            winArmor(randomItem);
        } else if (randomItem < 55) {
            randomItem = new Random().nextInt(100);
            winMoney(randomItem);
        } else {
            System.out.println("Hiç bir şey kazanamadınız!");
        }
    }

    public void winMoney(int randomNumber) {
        if (randomNumber < 20) {
            getPlayer().setMoney(getPlayer().getMoney() + 10);
            System.out.println("Canavardan size 10 Para düştü. Yeni paranız : " + getPlayer().getMoney());
        } else if (randomNumber < 50) {
            getPlayer().setMoney(getPlayer().getMoney() + 5);
            System.out.println("Canavardan size 5 Para düştü. Yeni paranız : " + getPlayer().getMoney());
        } else {
            getPlayer().setMoney(getPlayer().getMoney() + 1);
            System.out.println("Canavardan size 1 Para düştü. Yeni paranız : " + + getPlayer().getMoney());
        }
    }


    public void winWeapon(int randomNumber) {
        if (randomNumber < 10) {
            getPlayer().getInventory().getWeapon().setDamage(10);
            System.out.println("Canavardan özel item Mızrak düştü.");
        } else if (randomNumber < 15) {
            getPlayer().getInventory().getWeapon().setDamage(7);
            System.out.println("Canavardan özel item Ok düştü.");
        } else if (randomNumber < 25) {
            getPlayer().getInventory().getWeapon().setDamage(3);
            System.out.println("Canavardan özel item Kılıç düştü.");
        }else{
            getPlayer().getInventory().getWeapon().setDamage(2);
            System.out.println("Canavardan özel item Tokmak düştü.");
        }
    }

    public void winArmor(int randomNumber) {
        if (randomNumber < 20) {
            getPlayer().getInventory().getArmor().setBlock(5);
            System.out.println("Canavarda Ağır zırh çıktı yeni değerleriniz: " + getPlayer().getInventory().getArmor().getBlock());
        } else if (randomNumber < 30) {
            getPlayer().getInventory().getArmor().setBlock(3);
            System.out.println("Canavarda Orta zırh çıktı yeni değerleriniz: " + getPlayer().getInventory().getArmor().getBlock());
        } else {
            getPlayer().getInventory().getArmor().setBlock(1);
            System.out.println("Canavarda Hafif zırh çıktı yeni değerleriniz: " + getPlayer().getInventory().getArmor().getBlock());
        }
    }

    public void updateMoney() {
        this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
    }

    public void afterHit() {
        System.out.println("Canınız : " + this.getPlayer().getHealth());
        System.out.println(this.obstacle.getName() + " Canı : " + this.obstacle.getHealth());
        System.out.println();
    }

    public void playerStats() {
        System.out.println("Oyuncu Değerleri");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("Sağlık : " + this.getPlayer().getHealth());
        System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("Para : " + this.getPlayer().getMoney());
        System.out.println("Silah : " + this.getPlayer().getWeapon().getName());
        System.out.println("Zırh : " + this.getPlayer().getArmor().getName());
        System.out.println("Bloklama : " + this.getPlayer().getArmor().getBlock());
        System.out.println();
    }

    public void obstacleStats(int i) {
        System.out.println(i + ". " + this.getObstacle().getName() + " Değerleri");
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("Sağlık :" + this.getObstacle().getHealth());
        System.out.println("Hasar :" + this.getObstacle().getDamage());
        System.out.println("Ödül :" + this.getObstacle().getAward());
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
