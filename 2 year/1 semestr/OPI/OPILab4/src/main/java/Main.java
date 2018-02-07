import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {

        AnchorPane root = new AnchorPane();
        stage.setTitle("Bag tracker");

        //Создаем TableView заполняем из  ObservableList
        TableView<ReportEntity> table = createTableView();

        ObservableList<ReportEntity> list = readDB();
        table.setItems(list);

        //Создание основных кнопок
        Button btnUpdate = Utils.createButton("Update");
        btnUpdate.setOnAction(event -> {
            try {
                int selectedIndex = table.getSelectionModel().getSelectedIndex();
                if (selectedIndex != -1) {
                    CRUD crud = new CRUD();
                    crud.updateReport(stage, list, selectedIndex);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }


        });


        Button btnCreate = Utils.createButton("Create");
        btnCreate.setOnAction(event -> {
            CRUD crud = new CRUD();
            crud.createReport(stage, list);

        });

        Button btnDelete = Utils.createButton("Delete");
        btnDelete.setOnAction(event -> {
            try {
                int selectedIndex = table.getSelectionModel().getSelectedIndex();
                if (selectedIndex != -1) {
                    CRUD crud = new CRUD();
                    crud.deleteReport(list, selectedIndex);
                }
            } catch (ArrayIndexOutOfBoundsException e) {

            }
        });

        Button btnFilter = Utils.createButton("Filter");
        btnFilter.setOnAction(event -> {
            CRUD crud = new CRUD();
            crud.filterReports(stage,list,table);
        });


        css(root, table, btnUpdate, btnCreate, btnDelete,btnFilter);

        root.getChildren().addAll(table, btnCreate, btnUpdate, btnDelete,btnFilter);

        Scene scene = new Scene(root, 1200, 600);

        stage.setScene(scene);
        stage.show();
    }

    private static TableView<ReportEntity> createTableView() {

        TableView<ReportEntity> table = new TableView<ReportEntity>();

        TableColumn<ReportEntity, String> project_name
                = new TableColumn<ReportEntity, String>("Название");
        TableColumn<ReportEntity, String> project_type
                = new TableColumn<ReportEntity, String>("Тип");
        TableColumn<ReportEntity, String> priority
                = new TableColumn<ReportEntity, String>("Приоритет");
        TableColumn<ReportEntity, String> related_version
                = new TableColumn<ReportEntity, String>(" Связаная\n   версия");
        related_version.setPrefWidth(100);
        TableColumn<ReportEntity, String> corected_version
                = new TableColumn<ReportEntity, String>("Исправленая\n     версия");
        corected_version.setPrefWidth(100);
        TableColumn<ReportEntity, Date> final_date
                = new TableColumn<ReportEntity, Date>("Конечная\n    дата");
        final_date.setPrefWidth(100);
        TableColumn<ReportEntity, String> performer
                = new TableColumn<ReportEntity, String>("Исполнитель");
        performer.setPrefWidth(100);
        TableColumn<ReportEntity, String> strictness
                = new TableColumn<ReportEntity, String>("Строгость");
        TableColumn<ReportEntity, String> test_environment
                = new TableColumn<ReportEntity, String>("      Среда\nтестирования");
        test_environment.setPrefWidth(100);
        TableColumn<ReportEntity, String> project_status
                = new TableColumn<ReportEntity, String>("Статус");
        project_status.setPrefWidth(70);
        TableColumn<ReportEntity, String> description
                = new TableColumn<ReportEntity, String>("Описание          ");
        description.setPrefWidth(420);

        table.getColumns().addAll(
                project_name,
                project_type,
                priority,
                related_version,
                corected_version,
                final_date,
                performer,
                strictness,
                test_environment,
                project_status,
                description
        );

        project_name.setCellValueFactory(new PropertyValueFactory<>("project_name"));
        project_type.setCellValueFactory(new PropertyValueFactory<>("project_type"));
        priority.setCellValueFactory(new PropertyValueFactory<>("priority"));
        related_version.setCellValueFactory(new PropertyValueFactory<>("related_version"));
        corected_version.setCellValueFactory(new PropertyValueFactory<>("corrected_version"));
        final_date.setCellValueFactory(new PropertyValueFactory<>("final_date"));
        strictness.setCellValueFactory(new PropertyValueFactory<>("strictness"));
        test_environment.setCellValueFactory(new PropertyValueFactory<>("test_environment"));
        project_status.setCellValueFactory(new PropertyValueFactory<>("project_status"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        performer.setCellValueFactory(new PropertyValueFactory<>("performer"));

        project_name.setStyle("-fx-alignment: CENTER;"
        );
        project_type.setStyle("-fx-alignment: CENTER;");
        priority.setStyle("-fx-alignment: CENTER;");
        related_version.setStyle("-fx-alignment: CENTER;");
        corected_version.setStyle("-fx-alignment: CENTER;");
        final_date.setStyle("-fx-alignment: CENTER;");
        strictness.setStyle("-fx-alignment: CENTER;");
        test_environment.setStyle("-fx-alignment: CENTER;");
        project_status.setStyle("-fx-alignment: CENTER;");
        //description.setStyle("-fx-alignment: CENTER;");
        performer.setStyle("-fx-alignment: CENTER;");

        return table;
    }

    private static ObservableList<ReportEntity> readDB() {

        ObservableList<ReportEntity> list = FXCollections.observableArrayList();

        String sqlGetAll = "SELECT * FROM report ; ";

        try {
            ResultSet resultSet = Utils.getStatement().executeQuery(sqlGetAll);
            while (resultSet.next()) {
                ReportEntity report = new ReportEntity(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getDate(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10),
                        resultSet.getString(11),
                        resultSet.getString(12)
                );
                list.add(report);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void css(AnchorPane root, TableView<ReportEntity> table, Button btnUpdate, Button btnCreate, Button btnDelete,Button btnFilter) throws Exception {

        AnchorPane.setTopAnchor(table, 5.0);
        AnchorPane.setBottomAnchor(table, 100.0);
        AnchorPane.setLeftAnchor(table, 5.0);
        AnchorPane.setRightAnchor(table, 5.0);

        //root css start
        File file = new File("D:/Repository/OPI/OPILab4/pictures/wallpaper6.jpg");

        String localUrl = file.toURI().toURL().toString();
        Image image = new Image(localUrl);
        BackgroundImage myBI = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(1920, 1080, false, false, false, true));
        root.setBackground(new Background(myBI));
        //root css end

        //button css start

        AnchorPane.setBottomAnchor(btnDelete, 30.0);
        AnchorPane.setRightAnchor(btnDelete, 5.0);
        btnDelete.setStyle(
                //"-fx-text-origin: top;"   +
                "-fx-font-size: 15;" +
                        "-fx-text-alignment: center;" +
                        "-fx-text-fill: #0B4C5F;" +
                        "-fx-background-radius: 0em; " +
                        //"-fx-background-color:#F4FA58;" +
                        "-fx-border-width: 1;" +
                        "-fx-border-color: #2E9AFE;"
        );


        AnchorPane.setBottomAnchor(btnUpdate, 30.0);
        AnchorPane.setRightAnchor(btnUpdate, 155.0);
        btnUpdate.setStyle(

                "-fx-font-size: 15;" +
                        "-fx-text-alignment: center;" +
                        "-fx-text-fill: #0B4C5F;" +
                        "-fx-background-radius: 0em; " +
                        "-fx-border-width: 1;" +
                        "-fx-border-color: #2E9AFE;"
        );

        AnchorPane.setBottomAnchor(btnCreate, 30.0);
        AnchorPane.setRightAnchor(btnCreate, 305.0);

        btnCreate.setStyle(
                "-fx-font-size: 15;" +
                        "-fx-text-alignment: center;" +
                        "-fx-text-fill: #0B4C5F;" +
                        "-fx-background-radius: 0em; " +
                        "-fx-background-size: 10,10; " +
                        "-fx-border-width: 1;" +
                        "-fx-border-color: #2E9AFE;"
        );

        AnchorPane.setBottomAnchor(btnFilter, 30.0);
        AnchorPane.setRightAnchor(btnFilter, 455.0);

        btnFilter.setStyle(
                "-fx-font-size: 15;" +
                        "-fx-text-alignment: center;" +
                        "-fx-text-fill: #0B4C5F;" +
                        "-fx-background-radius: 0em; " +
                        "-fx-background-size: 10,10; " +
                        "-fx-border-width: 1;" +
                        "-fx-border-color: #2E9AFE;"
        );

        //button css finish
    }
}
