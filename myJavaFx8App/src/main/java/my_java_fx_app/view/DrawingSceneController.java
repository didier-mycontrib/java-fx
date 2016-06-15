package my_java_fx_app.view;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class DrawingSceneController {

	/*
	 * // Reference to the main application: private MyJavaFx8App mainApp;
	 * 
	 * 
	 * public void setMainApp(MyJavaFx8App mainApp) { this.mainApp = mainApp; }
	 */
	@FXML
	private Label lblCoords;
	
	@FXML
	private ColorPicker colorPickerLine;
	
	private ObjectProperty<Color> lineColorProperty = new SimpleObjectProperty<Color>() ;
	
	@FXML
	private ColorPicker colorPickerFill;
	
	private ObjectProperty<Color> fillColorProperty = new SimpleObjectProperty<Color>() ;
	
	
	@FXML
	private ComboBox<String> comboBoxShape;
	
	private ObservableList<String> shapeTypes = 
		    FXCollections.observableArrayList(
		        "LINE",
		        "RECTANGLE",
		        "CIRCLE"
		    );
	
	private StringProperty selectedShapeTypeProperty = new SimpleStringProperty() ;
	
	private Shape currentShape=null; //javafx.scene.shape.Shape
	
	@FXML
	private Pane drawingPane;

	@FXML
	private void handleUndo() {
		if(currentShape!=null){
			drawingPane.getChildren().remove(currentShape);
			currentShape=null;
		}
	}
	
	@FXML
	private void handleClearAll() {
		drawingPane.getChildren().clear();
		currentShape=null;
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		comboBoxShape.setItems(shapeTypes);
		selectedShapeTypeProperty.bindBidirectional(comboBoxShape.valueProperty());
		selectedShapeTypeProperty.setValue("LINE");//by default
		
		lineColorProperty.bindBidirectional(colorPickerLine.valueProperty());
		lineColorProperty.setValue(Color.BLACK);//by default
		
		fillColorProperty.bindBidirectional(colorPickerFill.valueProperty());
		fillColorProperty.setValue(Color.WHITE);//by default
		
		lblCoords.setText("0,0");

		
		
		
		drawingPane.setOnMousePressed(new EventHandler<MouseEvent>(){

		    public void handle(MouseEvent me){

		    	lblCoords.setText("x="+me.getX()+",y="+me.getY());
		    	initShape(me.getX(),me.getY());
		    }

		});
		
		drawingPane.setOnMouseReleased(new EventHandler<MouseEvent>(){

		    public void handle(MouseEvent me){

		    	lblCoords.setText("x="+me.getX()+",y="+me.getY());
		    	updateShapeSize(me.getX(),me.getY());
		    }

		});
		
		drawingPane.setOnMouseDragged(new EventHandler<MouseEvent>(){

		    public void handle(MouseEvent me){

		    	lblCoords.setText("x="+me.getX()+",y="+me.getY());
		    	updateShapeSize(me.getX(),me.getY());
		    }

		});
		
		drawingPane.setOnMouseMoved(new EventHandler<MouseEvent>(){
		    public void handle(MouseEvent me){
		    	lblCoords.setText("x="+me.getX()+",y="+me.getY());
		    }
		});
	
	}
	
	private void initShape(double x,double y){
		switch(this.selectedShapeTypeProperty.get()){
			case "LINE":
				Line line= new Line();
				this.currentShape = line;
				line.setStartX(x);
				line.setStartY(y);
				line.setEndX(x);
				line.setEndY(y);
				break;
			case "RECTANGLE":
				Rectangle rectangle = new Rectangle();
				this.currentShape =rectangle;
				rectangle.setX(x);
				rectangle.setY(y);
				rectangle.setWidth(0);
				rectangle.setHeight(0);
				break;
			case "CIRCLE":
				Circle circle = new Circle();
				this.currentShape = circle;
				circle.setCenterX(x);
				circle.setCenterY(y);
				circle.setRadius(0);
				break;
		}
		this.currentShape.setFill(this.fillColorProperty.get());
		this.currentShape.setStroke(this.lineColorProperty.get());
		this.currentShape.setStrokeWidth(1);
		drawingPane.getChildren().add(currentShape);
	}
	
    private void updateShapeSize(double x,double y){
    	switch(this.selectedShapeTypeProperty.get()){
		case "LINE":
			Line line= (Line) this.currentShape;
			line.setEndX(x);
			line.setEndY(y);
			break;
		case "RECTANGLE":
			Rectangle rectangle = (Rectangle)this.currentShape;
			rectangle.setWidth(x-rectangle.getX());
			rectangle.setHeight(y-rectangle.getY());
			break;
		case "CIRCLE":
			Circle circle = (Circle)this.currentShape;
			circle.setRadius(Math.sqrt( Math.pow(x-circle.getCenterX(),2) + Math.pow(y-circle.getCenterY(),2)));
			break;
	}
	}

}
