package code;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ClientServerSelectionScene {

    private SceneBuilder sceneBuilder;
    private RadioButton radioButtonClient;
    private RadioButton radioButtonServer;
    private Label label;
    private VBox vBox;
    private int languageOption;
    private Scene clientServerSelectionScene;
    private Button buttonSubmit;


    protected ClientServerSelectionScene(int languageOption){
        this.languageOption = languageOption;
        sceneBuilder = new SceneBuilder();
        creatingClientServerSelectionScene();
    }


    protected void createLabel(){
        label = sceneBuilder.createLabel(30);
        label.setLayoutX(435);
        label.setLayoutY(300);
        label.setTextFill(Color.web("#003300", 1));
        if(languageOption == 1) label.setText("নিচে থেকে একটি পছন্দ করুনঃ");
        else label.setText("Choose one from below:");
    }

    private RadioButton createRadioButton(String string, ToggleGroup toggleGroup){
        RadioButton radioButton = new RadioButton(string);
        radioButton.setFont(Font.font("Aerial", FontWeight.BOLD, 15));
        radioButton.setStyle("-fx-font-size:17; -fx-background-color: #006400; -fx-text-fill: white; -fx-font-weight: bold;");
        radioButton.setToggleGroup(toggleGroup);
        return radioButton;
    }

    private void createRadioButtonGroupClientServerSelection(){
        ToggleGroup toggleGroup = new ToggleGroup();
        if(languageOption == 1) radioButtonClient = createRadioButton("ক্যায়েন্ট", toggleGroup);
        else  radioButtonClient = createRadioButton("Client", toggleGroup);
        if(languageOption == 1) radioButtonServer = createRadioButton("সার্ভার", toggleGroup) ;
        else radioButtonServer = createRadioButton("Server", toggleGroup);
    }

    private void createSubmitButton(){
        buttonSubmit = sceneBuilder.createButton();
        if(languageOption == 1) buttonSubmit.setText("সাবমিট");
        else buttonSubmit.setText("Submit");
    }

    protected void createVBoxForClientServerSelection(){
        vBox = new VBox(5);
        vBox.setBackground(sceneBuilder.setBackgroundPicture("resources/gameStartScene.png"));
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(label, radioButtonClient, radioButtonServer, buttonSubmit);
    }

    protected void creatingClientServerSelectionScene(){
        createLabel();
        createRadioButtonGroupClientServerSelection();
        createSubmitButton();
        createVBoxForClientServerSelection();
        clientServerSelectionScene = new Scene(vBox, 950, 650);
    }

    protected void eventHandlerForRadioButton(Stage stage, ClientScene clientScene){
        if(radioButtonClient.isSelected()){
            stage.setScene(clientScene.getClientScene());
        } else if(radioButtonServer.isSelected()){

        }
    }

    protected void buttonEventHandler(Stage stage, ClientScene clientScene){
        buttonSubmit.setOnMouseClicked(e-> eventHandlerForRadioButton(stage, clientScene));
    }

    protected Scene getClientServerSelectionScene(){
        return clientServerSelectionScene;
    }

}