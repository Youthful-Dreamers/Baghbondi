package NewBaghbondi;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Menu {
    Stage stage;
    Menu(Stage stage){
        this.stage = stage;
    }
    
    public Scene createMenuScene(int selectedLanguage)
    {
        String welcomeLabelString;
        String buttonForDefaultGameString;
        String buttonForLanGameString;

        Button buttonForDefaultGame = new Button();
        Button buttonForLanGame = new Button();

        if(selectedLanguage == 1){
            welcomeLabelString = "স্বাগতম!";
            buttonForDefaultGameString = "ডিফল্ট গেম";
            buttonForLanGameString = "ল্যান হেম";
        } else {
            welcomeLabelString = "Welcome!";
            buttonForDefaultGameString = "Default Game";
            buttonForLanGameString = "LAN Game";
        }

        Label welcomeLabel = new Label(welcomeLabelString);
        welcomeLabel.setFont(new Font("Arial", 14));

        buttonForDefaultGame.setText(buttonForDefaultGameString);
        buttonForDefaultGame.setOnAction( e-> {
                new StageCreator().boardStage();
                stage.close();
        });

        buttonForLanGame.setText(buttonForLanGameString);
        buttonForLanGame.setOnAction( e-> System.out.println("Not developed yet"));

        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(welcomeLabel, buttonForDefaultGame, buttonForLanGame);

        return new Scene(layout, 700,700);
    }

    public Scene createSceneLanguageOption()
    {
        Button button1 = new Button();
        Button button2 = new Button();

        Label label= new Label("ভাষা পছন্দ করুনঃ\nSelect a language:");
        label.setFont(new Font("Arial", 14));

        button1.setText("বাংলা");
        button1.setOnAction( e-> stage.setScene(createMenuScene(1)));

        button2.setText("English");
        button2.setOnAction( e->stage.setScene(createMenuScene(2)));

        VBox vBox= new VBox(5);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(label,button1,button2);

        return new Scene(vBox, 700,700);
    }
}
