package my_java_fx_app.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import my_java_fx_app.data.Person;
import my_java_fx_app.model.PersonFxModel;

public class PersonFormController {
	
	/*
	// Reference to the main application:
    private MyJavaFx8App mainApp;

   
    public void setMainApp(MyJavaFx8App mainApp) {
        this.mainApp = mainApp;
    }
    */
	
	@FXML
	private TextField txtFieldFirstName; 
	
	@FXML 
	private TextField txtFieldLastName; 
	
	@FXML 
	private TextField txtFieldEmail; 
	
	@FXML 
	private TextField txtFieldPhoneNumber; 
	
	@FXML
	private Label lblPersonData;
	
	private PersonFxModel personFxModel = new PersonFxModel();
	
	
	
	 
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	
		Person person = new Person("alex" , "Therieur");
		person.setEmail("alex.therieur@la-bas.fr");
		person.setPhoneNumber("0102030405");
		personFxModel.setPerson(person);
		
				
		
    	txtFieldFirstName.textProperty().bindBidirectional(personFxModel.getFirstNameProperty());
    	txtFieldLastName.textProperty().bindBidirectional(personFxModel.getLastNameProperty());
    	txtFieldEmail.textProperty().bindBidirectional(personFxModel.getEmailProperty());
    	txtFieldPhoneNumber.textProperty().bindBidirectional(personFxModel.getPhoneNumberProperty());
    	
    }
    
    @FXML
    public void handleExtractPersonData(){
    
    	//personFxModel.getLastNameProperty().set(personFxModel.getLastNameProperty().get()+"*");
    	lblPersonData.setText(personFxModel.getPerson().toString());
 
    }
    
   
  

}
