import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Utils {

    private final static String url = "jdbc:mysql://localhost:3306/opi.individual";
    private final static String login = "root";
    private final static String password = "root";

    private static Connection connection;
    private static Statement statement;

    public static Button createButton(AnchorPane root,String text, double x, double y){
        Button button = new Button();
        AnchorPane.setTopAnchor(button,y);
        AnchorPane.setLeftAnchor(button,x);
        button.setText(text);
        root.getChildren().addAll(button);
        return button;
    }

    public static TextField createTextField(AnchorPane root, double x,double y){
        TextField textField = new TextField();
        AnchorPane.setTopAnchor(textField,y);
        AnchorPane.setLeftAnchor(textField,x);
        root.getChildren().addAll(textField);
        return textField;
    }

    public static Label craeteLabel(AnchorPane root,String text,double width,double height,double x,double y){
        Label label = new Label();
        label.setText(text);
        label.setTranslateX(x);
        label.setTranslateY(y);
        label.setPrefSize(width,height);
        root.getChildren().addAll(label);

        return label;
    }

    public static Rectangle createRectangle(AnchorPane root,double width,double height,double x,double y){
        Rectangle rectangle = new Rectangle();
        rectangle.setTranslateX(x);
        rectangle.setTranslateY(y);
        rectangle.setHeight(height);
        rectangle.setWidth(width);
        root.getChildren().addAll(rectangle);
        return rectangle;
    }

    //Методы для связи с БД

    public static Statement getStatement() {

        try {
            if(connection==null){
                connection = DriverManager.getConnection(url,login,password);
            }

            if(statement==null){
                statement = connection.createStatement();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Проблемы с getStatement");
        }

        return statement;
    }

    public void closeConnection(){
        try {
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
