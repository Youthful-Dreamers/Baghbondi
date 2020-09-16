// have to change....just wrote shameless green
package NewBaghbondi;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.nio.file.Paths;

public class GameAudio {

        public void introAudio(int status){
            String path="src/resources/gameIntroMusic.mp3";
            Media media=new Media(new File(path).toURI().toString());
            MediaPlayer mediaPlayer=new MediaPlayer(media);
            if(status==0) {
                mediaPlayer.setOnEndOfMedia(new Runnable() {
                    @Override
                    public void run() {
                        mediaPlayer.seek(Duration.ZERO);
                    }
                });
                mediaPlayer.play();
            }
            else if(status==1){
                if(mediaPlayer.getStatus()!=null)mediaPlayer.stop();
            }
        }
    }

