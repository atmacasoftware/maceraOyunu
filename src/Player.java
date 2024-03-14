import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int orginalHealth;
    private int money;
    private String charName;
    private String name;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public void printInfo(){
        System.out.println();
        System.out.println("Silahınız : " + this.getInventory().getWeapon().getName());
        System.out.println("Zırhınız : " + this.getInventory().getArmor().getName());
        System.out.println("Bloklama : " + this.getInventory().getArmor().getBlock());
        System.out.println("Hasarınız : " + this.getTotalDamage());
        System.out.println("Sağlık : " + this.getHealth());
        System.out.println("Para : " + this.getMoney());
        this.getInventory().Food();
        this.getInventory().FireWood();
        this.getInventory().Water();
    }

    public void selectChar() {

        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};

        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("Karakterler");

        for (GameChar gameChar : charList) {
            System.out.println("ID: " + gameChar.getId() + "\t Karakter: " + gameChar.getName() + "\t\t Hasar : " + gameChar.getDamage() + "\t\t Sağlık: " + gameChar.getHealth() + "\t\t Para: " + gameChar.getMoney());
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.print("Lütfen bir karakter seçiniz : ");
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("Seçilen Karakter : ");
        System.out.println(this.charName + ", Hasar: " + this.damage + ", Sağlık: " + this.health + ", Para: " + this.money);
    }

    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setOrginalHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if(health <= 0){
            this.health = 0;
        }
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Weapon getWeapon(){
        return this.getInventory().getWeapon();
    }

    public Armor getArmor(){
        return this.getInventory().getArmor();
    }

    public int getOrginalHealth() {
        return orginalHealth;
    }

    public void setOrginalHealth(int orginalHealth) {
        this.orginalHealth = orginalHealth;
    }
}
