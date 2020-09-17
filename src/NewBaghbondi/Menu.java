package NewBaghbondi;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Stack;

public class Menu {

    Stage stage;
    int languageOption;
    GameScene gameScene;
    GameAudio gameAudio=new GameAudio();
    Menu(Stage stage){
        this.stage = stage;
    }
    
    public Scene createMenuScene(int languageOption) {
        String welcomeLabelString = determineMenuString(languageOption, "স্বাগতম!","Welcome!");
        String buttonForDefaultGameString = determineMenuString(languageOption, "ডিফল্ট গেম", "Default Game");
        String buttonForLanGameString = determineMenuString(languageOption,"ল্যান হেম", "LAN Game");

        Label welcomeLabel = createLabel(welcomeLabelString);
        Button buttonForDefaultGame = createButtonForDefaultGame(buttonForDefaultGameString);
        Button buttonForLanGame = createButtonForLANGame(buttonForLanGameString);
        VBox layout = createVBox(welcomeLabel, 10, buttonForDefaultGame, buttonForLanGame);

        return new Scene(layout, 950,650);
    }

    public Scene createSceneLanguageOption() {
        Label label= createLabel("ভাষা পছন্দ করুনঃ\nSelect a language:");
        Button button1 = createLanguageOptionButton("বাংলা", 1);
        Button button2 = createLanguageOptionButton("English", 2);
        VBox vBox= createVBox(label, 5, button1, button2);

        StackPane root=new StackPane();
        root.setId("ui");
        root.getChildren().add(vBox);
        Scene gameOpening=new Scene(root,950,650);
        gameOpening.getStylesheets().addAll(this.getClass().getResource("/CSS/style.css").toExternalForm());
        return gameOpening;
    }




    private Label createLabel(String string){
        Label label= new Label(string);
        label.setFont(new Font("Arial", 24));
        return label;
    }

    private VBox createVBox(Label label, int space, Button buttonOne, Button buttonTwo){
        VBox vBox= new VBox(space);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(label, buttonOne, buttonTwo);
        return vBox;
    }

    private Button createLanguageOptionButton(String string, int optionNo){
        Button button = new Button();
        button.setText(string);
        button.setOnAction( e-> {
            stage.setScene(createMenuScene(optionNo));
            languageOption = optionNo;
            gameAudio.buttonClickedAudio();
        });
        return button;
    }

    private String determineMenuString(int languageOption, String stringOne, String stringTwo){
        String temporaryString;
        if(languageOption == 1){
            temporaryString = stringOne;
        }else{
            temporaryString = stringTwo;
        }
        return temporaryString;
    }

    private Button createButtonForDefaultGame(String string){
        Button button = new Button();
        button.setText(string);
        button.setOnAction( e-> {
            GameScene gameScene = new GameScene();
            stage.setScene(gameScene.getSceneOfGame());
            gameAudio.buttonClickedAudio();
        });
        return button;
    }

    private Button createButtonForLANGame(String string){
        Button button = new Button();
        button.setText(string);
        button.setOnAction( e->System.out.println("Not developed yet"));
        return button;
    }
    public Scene getOpeningScene(){
        Pane pane=new Pane();
        pane.setId("ui");
        Scene scene=new Scene(pane,950,650);
        scene.getStylesheets().addAll(this.getClass().getResource("/CSS/style.css").toExternalForm());
        return scene;
    }

}
