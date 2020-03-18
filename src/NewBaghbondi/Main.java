package NewBaghbondi;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application{

    Button button;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        new BoardStage().boardStage();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
