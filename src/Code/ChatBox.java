package code;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

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

    protected void inputEventHandlerClient(PrintWriter pw, BufferedReader br){
        input.setOnAction(e->{
           String inputString, friendMessage;
           inputString = "Me: "+ input.getText();
           pw.println(inputString);
           pw.flush();
           input.clear();
           messages.appendText(inputString+"\n");
            try {
                friendMessage = br.readLine();
                friendMessage = "Friend: "+friendMessage;
                messages.appendText(friendMessage);
            } catch (IOException ex) {
                System.out.println("Can't receive friend's text");
            }
        });
    }

    protected void inputEventHandlerServer(PrintWriter pw, BufferedReader br){
        String inputString, friendMessage;
        inputString = "Me: "+ input.getText();
        pw.println(inputString);
        pw.flush();
        input.clear();
        messages.appendText(inputString+"\n");
        try {
            friendMessage = br.readLine();
            friendMessage = "Friend: "+friendMessage;
            messages.appendText(friendMessage);
        } catch (IOException ex) {
            System.out.println("Can't receive friend's text");
        }
    }


    public TextArea getMessages() {
        return messages;
    }
    public TextField getInput() {
        return input;
    }
}
