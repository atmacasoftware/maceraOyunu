public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private boolean isFood;
    private boolean isFireWood;
    private boolean isWater;

    public Inventory() {
        this.weapon = new Weapon("Yumruk",-1, 1,0);
        this.armor = new Armor(-1, "Paçavra",0,0);
        this.isFood = false;
        this.isFireWood = false;
        this.isWater = false;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public boolean getIsFood() {
        return isFood;
    }

    public void setFood(boolean food) {
        isFood = food;
    }

    public boolean getIsFireWood() {
        return isFireWood;
    }

    public void setFireWood(boolean fireWood) {
        isFireWood = fireWood;
    }

    public boolean getIsWater() {
        return isWater;
    }

    public void setWater(boolean water) {
        isWater = water;
    }

    public void Food(){
        if(getIsFood() == true){
            System.out.println("Yemek : Var");
        }else{
            System.out.println("Yemek : Yok");
        }
    }

    public void FireWood(){
        if(getIsFireWood() == true){
            System.out.println("Odun : Var");
        }else{
            System.out.println("Odun : Yok");
        }
    }

    public void Water(){
        if(getIsWater() == true){
            System.out.println("Su : Var");
        }else{
            System.out.println("Su : Yok");
        }
    }

}
