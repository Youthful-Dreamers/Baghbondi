package code;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SceneBuilder {

    Label labelOne;
    Label labelTwo;
    Button buttonOne;
    Button buttonTwo;
    VBox vBox;

    protected void createMenuVBox(int space){
        labelOne = createLabel(30);
        labelOne.setTextFill(Color.web("#003300", 1));
//        labelOne.setTextFill(Color.BROWN);
        buttonOne = createButton();
        buttonTwo = createButton();
        vBox = createVBox(labelOne, null, space, buttonOne, buttonTwo, true);
    }

    protected void createGameOverVBox(){
        labelOne = createLabel(40);
        labelOne.setTextFill(Color.web("#006400"));
        labelTwo = createLabel(40);
        vBox = createVBox(labelOne, labelTwo, 10, null,null, false);
    }

    protected Scene createScene(){
        return new Scene(vBox, 950, 650);
    }


    protected VBox createVBox(Label labelOne, Label labelTwo, int space, Button buttonOne, Button buttonTwo, boolean menuIndicator){
        VBox vBox= new VBox(space);
        vBox.setBackground(setBackgroundPicture("resources/gameStartScene.png"));
        vBox.setAlignment(Pos.CENTER);
        getVBoxChildren(vBox, labelOne, labelTwo, buttonOne, buttonTwo, menuIndicator);
        return vBox;
    }

    protected void getVBoxChildren(VBox vBox, Label labelOne, Label labelTwo, Button buttonOne, Button buttonTwo, boolean menuIndicator){
        if(menuIndicator){
            vBox.getChildren().addAll(labelOne, buttonOne, buttonTwo);
        } else {
            vBox.getChildren().addAll(labelOne, labelTwo);
        }
    }

    public Label createLabel(int fontSize){
        Label label= new Label();
        label.setFont(Font.font("Arial", FontWeight.BOLD, fontSize));
        return label;
    }

    protected Button createButton(){
        Button button = new Button();
        button.setStyle("-fx-font-size:20; -fx-background-color: #006400; -fx-text-fill: white; -fx-font-weight: bold;");
        return button;
    }

    protected Background setBackgroundPicture(String string){
        Image image = new Image(string, 950, 650, false, false, true);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        return new Background(backgroundImage);
    }
}
