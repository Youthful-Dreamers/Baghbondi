package NewBaghbondi;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class SceneBuilder {

    Label label;
    Button buttonOne;
    Button buttonTwo;
    VBox vBox;

    protected void createMenuSceneElements(int space){
        label = createLabel();
        buttonOne = createButton();
        buttonTwo = createButton();
        vBox = createVBox(label, space, buttonOne, buttonTwo);
    }

    protected Scene createScene(){
        return new Scene(vBox, 950, 650);
    }

    private Label createLabel(){
        Label label= new Label();
        label.setFont(new Font("Arial", 14));
        return label;
    }

    protected VBox createVBox(Label label, int space, Button buttonOne, Button buttonTwo){
        VBox vBox= new VBox(space);
        vBox.setBackground(setBackgroundPicture("resources/backGroundPicture.png"));
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(label, buttonOne, buttonTwo);
        return vBox;
    }

    protected Button createButton(){
        return new Button();
    }

    protected Background setBackgroundPicture(String string){
        Image image = new Image(string, 950, 650, false, false, true);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        return new Background(backgroundImage);
    }
}
