import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CRUD {

    private static String sql;
    private static ObservableList<ReportEntity> list;
    private static int index;
    private static boolean isThisUpdate = false;
    private static int idToUpdate = 0;
    private static Stage createStage;

    public void createReport(Stage owner, ObservableList<ReportEntity> observableList) {

        list = observableList;

        AnchorPane root = createSmallStage(owner, "Create a new report");
        isThisUpdate = false;
        addStaffOnStage(root);

    }

    public void updateReport(Stage owner, ObservableList<ReportEntity> observableList, int indexOfElement) {

        list = observableList;
        index = indexOfElement;
        isThisUpdate = true;

        AnchorPane root = createSmallStage(owner, "Update report");
        addStaffOnStage(root);
    }

    public void filterReports(Stage owner, ObservableList<ReportEntity> observableList,TableView<ReportEntity> table){

        //Создаем маленькое окошко
        AnchorPane root = createSmallStage(owner, "Filter reports");

        //Создаем Lable
        Label lblGeneralDescription = Utils.createLabel(root,"В одной групе допустимо только одно значение!",
                50,20,400,20);
        lblGeneralDescription.setStyle("-fx-text-fill: white;");

        Label lblProgectType = Utils.createLabel(root,"Тип проекта",
                20,50,400,20);
        lblProgectType.setStyle("-fx-text-fill: white;");

        Label lblProgectPriority = Utils.createLabel(root,"Приоритет проекта",
                20,115,400,20);
        lblProgectPriority.setStyle("-fx-text-fill: white;");

        Label lblProgectStricness = Utils.createLabel(root,"Строгость проекта",
                20,215,400,20);
        lblProgectStricness.setStyle("-fx-text-fill: white;");

        Label lblTestEnvirinment = Utils.createLabel(root,"Среда тестирования",
                20,315,400,20);
        lblTestEnvirinment.setStyle("-fx-text-fill: white;");

        //Создаем чек-боксы
        CheckBox projectType_Bag = Utils.createCheckBox("баг",20,75);
        projectType_Bag.setStyle("-fx-text-fill: white;");
        CheckBox projectType_Zadacha = Utils.createCheckBox("задача",20,95);
        projectType_Zadacha.setStyle("-fx-text-fill: white;");

        CheckBox projectPriority_Kritichnuy = Utils.createCheckBox("критический",20,135);
        projectPriority_Kritichnuy.setStyle("-fx-text-fill: white;");
        CheckBox projectPriority_Visokiy = Utils.createCheckBox("високий",20,155);
        projectPriority_Visokiy.setStyle("-fx-text-fill: white;");
        CheckBox projectPriority_Sredniy = Utils.createCheckBox("средний",20,175);
        projectPriority_Sredniy.setStyle("-fx-text-fill: white;");
        CheckBox projectPriority_Nizkiy = Utils.createCheckBox("низкий",20,195);
        projectPriority_Nizkiy.setStyle("-fx-text-fill: white;");

        CheckBox projectStrictness_Kritichnuy = Utils.createCheckBox("критическая",20,235);
        projectStrictness_Kritichnuy.setStyle("-fx-text-fill: white;");
        CheckBox projectStrictness_Visokiy = Utils.createCheckBox("большая",20,255);
        projectStrictness_Visokiy.setStyle("-fx-text-fill: white;");
        CheckBox projectStrictness_Sredniy = Utils.createCheckBox("средняя",20,275);
        projectStrictness_Sredniy.setStyle("-fx-text-fill: white;");
        CheckBox projectStrictness_Nizkiy = Utils.createCheckBox("низкая",20,295);
        projectStrictness_Nizkiy.setStyle("-fx-text-fill: white;");

        CheckBox projectTestEnvironment_SIT = Utils.createCheckBox("SIT",20,335);
        projectTestEnvironment_SIT.setStyle("-fx-text-fill: white;");
        CheckBox projectTestEnvironment_UAT = Utils.createCheckBox("UAT",20,355);
        projectTestEnvironment_UAT.setStyle("-fx-text-fill: white;");
        CheckBox projectTestEnvironment_PDN = Utils.createCheckBox("PDN",20,375);
        projectTestEnvironment_PDN.setStyle("-fx-text-fill: white;");

        //кнопка exit
        Button btnExit = Utils.createButton("Exit",50,450);
        btnExit.setOnAction(event -> {
            createStage.close();
        });


        //Кнопка filter
        Button btnFilter =Utils.createButton("Filter",200,450);
        btnFilter.setOnAction(event -> {
            ObservableList<ReportEntity> tmp = observableList;
            if(projectType_Bag.isSelected()) {
                    tmp = FXCollections.observableList(filterByProjectType(tmp, "баг"));
            }
            if(projectType_Zadacha.isSelected()) {
                tmp = FXCollections.observableList(filterByProjectType(tmp, "задача"));
            }
            if(projectPriority_Kritichnuy.isSelected()) {
                tmp = FXCollections.observableList(filterByProjectPriority(tmp, "критический"));
            }
            if(projectPriority_Visokiy.isSelected()) {
                tmp = FXCollections.observableList(filterByProjectPriority(tmp, "високий"));
            }
            if(projectPriority_Sredniy.isSelected()) {
                tmp = FXCollections.observableList(filterByProjectPriority(tmp, "средний"));
            }
            if(projectPriority_Nizkiy.isSelected()) {
                tmp = FXCollections.observableList(filterByProjectPriority(tmp, "низкий"));
            }
            if(projectStrictness_Kritichnuy.isSelected()) {
                tmp = FXCollections.observableList(filterByProjectStrictness(tmp, "критическая"));
            }
            if(projectStrictness_Visokiy.isSelected()) {
                tmp = FXCollections.observableList(filterByProjectStrictness(tmp, "большая"));
            }
            if(projectStrictness_Sredniy.isSelected()) {
                tmp = FXCollections.observableList(filterByProjectStrictness(tmp, "средняя"));
            }
            if(projectStrictness_Nizkiy.isSelected()) {
                tmp = FXCollections.observableList(filterByProjectStrictness(tmp, "низкая"));
            }
            if(projectTestEnvironment_SIT.isSelected()) {
                tmp = FXCollections.observableList(filterByTestEnvironment(tmp, "SIT"));
            }
            if(projectTestEnvironment_UAT.isSelected()) {
                tmp = FXCollections.observableList(filterByTestEnvironment(tmp, "UAT"));
            }
            if(projectTestEnvironment_PDN.isSelected()) {
                tmp = FXCollections.observableList(filterByTestEnvironment(tmp, "PDN"));
            }
            table.setItems(tmp);
            createStage.close();
        });

        root.getChildren().addAll(
                lblGeneralDescription,lblProgectType,lblProgectPriority,lblProgectStricness,lblTestEnvirinment,
                btnExit,
                btnFilter,
                projectType_Bag,projectType_Zadacha,
                projectPriority_Kritichnuy,projectPriority_Visokiy,projectPriority_Sredniy,projectPriority_Nizkiy,
                projectStrictness_Kritichnuy,projectStrictness_Visokiy,projectStrictness_Sredniy,projectStrictness_Nizkiy,
                projectTestEnvironment_SIT,projectTestEnvironment_UAT,projectTestEnvironment_PDN);
    }

    private static List<ReportEntity> filterByProjectType(ObservableList<ReportEntity> list, String ptojectType) {
        return list.stream()
                .filter(t -> t.getProject_type().contains(ptojectType))
                .collect(Collectors.toList());
    }

    private static List<ReportEntity> filterByProjectPriority(ObservableList<ReportEntity> list, String ptojectPriority) {
        return list.stream()
                .filter(t -> t.getPriority().contains(ptojectPriority))
                .collect(Collectors.toList());
    }

    private static List<ReportEntity> filterByProjectStrictness(ObservableList<ReportEntity> list, String ptojectStrictness) {
        return list.stream()
                .filter(t -> t.getStrictness().contains(ptojectStrictness))
                .collect(Collectors.toList());
    }

    private static List<ReportEntity> filterByTestEnvironment(ObservableList<ReportEntity> list, String testEnvironment) {
        return list.stream()
                .filter(t -> t.getTest_environment().contains(testEnvironment))
                .collect(Collectors.toList());
    }


    private static AnchorPane createSmallStage(Stage owner, String stageName) {
        createStage = new Stage();
        createStage.setTitle(stageName);
        createStage.initModality(Modality.WINDOW_MODAL);
        createStage.initOwner(owner);

        AnchorPane root = new AnchorPane();

        File file = new File("D:/Repository/OPI/OPILab4/pictures/wallpaper8.jpg");

        String localUrl = null;
        try {
            localUrl = file.toURI().toURL().toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Image image = new Image(localUrl);
        BackgroundImage myBI = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,
                new BackgroundSize(430, 600, false, false, false, true));
        root.setBackground(new Background(myBI));

        Scene scene = new Scene(root, 410, 550);
        createStage.setScene(scene);
        createStage.show();

        return root;
    }

    private static void addStaffOnStage(AnchorPane root) {
        TextField project_name = Utils.createTextField(40, 50, 100, 100);
        TextField related_version = Utils.createTextField(40, 400, 20, 80);
        TextField corrected_version = Utils.createTextField(40, 110, 20, 80);
        TextField performer = Utils.createTextField(40, 170, 20, 80);
        TextField project_status = Utils.createTextField(40, 230, 20, 80);

        //TextField description = Utils.createTextField(40, 290, 400, 80);

        TextArea description = new TextArea();
        description.setPrefSize(350, 70);
        description.setLayoutX(40);
        description.setLayoutY(290);

        String[] priority_mas = {"критический", "высокий", "средний", "низкий"};
        SplitMenuButton priority = Utils.createSplitMenuButton(priority_mas, "требует выбора", 230, 50);
        String[] strictness_mas = {"критическая", "большая", "средняя", "низкая"};
        SplitMenuButton strictness = Utils.createSplitMenuButton(strictness_mas, "требует выбора", 230, 110);
        String[] test_environment_mas = {"SIT", "UAT", "PDN"};
        SplitMenuButton test_environment = Utils.createSplitMenuButton(test_environment_mas, "требует выбора", 230, 170);
        String[] project_type_mas = {"баг", "задача"};
        SplitMenuButton project_type = Utils.createSplitMenuButton(project_type_mas, "требует выбора", 230, 230);

        DatePicker datePicker = Utils.createDatePicker(215, 400);


        Button btnSave = Utils.createButton("Save", 40, 460);
        Button btnExit = Utils.createButton("Exit", 230, 460);
        btnExit.setOnAction(event -> {

            sql = null;
            index = 0;
            isThisUpdate = false;
            idToUpdate = 0;
            createStage.close();
        });


        if (isThisUpdate) {
            idToUpdate = list.get(index).getId();
            ReportEntity tmp = getEntity(list.get(index).getId());
            project_name.setText(tmp.getProject_name());
            priority.setText(tmp.getPriority());
            related_version.setText(tmp.getRelated_version());
            corrected_version.setText(tmp.getCorrected_version());
            datePicker.setValue(dateToLocalDate(tmp.getFinal_date()));
            performer.setText(tmp.getPerformer());
            strictness.setText(tmp.getStrictness());
            test_environment.setText(tmp.getTest_environment());
            project_status.setText(tmp.getProject_status());
            description.setText(tmp.getDescription());
            project_type.setText(tmp.getProject_type());
        }

        Label label_project_name = Utils.createLabel(root, "Название проекта*", 40, 30, 200, 10);
        Label label_related_version = Utils.createLabel(root, "Связаная версия", 40, 380, 200, 10);
        Label label_corrected_version = Utils.createLabel(root, "Исправления версия*", 40, 90, 200, 10);
        Label label_performer = Utils.createLabel(root, "Исполнитель*", 40, 150, 200, 10);
        Label label_status = Utils.createLabel(root, "Статус*", 40, 210, 200, 10);
        Label label_description = Utils.createLabel(root, "Описание*", 40, 270, 200, 10);
        Label label_final_date = Utils.createLabel(root, "Финальная дата", 215, 380, 200, 10);
        Label label_priority = Utils.createLabel(root, "Приоритет*", 230, 30, 200, 10);
        Label label_strictness = Utils.createLabel(root, "Строгость*", 230, 90, 200, 10);
        Label label_test_environment = Utils.createLabel(root, "Среда тестирования*", 230, 150, 200, 10);
        Label label_type = Utils.createLabel(root, "Тип отчета*", 230, 210, 200, 10);
        Label label_my = Utils.createLabel(root, "Поля помечение * обезательны для заполнения", 40, 510, 350, 10);

        label_project_name.setStyle("-fx-text-fill: white;");
        label_related_version.setStyle("-fx-text-fill: white;");
        label_corrected_version.setStyle("-fx-text-fill: white;");
        label_performer.setStyle("-fx-text-fill: white;");
        label_status.setStyle("-fx-text-fill: white;");
        label_description.setStyle("-fx-text-fill: white;");
        label_final_date.setStyle("-fx-text-fill: white;");
        label_priority.setStyle("-fx-text-fill: white;");
        label_strictness.setStyle("-fx-text-fill: white;");
        label_test_environment.setStyle("-fx-text-fill: white;");
        label_type.setStyle("-fx-text-fill: white;");
        label_my.setStyle("-fx-text-fill: white;"+"-fx-font-size: 15;");

        root.getChildren().addAll(
                project_name, related_version, corrected_version, performer, project_status, description, project_type,
                priority, strictness, test_environment, datePicker, btnSave, btnExit,
                label_project_name, label_related_version, label_corrected_version, label_performer, label_status, label_description,
                label_final_date, label_priority, label_strictness, label_test_environment, label_type,label_my
        );

        btnSave.setOnAction(event -> {

            if (isReportCorect(
                    project_name.getText(), project_type.getText(), priority.getText(),
                    corrected_version.getText(), performer.getText(), strictness.getText(),
                    test_environment.getText(), project_status.getText(), description.getText()
            )) {

                Date date = null;
                String dateForSQL = "null";

                if (datePicker.getValue() != null) {
                    date = datePickerToDate(datePicker);
                    dateForSQL = "'" + datePicker.getValue() + "'";
                }

                String sql;

                if (isThisUpdate) {
                    sql = "update report set " +
                            "project_name = '" + project_name.getText()
                            + "',project_type= '" + project_type.getText()
                            + "', priority='" + priority.getText()
                            + "',related_version='" + related_version.getText()
                            + "',corrected_version='" + corrected_version.getText()
                            + "',final_date=" + dateForSQL
                            + ",performer='" + performer.getText()
                            + "',strictness='" + strictness.getText()
                            + "',test_environment='" + test_environment.getText()
                            + "',project_status='" + project_status.getText()
                            + "',description='" + description.getText()
                            + "'where id = " + idToUpdate;
                } else {
                    sql = "INSERT INTO report (" + "project_name," +
                            "project_type, priority," + "related_version," + "corrected_version," +
                            "final_date," + "performer," + "strictness," + "test_environment," +
                            "project_status," + "description" + " ) VALUES ('" + project_name.getText() +
                            "','" + project_type.getText() + "','" + priority.getText() + "','" + related_version.getText()
                            + "','" + corrected_version.getText() + "'," + dateForSQL + ",'" + performer.getText() +
                            "','" + strictness.getText() + "','" + test_environment.getText() + "','" + project_status.getText() +
                            "','" + description.getText() + "')";
                }

                doSql(sql);
                sql = null;
                dateForSQL = "null";

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Ahtung");
                alert.setHeaderText(null);
                alert.setContentText("Некотрые из полей и не заполнены...\nОни очень важны для роботы програми.");

                alert.showAndWait();
            }

        });
    }

    private static void doSql(String sql) {

        try {
            Utils.getStatement().executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        chancheList();
    }

    private static boolean isReportCorect(String project_name, String project_type, String priority,
                                          String corrected_version, String performer, String strictness,
                                          String test_environment, String project_status, String description
    ) {
        boolean corect = true;

        if (isThisUpdate) {
            return true;
        }

        if (project_name == null) corect = false;
        if (project_type != "задача" && project_type != "баг") corect = false;
        System.out.println(corect + " + " + project_type);
        if (priority != "критический" && priority != "высокий" && priority != "средний" && priority != "низкий")
            corect = false;
        System.out.println(corect + " + " + priority);
        if (corrected_version == null) corect = false;
        if (performer == null) corect = false;
        if (strictness != "критическая" && strictness != "большая" && strictness != "средняя" && strictness != "низкая")
            corect = false;
        if (test_environment != "SIT" && test_environment != "UAT" && test_environment != "PDN") corect = false;
        if (project_status == null) corect = false;
        if (description == null) corect = false;


        return corect;
    }

    private static Date datePickerToDate(DatePicker datePicker) {
        LocalDate localDate = datePicker.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        sdf.format(date);

        return date;
    }

    private static LocalDate dateToLocalDate(Date date) {
        LocalDate localDate = null;

        if (date != null) {
            Instant instant = Instant.ofEpochMilli(date.getTime());
            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            localDate = localDateTime.toLocalDate();
        }
        return localDate;
    }

    private static void chancheList() {

        if (isThisUpdate) {
            list.remove(index);
            list.add(getEntity(idToUpdate));
        } else {
            list.add(getEntity(0));
        }

        sql = null;
        index = 0;
        isThisUpdate = false;
        idToUpdate = 0;
        createStage.close();
    }

    private static ReportEntity getEntity(int idForUpdate) {

        ResultSet resultSet = null;

        int id = 0;
        String project_name = null;
        String project_type = null;

        String priority = null;
        String related_version = null;
        String corrected_version = null;

        Date final_date = null;
        String performer = null;
        String strictness = null;

        String test_environment = null;
        String project_status = null;
        String description = null;

        try {
            if (isThisUpdate) {
                resultSet = Utils.getStatement().executeQuery("SELECT * FROM report WHERE id = " + idForUpdate);
            } else {
                resultSet = Utils.getStatement().executeQuery("SELECT * FROM report WHERE id = (SELECT max(id) FROM report)");
            }

            if (resultSet.first()) {
                id = resultSet.getInt(1);
                project_name = resultSet.getString(2);
                project_type = (resultSet.getString(3));
                priority = (resultSet.getString(4));
                related_version = (resultSet.getString(5));
                corrected_version = (resultSet.getString(6));
                final_date = (resultSet.getDate(7));
                performer = (resultSet.getString(8));
                strictness = (resultSet.getString(9));
                test_environment = (resultSet.getString(10));
                project_status = (resultSet.getString(11));
                description = (resultSet.getString(12));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        ReportEntity entity = new ReportEntity(id, project_name, project_type, priority, related_version, corrected_version,
                final_date, performer, strictness, test_environment, project_status, description);

        return entity;
    }

    public void deleteReport(ObservableList<ReportEntity> list, int index) {
        try {
            Utils.getStatement().executeUpdate("DELETE FROM report WHERE id = " + list.get(index).getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        list.remove(index);
    }


}
