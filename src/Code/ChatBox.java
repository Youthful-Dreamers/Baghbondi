import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ChatBox {

    private TextArea messages;
    private TextField input;

    protected ChatBox(){
        messages = createTextArea();
        input= createTextField();
    }

    private TextArea createTextArea() {
        TextArea textArea = new TextArea();

        textArea.setPrefSize(250, 560);
        textArea.setLayoutX(675);
        textArea.setLayoutY(10);

        return textArea;
    }

    private TextField createTextField(){
        TextField textField = new TextField();

        textField.setPrefSize(250, 50);
        textField.setLayoutX(675);
        textField.setLayoutY(590);

        return textField;
    }


    public TextArea getMessages() {
        return messages;
    }

    public TextField getInput() {
        return input;
    }
}
