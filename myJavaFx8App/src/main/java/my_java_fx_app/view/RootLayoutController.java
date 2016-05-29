package my_java_fx_app.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import my_java_fx_app.MyJavaFx8App;

public class RootLayoutController {
	
	// Reference to the main application:
    private MyJavaFx8App mainApp;

   
    public void setMainApp(MyJavaFx8App mainApp) {
        this.mainApp = mainApp;
    }
    
  
    @FXML
    private void handleAbout() {
    	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("MyJavaFx8App");
    	alert.setHeaderText("About");
    	alert.setContentText("Author: Didier Defrance");
    	alert.showAndWait();
    }

    @FXML
    private void handleExit() {
    	System.out.println("exit ...");
        System.exit(0);
    }
    
    @FXML
    private void handleSaveAs() {
        //mainApp..
        System.out.println("saveAs ...");
    }
    
    @FXML
    private void handleOpen() {
        //mainApp..
        System.out.println("open ...");
    }

}
