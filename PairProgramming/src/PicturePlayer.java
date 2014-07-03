import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PicturePlayer extends FilePlayer {

    public PicturePlayer(File file) {
        super(file);

    }

    @Override
    public void play() throws IOException {
        PlayerUtils.write(ImageIO.read((file)));
    }

}
