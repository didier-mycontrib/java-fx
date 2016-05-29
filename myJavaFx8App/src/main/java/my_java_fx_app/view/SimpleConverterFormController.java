package my_java_fx_app.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SimpleConverterFormController {
	
	/*
	// Reference to the main application:
    private MyJavaFx8App mainApp;

   
    public void setMainApp(MyJavaFx8App mainApp) {
        this.mainApp = mainApp;
    }
    */
	
	@FXML //with fx:id="txtMontant" in SimpleConverterForm.fxml
	private TextField txtMontant; 
	
	@FXML //with fx:id="txtMontant" in SimpleConverterForm.fxml
	private Label lblResultatConversion; 
    
  
    @FXML
    private void handleEuroToFranc() {
    	//System.out.println("euroToFrancs ..");
    	double montantEuro = Double.parseDouble(txtMontant.getText());
    	double montantFranc = montantEuro * 6.55957;
    	//System.out.println("montantEuro=" + montantEuro);
    	//System.out.println("montantFranc=" + montantFranc);
    	lblResultatConversion.setText(String.valueOf(montantFranc));
    }

}
