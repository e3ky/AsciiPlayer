import java.io.IOException;

public class Executor {
    public static void main(String[] args) throws IOException {
        Player player = PlayerFactory.makeNewPlayer(args[0]);
        // System.out.println(args[0]);
        player.play();
    }
}
