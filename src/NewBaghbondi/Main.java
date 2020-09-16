package NewBaghbondi;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{


    @Override
    public void start(Stage primaryStage){
        LanguageOptionScene mainLanguageOptionScene = new LanguageOptionScene(primaryStage);
        primaryStage.setScene(mainLanguageOptionScene.getLanguageOptionScene());
        primaryStage.setTitle("BaghBondi");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
