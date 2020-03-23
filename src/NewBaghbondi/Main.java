package NewBaghbondi;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{


    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage boardStage = new Stage();
        Menu mainMenu = new Menu(boardStage);
        boardStage.setScene(mainMenu.createMainScene());
        boardStage.setTitle("BaghBondi");
        boardStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
