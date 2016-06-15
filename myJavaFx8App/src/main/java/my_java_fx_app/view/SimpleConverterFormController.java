package my_java_fx_app.view;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class SimpleConverterFormController {
	
	/*
	// Reference to the main application:
    private MyJavaFx8App mainApp;

   
    public void setMainApp(MyJavaFx8App mainApp) {
        this.mainApp = mainApp;
    }
    */
	
	@FXML //with fx:id="txtFieldMontant" in SimpleConverterForm.fxml
	private TextField txtFieldMontant;
	
	private StringProperty strMontantProp = new SimpleStringProperty() ;
	private DoubleProperty dMontantProp = new SimpleDoubleProperty() ;

	
	@FXML //with fx:id="lblResConvFranc" in SimpleConverterForm.fxml
	private Label lblResConvFranc; 
	
	@FXML //with fx:id="lblResConvDollar" in SimpleConverterForm.fxml
	private Label lblResConvDollar; 
	
	private StringProperty strResConvProp = new SimpleStringProperty() ;
	private DoubleProperty dResConvProp = new SimpleDoubleProperty() ;
	
	@FXML
	private void initialize() {
		
		StringConverter<Number> converter = new NumberStringConverter();
		Bindings.bindBidirectional(strMontantProp,dMontantProp, converter);
		Bindings.bindBidirectional(strResConvProp,dResConvProp, converter);
		
		//proprieteASynchroniser.bind(proprieteSource)
		
		strMontantProp.bind(txtFieldMontant.textProperty()); //ok but as String
		//txtMontant.textProperty().bindBidirectional(strMontantProp); //OK  mais attention au perf , au contexte
	
		
		dResConvProp.bind(dMontantProp.multiply(6.55957));
		
		lblResConvFranc.textProperty().bind(strResConvProp);
		
		//ENTIEREMENT AUTOMATIQUE (MEME PLUS BESOIN d'APPUYER SUR UN BOUTON) pour convertir euro en franc
	}
    
  
    @FXML
    private void handleEuroToDollar() {
    	//code ici volontairement sans "property" :
    	double montantEuro = Double.parseDouble(txtFieldMontant.getText());
    	double montantDollar = montantEuro * 1.2;
    	lblResConvDollar.setText(String.valueOf(montantDollar));
    	
    	
    	
    }

}
