package codes;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.net.URL;

public class GameAudio {

    public void inGameAudio() {
        String path = "resources/inGameAudio.mp3";
        URL audioUrl = getClass().getClassLoader().getResource(path);
        Media media = new Media(audioUrl.toString());
        MediaPlayer mediaPlayer=new MediaPlayer(media);
        mediaPlayer.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                mediaPlayer.seek(Duration.ZERO);
            }
        });
        mediaPlayer.setVolume(0.5);
        mediaPlayer.play();
    }

    public void buttonClickedAudio(){
        String path="resources/buttonClicked.mp3";
        
        URL audioUrl = getClass().getClassLoader().getResource(path);
        AudioClip audioClip=new AudioClip(audioUrl.toString());
        audioClip.play();
    }

    public void tigerKillAudio(){
        String path="resources/tigerKill.mp3";
        URL audioUrl = getClass().getClassLoader().getResource(path);
        AudioClip audioClip = new AudioClip(audioUrl.toString());
        
        audioClip.setVolume(0.5);
        audioClip.play();
    }

    protected void callInGameAudio(){
        try{
            this.inGameAudio();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    protected void callButtonClickedAudio(){
        try{
            this.buttonClickedAudio();
        } catch(Exception ex){
            System.out.println("Error in playing the Audion: "+ex);
        }
    }

    protected void callTigerKilAudio(){
        try{
            this.tigerKillAudio();
        } catch(Exception ex){
            System.out.println("Error in playing the Audion: "+ex);
        }
    }
}

