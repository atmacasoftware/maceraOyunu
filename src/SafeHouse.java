public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, 1, "Güvenli Ev", "Burası sizin içi güvenli bir ev, düşman yoktur.");
    }

    @Override
    public boolean onLocation(){
        System.out.println("Güvenli evdesiniz !");
        this.getPlayer().printInfo();
        return true;
    }
}
