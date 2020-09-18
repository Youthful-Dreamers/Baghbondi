package code;

import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class DrawClock {

    private int playerIndicator;
    private int languageOption;

    private Text clockText;
    private StackPane clockStackPane;
    private Group clockGroup = new Group();

    public DrawClock(int languageOption, int playerIndicator, double layoutX, double layoutY, Color clockColor) {
        this.languageOption = languageOption;
        this.playerIndicator = playerIndicator;
        clockText = createClockText(layoutX, layoutY, clockColor);
        setInitialClockText();
    }

    private Text createClockText(double layoutX, double layoutY, Color clockColor) {
        Text clockText = new Text();
        clockText.setLayoutX(layoutX);
        clockText.setLayoutY(layoutY);
        clockText.setFont(Font.font("Agency FB", FontWeight.BOLD, 28));
        clockText.setFill(clockColor);
        return clockText;
    }

    public void setInitialClockText() {
        if(languageOption == 1){
            if(playerIndicator==1) clockText.setText("বাঘঃ"+"লিমিটেড");
            else clockText.setText("ছাগলঃ"+"লিমিটেড");
        }
        else {
            if(playerIndicator==1) clockText.setText("Tiger:"+"Limited");
            else clockText.setText("Goat:"+"Limited");
        }
        clockGroup.getChildren().addAll(clockText);
    }

    protected Text getClockText() { return clockText; }
    protected Group getClockGroup(){
        return  clockGroup;
    }
}
