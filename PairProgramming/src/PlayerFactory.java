
public class PlayerFactory {
    Player makeNewPlayer(String path) {
        String extension = "";

        int i = path.lastIndexOf('.');
        if (i > 0) {
            extension = path.substring(i + 1);
        }

        if (extension.equals(".jpg") || extension.equals(".png")) {
            return new PicturePlayer(File);
        }
    }
}
