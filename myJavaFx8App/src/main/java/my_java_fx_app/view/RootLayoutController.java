package my_java_fx_app.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import my_java_fx_app.MyJavaFx8App;

public class RootLayoutController {
	

	// Reference to the main application:
    private MyJavaFx8App mainApp;

   
    public void setMainApp(MyJavaFx8App mainApp) {
        this.mainApp = mainApp;
    }
    
    @FXML //with fx:id="lblMessage" in RootLayout.fxml
    public Label lblMessage;
    
  
    @FXML
    private void handleAbout() {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("MyJavaFx8App");
    	alert.setHeaderText("About");
    	alert.setContentText("Author: Didier Defrance");
    	alert.showAndWait();
    	lblMessage.setText("javaFx app");
    }

    @FXML
    private void handleExit() {
    	//System.out.println("exit ...");
        System.exit(0);
    }
    
    @FXML
    private void handleDisplayConverterScene() {
    	lblMessage.setText("conversion entre euros et francs");
    	mainApp.showSimpleConverterForm();
    }
    
    @FXML
    private void handleDisplayDrawingScene() {
    	lblMessage.setText("drawing javaFx , SVG, ...");
    	mainApp.showDrawingScene();
    }
    
    @FXML
    private void handleDisplayPersonScene() {
    	lblMessage.setText("person data form");
    	mainApp.showPersonScene();
    }
    
    @FXML
    private void handleDisplayOtherScene() {
    	lblMessage.setText("other javaFx scene ...");
    	//mainApp.showOther();
    }
    
}
