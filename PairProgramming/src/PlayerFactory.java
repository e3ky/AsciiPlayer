import java.io.File;

public class PlayerFactory {
    public static Player makeNewPlayer(String path) {
        String extension = "";

        int i = path.lastIndexOf('.');
        if (i > 0) {
            extension = path.substring(i + 1);
        }

        System.out.println("Extensin: " + extension);
        if (extension.equals("jpg") || extension.equals("png")) {
            return new PicturePlayer(new File(path));
        } else {
            return null;
        }

    }
}
