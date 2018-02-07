
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.sql.*;

public class Main extends Application {

    private static Connection connection = null;
    private static Statement statement = null;

    public static void main(String[] args) {
        initializeStatement();
        launch();
    }

    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();
        Scene scene = new Scene(root, 600, 400);

        SignInUp signInUp = new SignInUp();
        signInUp.startSignInUp(primaryStage,root,statement);


        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static void initializeStatement(){
        //Для бд
        String url = "jdbc:mysql://localhost:3306/opi.individual";
        String login = "root";
        String password = "root";
        //запуск бд
        try {
            connection = DriverManager.getConnection(url,login, password);
            statement=connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
