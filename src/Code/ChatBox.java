package code;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ChatBox {

    private TextArea messages;
    private TextField input;
    private Label messagesLabel;
    private Label inputLabel;
    private int languageOption;
    private Rectangle messagesLabelBackGround;
    private Rectangle inputLabelBackGround;

    protected ChatBox(int languageOption, Pane paneOfGame){
        this.languageOption = languageOption;
        createLabels();
        createBackGrounds();
        messages = createTextArea();
        input= createTextField();
        paneOfGame.getChildren().addAll(messagesLabelBackGround, messages, inputLabelBackGround, input);
        paneOfGame.getChildren().addAll(messagesLabel, inputLabel);
    }

    private TextArea createTextArea() {
        TextArea textArea = new TextArea();
        textArea.setPrefSize(250, 500);
        textArea.setLayoutX(675);
        textArea.setLayoutY(40);
        return textArea;
    }

    private TextField createTextField(){
        TextField textField = new TextField();
        textField.setPrefSize(250, 50);
        textField.setLayoutX(675);
        textField.setLayoutY(580);
        return textField;
    }

    private void createLabels(){
      messagesLabel = createLabel("মেসেজেসঃ ", "Messages", 679, 10 );
      inputLabel = createLabel("ইনপুটঃ", "Input", 679, 545);
    }

    private Label createLabel(String stringOne, String stringTwo, double X, double Y){
        Label label = new Label();
        if(languageOption == 1) label.setText(stringOne);
        else label.setText(stringTwo);
        label.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        label.setTextFill(Color.web("#ffff00", 1));
        label.setLayoutX(X);
        label.setLayoutY(Y);
        return label;
    }

    private void createBackGrounds(){
        messagesLabelBackGround = new Rectangle(675, 10, 140, 30);
        messagesLabelBackGround.setFill(Color.web("#003300", 1));
        messagesLabelBackGround.setOpacity(0.3);
        inputLabelBackGround = new Rectangle(675,543, 90, 35);
        inputLabelBackGround.setFill(Color.web("#003300", 1));
        inputLabelBackGround.setOpacity(0.6);
    }

    protected void inputEventHandlerServer(Client connectionClient, Server connectionServer, boolean isServer){
        input.setOnAction(e->{
            String message = isServer ? "Player1: " : "Player2: ";
            message += input.getText();
            input.clear();
            clientServerManagement(connectionClient, connectionServer, message, isServer);
        });
    }

    private void clientServerManagement(Client connectionClient, Server connectionServer, String message, boolean isServer){
        if(isServer){
            if(connectionServer ==null) System.out.println(true);
            messages.appendText(message +"\n");
            try {
                connectionServer.send(message);
            } catch (Exception e) {
                messages.appendText("Failed to send! \nPlease check if both have followed the instructions properly\nOr restart both\n"+ e +"\n");
            }
        } else {
            if(connectionClient ==null) System.out.println(true);
            messages.appendText(message +"\n");
            try {
                connectionClient.send(message);
            } catch (Exception e) {
                messages.appendText("Failed to send! \nPlease check if both have followed the instructions properly\nOr restart both\n"+ e +"\n");
            }
        }
    }

    public TextArea getMessages(){ return messages; }
    public TextField getInput(){ return  input; }
    public Label getMessagesLabel(){ return messagesLabel; }
    public Label getInputLabel() { return inputLabel; }
    public Rectangle getMessagesLabelBackGround() { return messagesLabelBackGround; }
    public Rectangle getInputLabelBackGround() { return  inputLabelBackGround; }
}
