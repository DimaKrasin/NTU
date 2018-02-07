
import Entity.User;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignInUp {

    private ResultSet resultSet = null;
    private User user = new User();

    public void startSignInUp(Stage stage, AnchorPane root, Statement statement) {

        TextField textFieldLogin = Utils.createTextField(root, 220, 150);

        TextField textFieldPassword = Utils.createTextField(root, 220, 190);

        //Sing in Button
        Button btnSignIn = Utils.createButton(root, "Sign in", 217, 230);

        //Sign up Button
        Button btnSignUp = Utils.createButton(root, "Sign up", 303, 230);

        //Sing in Button action
        btnSignIn.setOnAction(event -> {

            try {
                resultSet = statement.executeQuery("SELECT * FROM users WHERE " +
                        "login = '" + textFieldLogin.getText() + "' AND password = '" + textFieldPassword.getText() + "'");
                if (resultSet.first()) {
                    user.setId(resultSet.getInt(1));
                    user.setLogin(resultSet.getString(2));
                    user.setPassword(resultSet.getString(3));
                    user.setEmail(resultSet.getString(4));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            System.out.println("Selected user ID = " + user.getId());
            callMaimMenu(stage, root, statement, user);
        });

        //Sing up Button action
        btnSignUp.setOnAction(event -> {
            signUpMenu(stage, root,statement);
        });

        //css

        //css (buttons)
        btnSignIn.setPrefSize(70,20);
        btnSignUp.setPrefSize(70,20);

        //css(root)
        root.setStyle("-fx-background-color: #58ACFA");

        //css (Login TextField)
        textFieldLogin.setPromptText("login");
        textFieldLogin.setStyle("-fx-background-color: black , #58ACFA, #58ACFA;" +
                "-fx-background-insets: 0 -1 -1 -1, 0 0 0 0, 0 -1 3 -1;" +
                "-fx-border-radius: 0 0 0 0;" +
                "-fx-background-radius: 0 0 0 0;" +
                "-fx-prompt-text-fill: white");

        //css (Password TextField)
        textFieldPassword.setPromptText("password");
        textFieldPassword.setStyle("-fx-background-color: black , #58ACFA, #58ACFA;" +
                "-fx-background-insets: 0 -1 -1 -1, 0 0 0 0, 0 -1 3 -1;" +
                "-fx-border-radius: 0 0 0 0;" +
                "-fx-background-radius: 0 0 0 0;"+
                "-fx-prompt-text-fill: white");
    }

    private void signUpMenu(Stage owner, AnchorPane rootGeneral,Statement statement) {

        //Создаем новую сцену и Pane
        Stage dialogStage = new Stage();
        dialogStage.setTitle("signUpMenu");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(owner);

        AnchorPane root = new AnchorPane();

        //Наполняем Pane
        Label labelLogin = Utils.craeteLabel(root,"Введите логин:",100,30,55,50);
        TextField textFieldLogin = Utils.createTextField(root, 165, 50);

        Label labelPassword1 = Utils.craeteLabel(root,"Введите пароль:",100,30,55,110);
        TextField textFieldPassword1 = Utils.createTextField(root, 165, 110);

        Label labelPassword2 = Utils.craeteLabel(root,"Повторите:",100,30,55,150);
        TextField textFieldPassword2 = Utils.createTextField(root, 165, 150);

        Label labelEmail = Utils.craeteLabel(root,"Введите email:",100,30,55,210);
        TextField textFieldEmail = Utils.createTextField(root, 165, 210);

        Button btnSignUp = Utils.createButton(root, "Start!", 325, 260);
        btnSignUp.setPrefSize(70,25);

        Button btnExit = Utils.createButton(root, "Exit", 235, 260);
        btnExit.setPrefSize(70,25);

        //btnSignUp action
        btnSignUp.setOnAction(event -> {
            try {
                //Добавляем в бд нового
                statement.executeUpdate("INSERT INTO users (login, password,email) VALUES " +
                        "('" + textFieldLogin.getText() +
                        "','" + textFieldPassword1.getText() +
                        "','" + textFieldEmail.getText() + "')");

                //берем из бд уже с id
                resultSet = statement.executeQuery("SELECT * FROM users WHERE " +
                        "login = '" + textFieldLogin.getText() + "' AND password = '" + textFieldPassword1.getText() + "'");

                if (resultSet.first()) {
                    user.setId(resultSet.getInt(1));
                    user.setLogin(resultSet.getString(2));
                    user.setPassword(resultSet.getString(3));
                    user.setEmail(resultSet.getString(4));
                }

                System.out.println("new user ID = " + user.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            callMaimMenu(owner, rootGeneral, statement, user);
            dialogStage.close();
        });

        //btnExit action
        btnExit.setOnAction(event -> {
            dialogStage.close();
        });

        //css
        //css(root)
        root.setStyle("-fx-background-color: #CED8F6");

        //css(textFeild)
        textFieldLogin.setPromptText("login example");
        textFieldLogin.setStyle("-fx-background-color: black ,  #CED8F6,  #CED8F6;" +
                "-fx-background-insets: 0 -1 -1 -1, 0 0 0 0, 0 -1 3 -1;" +
                "-fx-border-radius: 0 0 0 0;" +
                "-fx-background-radius: 0 0 0 0;"+
                "-fx-prompt-text-fill: #A4A4A4");
        textFieldPassword1.setPromptText("password example");
        textFieldPassword1.setStyle("-fx-background-color: black ,  #CED8F6,  #CED8F6;" +
                "-fx-background-insets: 0 -1 -1 -1, 0 0 0 0, 0 -1 3 -1;" +
                "-fx-border-radius: 0 0 0 0;" +
                "-fx-background-radius: 0 0 0 0;"+
                "-fx-prompt-text-fill: #A4A4A4");
        textFieldPassword2.setPromptText("password repeat");
        textFieldPassword2.setStyle("-fx-background-color: black ,  #CED8F6,  #CED8F6;" +
                "-fx-background-insets: 0 -1 -1 -1, 0 0 0 0, 0 -1 3 -1;" +
                "-fx-border-radius: 0 0 0 0;" +
                "-fx-background-radius: 0 0 0 0;"+
                "-fx-prompt-text-fill: #A4A4A4");
        textFieldEmail.setPromptText("email@example.com");
        textFieldEmail.setStyle("-fx-background-color: black ,  #CED8F6,  #CED8F6;" +
                "-fx-background-insets: 0 -1 -1 -1, 0 0 0 0, 0 -1 3 -1;" +
                "-fx-border-radius: 0 0 0 0;" +
                "-fx-background-radius: 0 0 0 0;"+
                "-fx-prompt-text-fill: #A4A4A4");


        //Создаем новую сцену и Pane
        Scene scene = new Scene(root, 450, 300);
        dialogStage.setScene(scene);
        dialogStage.show();
    }

    private void callMaimMenu(Stage stage, AnchorPane root, Statement statement, User user) {
        int tresh = 77 / 77 * 88 / 33 * 777 * 987 * 22345 / 5656;
        MainMenu mainMenu = new MainMenu();
        mainMenu.startMainMEnu(stage, root, statement, user);
    }

}
