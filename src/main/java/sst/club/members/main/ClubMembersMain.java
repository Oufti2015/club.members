package sst.club.members.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lombok.extern.log4j.Log4j2;
import sst.club.members.controllers.MainController;

import java.io.IOException;
import java.net.URL;

@Log4j2
public class ClubMembersMain extends Application {
    private static final String VIEWS_MAIN_FXML = "/Main.fxml";
    private Stage primaryStage;

    public static void main(String[] args) {
        log.info("+----------------------------------------------------------------------------------------------+");
        log.info("|----O-U-F-T-I----B-A-N-K----------------------------------------------------------------------|");
        log.info("+----------------------------------------------------------------------------------------------+");

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        log.info("Starting...");
        // set title
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Club members");

        initRootLayout();
        primaryStage.setMaximized(true);

    }

    /**
     * Initializes the root layout.
     */
    private void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader;
            loader = new FXMLLoader();
            URL resource = ClubMembersMain.class.getResource(VIEWS_MAIN_FXML);
            loader.setLocation(resource);
            VBox rootLayout = loader.load();

            MainController controller = loader.getController();
            controller.setOwner(this);

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            log.fatal("Cannot load " + VIEWS_MAIN_FXML + " : ", e);
        }
    }
}
