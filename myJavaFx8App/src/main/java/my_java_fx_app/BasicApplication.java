package my_java_fx_app;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import my_java_fx_app.view.BasicFXMLController;

public class BasicApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        
    	FXMLLoader loader = new FXMLLoader();
    	loader.setController(new BasicFXMLController());
    	URL xmlUrl = getClass().getResource("/fxml/BasicFXML.fxml");
    	loader.setLocation(xmlUrl);
    	Parent root = loader.load();

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
