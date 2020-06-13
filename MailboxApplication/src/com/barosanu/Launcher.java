package com.barosanu;

import com.barosanu.controller.persistence.PersistenceAccess;
import com.barosanu.controller.persistence.ValidAccount;
import com.barosanu.controller.services.LoginService;
import com.barosanu.model.EmailAccount;
import com.barosanu.view.ViewFactory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Launcher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private PersistenceAccess persistenceAccess = new PersistenceAccess();
    private EmailManager emailManager = new EmailManager();

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
        //ViewFactory viewFactory = new ViewFactory(new EmailManager());
        //viewFactory.showOptionsWindow();
        //viewFactory.showLoginWindow();
        //viewFactory.showMainWindow();
        //viewFactory.updateStyles();
        ViewFactory viewFactory = new ViewFactory(emailManager);
        List<ValidAccount> validAccountList = persistenceAccess.loadFromPersistence();
        if(validAccountList.size() > 0) {
            viewFactory.showMainWindow();
            for (ValidAccount validAccount: validAccountList){
                EmailAccount emailAccount = new EmailAccount(validAccount.getAddress(), validAccount.getPassword());
                LoginService loginService = new LoginService(emailAccount, emailManager);
                loginService.start();
            }
        } else {
            viewFactory.showLoginWindow();
        }
    }

    @Override
    public void stop() throws Exception {
        List<ValidAccount> validAccountList = new ArrayList<ValidAccount>();
        for (EmailAccount emailAccount: emailManager.getEmailAccounts()){
            validAccountList.add(new ValidAccount(emailAccount.getAddress(), emailAccount.getPassword()));
        }
        persistenceAccess.saveToPersistence(validAccountList);

    }
}
