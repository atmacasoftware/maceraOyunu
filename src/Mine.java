import java.util.Random;

public class Mine extends BattleLoc{
    Random random = new Random();
    public Mine(Player player) {
        super(player, 7, "Maden", "Ödül <Para, Silah veya Zırh> Madene Gir, dikkatli ol burada yılan çıkabilir !", new Snake(), "", 5);
    }

}
