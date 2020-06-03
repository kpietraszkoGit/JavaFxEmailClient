package com.barosanu;

import com.barosanu.view.ViewFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        /*Button button = new Button("Click!");//tworzenie przycisku jak naciśniemy przycisk pojawi nam sie w konsoli
        // button clicked
        button.setOnAction(e -> {
            System.out.println("Button clicked!");
        });

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(button);//dodanie przycisku do okienka stosu*/

        //Parent parent = FXMLLoader.load(getClass().getResource("view/MainWindow.fxml"));

        //Scene scene = new Scene(stackPane, 300, 250);//wymiar okienka
        //Scene scene = new Scene(parent, 396, 391);
        //Scene scene = new Scene(parent);
        //stage.setScene(scene);//etap sceny okienka

        //stage.show();//etap pokazanie okienka z przyciskiem
        ViewFactory viewFactory = new ViewFactory(new EmailManager());
        //viewFactory.showOptionsWindow();
        viewFactory.showLoginWindow();
        //viewFactory.showMainWindow();
        viewFactory.updateStyles();

    }
}
