package NewBaghbondi;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameOverScene {

    private int languageOption;

    protected GameOverScene(int languageOption){
        this.languageOption = languageOption;
    }

    public Scene createGameOverScene(boolean tigerWin) {
        String labelOneString;
        String labelTwoString;
        labelOneString = determineLabelOneString();
        labelTwoString = determineLabelTwoString(tigerWin);

        Label labelOne = createLabel(labelOneString, "#228b22");
        Label labelTwo = createLabel(labelTwoString, "#ff4500");

        VBox vBox = createVBox(labelOne, labelTwo);
        return new Scene(vBox, 950, 650);
    }

    private String determineLabelOneString(){
        String labelOneString;
        if(languageOption == 1) labelOneString = "খেলা সমাপ্ত!";
        else labelOneString = "Game Over!";
        return  labelOneString;
    }

    private String determineLabelTwoString(boolean tigerWin){
        String type;
        String labelTwoString;

        if (tigerWin) {
            if(languageOption == 1) type = "বাঘ";
            else type = "Tiger";
        } else {
            if(languageOption == 1) type = "ছাগল";
            else type = "Goat";
        }

        if(languageOption == 1) labelTwoString = type+" জিতেছে!!";
        else labelTwoString = type+" has own the game!!";

        return labelTwoString;
    }

    private Label createLabel(String string, String color){
        Label label = new Label(string);
        label.setFont(new Font("Arial", 25));
        label.setTextFill(Color.web(color, 1.0));
        return  label;
    }

    private VBox createVBox(Label labelOne, Label labelTwo){
        VBox vBox = new VBox(5);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(labelOne, labelTwo);
        return vBox;
    }
}
