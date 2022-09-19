package my_java_fx_app;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class HelloWorldJavaFx8App extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        Label labelMessage = new Label();
        /*
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        */
        //btn.setOnAction((ActionEvent event)->{System.out.println("Hello World!");});
        btn.setOnAction((ActionEvent event)->{labelMessage.setText("Hello World!");});
        
        VBox root = new VBox(10); // Create the VBox with a 10px spacing
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(btn);
        root.getChildren().add(labelMessage);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 public static void main(String[] args) {
        launch(args);
    }
}

