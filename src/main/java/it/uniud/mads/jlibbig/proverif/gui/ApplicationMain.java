package it.uniud.mads.jlibbig.proverif.gui;

import it.uniud.mads.jlibbig.proverif.gui.constants.Constants;
import it.uniud.mads.jlibbig.proverif.gui.pages.home.layout.HomeScene;
import it.uniud.mads.jlibbig.proverif.gui.widget.ConfirmBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ApplicationMain extends Application {

    Stage window;
    Scene homeScene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Application Windows
        window = primaryStage;
        window.setTitle("Proverif");
        window.setMinWidth(Constants.getSceneminwidth());
        window.setMinHeight(Constants.getSceneminheight());
        window.setOnCloseRequest(e -> {
            e.consume(); // Consume close event and then run close method
            closeApplication();
        });
        // Home Scene
        homeScene = HomeScene.home(window);
        // Prova CSS
        // homeScene.getStylesheets().add("Viper.css");
        // homeScene.getStylesheets().add(getClass().getResource("style/Viper.css").toExternalForm());
        
        window.setScene(homeScene);
        window.show();
    }

    private void closeApplication() {
        boolean answer = ConfirmBox.display("Exit", "Sure you want to exit?");
        if (answer)
            window.close();
    }
}
