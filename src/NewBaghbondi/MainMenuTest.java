package NewBaghbondi;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;

public class MainMenuTest extends Application {



            @Override
            public void start(Stage primaryStage) throws Exception {
                Stage boardStage = new Stage();

                Menu mainMenu = new Menu(boardStage);
                boardStage.setScene(mainMenu.createMainScene());
                boardStage.setTitle("BaghBondi");
                boardStage.show();

            }
        };
