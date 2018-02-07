
import Entity.User;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.rmi.CORBA.Util;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class MainMenu {

    FileInputStream inputstream = null;
    ImageView imageView = null;
    Image image = null;

    Label labelInfoFrom;
    Label labelInfoTo;
    Label labelInfoDate;

    public void startMainMEnu(Stage stage, AnchorPane root, Statement statement, User user) {
        root.getChildren().clear();
        root.setStyle("-fx-background-color: #CEE3F6");

        //Add all staff

        Label labelFrom = Utils.craeteLabel(root, "Откуда", 100, 30, 42, 40);
        Label labelTo = Utils.craeteLabel(root, "Куда", 100, 30, 152, 40);
        Label labelDate = Utils.craeteLabel(root, "Дата", 100, 30, 262, 40);

        TextField textFieldFrom = Utils.createTextField(root, 40, 65);
        TextField textFieldTo = Utils.createTextField(root, 150, 65);

        DatePicker datePicker = new DatePicker();
        datePicker.setTranslateX(260);
        datePicker.setTranslateY(65);
        root.getChildren().addAll(datePicker);

        Button btnPlane = Utils.createButton(root, "Найти самолет", 40, 120);
        Button btnBus = Utils.createButton(root, "Найти автобус", 160, 120);
        Button btnTrain = Utils.createButton(root, "Найти поезд", 280, 120);

        Label labelNothingHere = Utils.craeteLabel(root,"Нечего не выбрано",300,40,190,200);

        Rectangle rectangle = Utils.createRectangle(root, 500, 200, 41, 147);

        //actions plain

        btnPlane.setOnAction(event -> {
            Button btnBuy = Utils.createButton(root,"BUY",300,300);

            root.getChildren().removeAll(imageView,labelNothingHere,labelInfoDate,labelInfoFrom,labelInfoTo);

            //css
            btnPlane.setStyle("-fx-background-color: #848484");
            btnBus.setStyle("-fx-background-color:#D8D8D8 ");
            btnTrain.setStyle("-fx-background-color: #D8D8D8");

            //label
            Label labelSearch =  Utils.craeteLabel(root,"Найдено: 1 результат",200,15,60,170);
            labelInfoFrom =
                    Utils.craeteLabel(root,"Самолет вылетает из "+textFieldFrom.getText(),200,30,60,260);
            labelInfoTo =
                    Utils.craeteLabel(root,"Самолет летитв в "+textFieldTo.getText(),200,30,60,280);
            labelInfoDate =
                    Utils.craeteLabel(root,"Дата вылета: "+datePickerToDate(datePicker).toString(),300,30,60,300);

            //picture
            try {
                inputstream = new FileInputStream("D:\\Repository\\Individual\\icons\\boeing.jpg");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            image = new Image(inputstream);
            imageView = new ImageView(image);
            imageView.setFitHeight(40);
            imageView.setFitWidth(220);
            imageView.setTranslateX(60);
            imageView.setTranslateY(210);

            root.getChildren().addAll(imageView);

        });

        //actions bus

        btnBus.setOnAction(event -> {
            Button btnBuy = Utils.createButton(root,"BUY",300,300);

            root.getChildren().removeAll(imageView,labelNothingHere,labelInfoDate,labelInfoFrom,labelInfoTo);
            //css
            btnPlane.setStyle("-fx-background-color: #D8D8D8 ");
            btnBus.setStyle("-fx-background-color:#848484 ");
            btnTrain.setStyle("-fx-background-color: #D8D8D8");

            //label
            Label labelSearch =  Utils.craeteLabel(root,"Найдено: 1 результат",200,15,60,170);
            labelInfoFrom =
                    Utils.craeteLabel(root,"Выезд на автобусе из "+textFieldFrom.getText(),200,30,60,260);
            labelInfoTo =
                    Utils.craeteLabel(root,"Прибыти в город "+textFieldTo.getText(),200,30,60,280);
            labelInfoDate =
                    Utils.craeteLabel(root,"Дата выезда: "+datePickerToDate(datePicker).toString(),300,30,60,300);

            //picture
            try {
                inputstream = new FileInputStream("D:\\Repository\\Individual\\icons\\bus.png");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            image = new Image(inputstream);
            imageView = new ImageView(image);
            imageView.setFitHeight(40);
            imageView.setFitWidth(220);
            imageView.setTranslateX(60);
            imageView.setTranslateY(210);

            root.getChildren().addAll(imageView);

        });

        //actions train

        btnTrain.setOnAction(event -> {
            Button btnBuy = Utils.createButton(root,"BUY",300,300);

            root.getChildren().removeAll(imageView,labelNothingHere,labelInfoDate,labelInfoFrom,labelInfoTo);
            //css
            btnPlane.setStyle("-fx-background-color: #D8D8D8");
            btnBus.setStyle("-fx-background-color:#D8D8D8 ");
            btnTrain.setStyle("-fx-background-color: #848484");

            //label
            Label labelSearch =  Utils.craeteLabel(root,"Найдено: 1 результат",200,15,60,170);
            labelInfoFrom =
                    Utils.craeteLabel(root,"Отбытие с главного вокзала из "+textFieldFrom.getText(),200,30,60,260);
            labelInfoTo =
                    Utils.craeteLabel(root,"Прибыти в город "+textFieldTo.getText(),200,30,60,280);
            labelInfoDate =
                    Utils.craeteLabel(root,"Дата выезда: "+datePickerToDate(datePicker).toString(),300,30,60,300);

            //picture
            try {
                inputstream = new FileInputStream("D:\\Repository\\Individual\\icons\\train.jpg");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            image = new Image(inputstream);
            imageView = new ImageView(image);
            imageView.setFitHeight(40);
            imageView.setFitWidth(220);
            imageView.setTranslateX(60);
            imageView.setTranslateY(210);

            root.getChildren().addAll(imageView);

        });

        //css
        btnPlane.setPrefSize(120, 20);
        btnBus.setPrefSize(120, 20);
        btnTrain.setPrefSize(120, 20);

        btnPlane.setStyle("-fx-background-color: #D8D8D8 ;" +
                "-fx-border-color: #6E6E6E;" +
                "-fx-border-width: 1");
        btnBus.setStyle("-fx-background-color: #D8D8D8 ;" +
                "-fx-border-color: #6E6E6E;" +
                "-fx-border-width: 1");
        btnTrain.setStyle("-fx-background-color: #D8D8D8 ;" +
                "-fx-border-color: #6E6E6E;" +
                "-fx-border-width: 1");

        textFieldFrom.setPrefSize(100, 15);
        textFieldTo.setPrefSize(100, 15);

        labelNothingHere.setStyle("-fx-font-size: 20");

        rectangle.setFill(Color.TRANSPARENT);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(1);

    }

    private static Date datePickerToDate(DatePicker datePicker) {
        LocalDate localDate = datePicker.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        sdf.format(date);

        return date;
    }

    private static LocalDate dateToDatePicker(Date date) {
        LocalDate localDate = null;

        if (date != null) {
            Instant instant = Instant.ofEpochMilli(date.getTime());
            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            localDate = localDateTime.toLocalDate();
        }
        return localDate;
    }

}
