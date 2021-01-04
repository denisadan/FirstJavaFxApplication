package sample.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.service.UserService;

public class Main extends Application {

    UserService userService = new UserService();

    public static void main(String[] args) {
        System.out.println("Launching...");
        launch();
    }

    @Override
    public void init() throws Exception {
        System.out.println("Initalising...");
    }

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println("Starting...");

        stage.setTitle("Hello world!");
        stage.setHeight(400);
        stage.setWidth(600);

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        gridPane.setAlignment(Pos.CENTER);

        Label userLabel = new Label("Username: ");
        TextField userField = new TextField();

        Label passwordLabel = new Label("Password: ");
        TextField passwordField = new PasswordField();

        Button loginButton = new Button("Login");

        Text loginSuccess = new Text("Login success!");
        loginSuccess.setVisible(false);

        Text loginFailed = new Text("Login failed!");
        loginFailed.setVisible(false);

        GridPane allUsers = new GridPane();
        Text user1 = new Text("Mircea");
        Text user2 = new Text("Ion");
        Text user3 = new Text("Liviu");
        Text user4 = new Text("Sorin");

        allUsers.add(user1, 0, 1);
        allUsers.add(user2, 0, 2);
        allUsers.add(user3, 0, 3);
        allUsers.add(user4, 0, 4);

        allUsers.setPadding(new Insets(25, 25, 25, 25));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Scene loginScene = new Scene(gridPane, 300, 275);

        Button backButton = new Button("Back");
        allUsers.add(backButton, 0, 5);

        backButton.setOnMouseClicked(mouseEvent ->
        {
            stage.setScene(loginScene);
        });
        Scene adminScene = new Scene(allUsers, 300, 275);

        loginButton.setOnMouseClicked(mouseEvent -> {
            // if userField == getUserFromDb && PasswordField == getPassFromDb => success else 'Login Failed'
            // userService.findById();
            if (userField.getText().equalsIgnoreCase("denisa")) {
                loginSuccess.setVisible(true);
                loginFailed.setVisible(false);

                stage.setScene(adminScene);

            } else {
                loginSuccess.setVisible(false);
                loginFailed.setVisible(true);
            }
        });


        gridPane.add(userLabel, 0, 1);
        gridPane.add(userField, 1, 1);
        gridPane.add(passwordLabel, 0, 2);
        gridPane.add(passwordField, 1, 2);
        gridPane.add(loginButton, 1, 3);
        gridPane.add(loginSuccess, 2, 3);
        gridPane.add(loginFailed, 2, 3);

        stage.setScene(loginScene);


        stage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Closing...");
    }
}
