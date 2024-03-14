public abstract class NormalLoc extends Location {

    public NormalLoc(Player player, int id, String name, String description) {
        super(player, id, name, description);
    }

    @Override
    public boolean onLocation() {
        return true;
    }
}
