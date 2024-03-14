public class Medicine {
    private String name;
    private int id;
    private int effect;
    private int price;

    public Medicine(String name, int id, int effect, int price) {
        this.name = name;
        this.id = id;
        this.effect = effect;
        this.price = price;
    }

    public static Medicine[] medicines(){
        Medicine[] medicineList = new Medicine[3];
        medicineList[0] = new Medicine("Ucuz", 1, 5, 2);
        medicineList[1] = new Medicine("Orta", 2, 10, 5);
        medicineList[2] = new Medicine("Pahallı", 3, 20, 10);
        return medicineList;
    }

    public static Medicine getMedicineObjById(int id){
        for (Medicine m: Medicine.medicines()){
            if(m.getId() == id){
                return m;
            }
        }
        return null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEffect() {
        return effect;
    }

    public void setEffect(int effect) {
        this.effect = effect;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
