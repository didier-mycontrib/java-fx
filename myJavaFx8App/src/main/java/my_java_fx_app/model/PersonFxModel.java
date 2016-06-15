package my_java_fx_app.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import my_java_fx_app.data.Person;

//javaFx Model (wrapper for data.Person)
public class PersonFxModel {
	
	private Person person;
	
	private final StringProperty firstNameProperty = new SimpleStringProperty();
    private final StringProperty lastNameProperty = new SimpleStringProperty();
    private final StringProperty emailProperty = new SimpleStringProperty();
    private final StringProperty phoneNumberProperty = new SimpleStringProperty();

	public Person getPerson() {
		retreiveValuesFromProperties();
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
		initPropertiesFromData();
	}
	
	private void initPropertiesFromData(){
		if(person==null) {
			person = new Person();
		}
		firstNameProperty.set(person.getFirstName());
		lastNameProperty.set(person.getLastName());
		emailProperty.set(person.getEmail());
		phoneNumberProperty.set(person.getPhoneNumber());
	}
	
	private void retreiveValuesFromProperties(){
		if(person==null) {
			person = new Person();
		}
		person.setFirstName(firstNameProperty.getValue());
		person.setLastName(lastNameProperty.getValue());
		person.setEmail(emailProperty.getValue());
		person.setPhoneNumber(phoneNumberProperty.getValue());
	}

	public StringProperty getFirstNameProperty() {
		return firstNameProperty;
	}

	public StringProperty getLastNameProperty() {
		return lastNameProperty;
	}

	public StringProperty getEmailProperty() {
		return emailProperty;
	}

	public StringProperty getPhoneNumberProperty() {
		return phoneNumberProperty;
	}
	
	
	

}
