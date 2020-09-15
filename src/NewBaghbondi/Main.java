package NewBaghbondi;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{


    @Override
    public void start(Stage primaryStage){
        Stage boardStage = new Stage();
        Menu mainMenu = new Menu(boardStage);
        boardStage.setScene(mainMenu.createSceneLanguageOption());
        boardStage.setTitle("BaghBondi");
        boardStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
