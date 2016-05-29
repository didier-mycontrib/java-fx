package my_java_fx_app;



import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import my_java_fx_app.view.RootLayoutController;

/*
 * http://download.eclipse.org/efxclipse/updates-released/2.3.0/site/ plugin-eclipse pour javaFx
 * http://docs.oracle.com/javase/8/javafx/api/ javadoc de javaFx
 */

//@SuppressWarnings("restriction")//pour eviter warning access a javaFx 
//integre dans partie "ext" de java8 si pas de plugin efxclipse dans eclipse
public class MyJavaFx8App extends Application {
	
	private BorderPane rootLayout=null;
    
	public static void main(String[] args) {
	        launch(args);
	    }
	
    @Override
    public void start(Stage primaryStage) {
    	
    	 // Load root layout from fxml file.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(MyJavaFx8App.class
                .getResource("view/RootLayout.fxml"));
        
		try {
			rootLayout = (BorderPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Give the controller access to the main app.
        RootLayoutController controller = loader.getController(); //fx:controller attribute in RootLayout.fxml
        controller.setMainApp(this);
    	
    	// StackPane root = new StackPane();
    	// Scene scene = new Scene(root, 500, 400);
        Scene scene = new Scene(rootLayout); //size in RootLayout.fxml
         primaryStage.setTitle("My javaFx App / java8");
         primaryStage.setScene(scene);
         primaryStage.show();
         
         showSimpleConverterForm();
    }
    
    public void showSimpleConverterForm() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource("view/SimpleConverterForm.fxml"));
            AnchorPane simpleFormPane = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(simpleFormPane);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
   

}

