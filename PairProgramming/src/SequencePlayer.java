import java.awt.List;
import java.io.File;

public abstract class SequencePlayer extends FilePlayer {

    public SequencePlayer(File file) {
        super(file);
        // TODO Auto-generated constructor stub
    }

    abstract List getImages();
}

// main
//
// Player player = PlayerFactory.newPlayer(args);
// player.play;
//
//
// PlayerFactory
//
// new Player(file)
// gif--->return new GifPlayer
// video----> return new VideoPlayer