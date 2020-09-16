package NewBaghbondi;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{


    @Override
    public void start(Stage primaryStage){
        Menu mainMenu = new Menu(primaryStage);
        primaryStage.setScene(mainMenu.createSceneLanguageOption());
        primaryStage.setTitle("BaghBondi");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
