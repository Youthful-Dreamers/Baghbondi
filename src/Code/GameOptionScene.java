import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameOptionScene {

    int languageOption;
    Stage stage;
    Scene gameOptionScene;
    SceneBuilder sceneBuilder;
    GameAudio gameAudio;

    protected GameOptionScene(Stage stage){
        this.stage = stage;
        sceneBuilder = new SceneBuilder();
        createGameOptionScene();
        gameAudio=new GameAudio();
    }

    protected void createGameOptionScene(){
        sceneBuilder.createMenuVBox(5);
        gameOptionScene = sceneBuilder.createScene();
    }

    protected void languageBasedWorks(int languageOption){
        this.languageOption = languageOption;
        setLabelText();
        setButtonOneText();
        setButtonTwoText();
    }

    protected void setLabelText(){
        if(languageOption == 1) sceneBuilder.labelOne.setText("স্বাগতম!");
        else sceneBuilder.labelOne.setText("Welcome!");
    }

    protected void setButtonOneText(){
        if(languageOption == 1) sceneBuilder.buttonOne.setText("ডিফল্ট গেম");
        else sceneBuilder.buttonOne.setText("Default Game");
    }

    protected void setButtonTwoText(){
        if(languageOption == 1) sceneBuilder.buttonTwo.setText("ল্যান গেম");
        else sceneBuilder.buttonTwo.setText("LAN Game");
    }

    protected void initializeButtonEventWorks(GameScene gameScene){
        sceneBuilder.buttonOne.setOnAction( e->  {
            gameScene.getPaneOfGame().getChildren().removeAll(gameScene.getMessages(), gameScene.getInput());
            setSceneAndCallBoardListener(gameScene);
        });
        sceneBuilder.buttonTwo.setOnAction( e-> setSceneAndCallBoardListener(gameScene));
    }

    private void setSceneAndCallBoardListener(GameScene gameScene){
        gameAudio.buttonClickedAudio();
        stage.setScene(gameScene.getSceneOfGame());
        BoardListener boardListener = new BoardListener(stage, gameScene.getGameBoard(), gameScene.getPaneOfGame(), languageOption);
    }

    protected Scene getLanguageOptionScene(){
        return gameOptionScene;
    }
}
