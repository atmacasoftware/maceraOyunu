import java.util.Scanner;

public abstract class Location {
    private int id;
    private Player player;
    private String name;
    private String description;
    public static Scanner input = new Scanner(System.in);

    public Location( Player player, int id, String name, String description) {
        this.player = player;
        this.id = id;
        this.name = name;
        this.description = description;
    }



    public abstract boolean onLocation();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
