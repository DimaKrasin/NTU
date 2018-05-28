package com.ntu.lab9;


import com.ntu.lab9.dao.ConversationDAO;
import com.ntu.lab9.dao.ConversationDAOImpl;
import com.ntu.lab9.dao.SubscriberDAO;
import com.ntu.lab9.dao.SubscriberDAOImpl;
import com.ntu.lab9.entitys.AllEntitysParent;
import com.ntu.lab9.entitys.Conversation;
import com.ntu.lab9.entitys.Subscriber;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class Main2WithJavaFX extends Application {

    //��� ������ � ����� ������� ��������� ���������� ����
    private static boolean isItASubscriberTable;
    //���� �������
    private static TableView<AllEntitysParent> table;
    //���� � ������� �� �� ��� �������
    private static ObservableList<AllEntitysParent> list = FXCollections.observableArrayList();

    private Subscriber subscriberToUpdate;

    //Data pickers
    private TextField textFieldSubName;
    private TextField textFieldSubAvailable;
    private TextField textFieldConversationSubWhoCall;
    private TextField textFielConversatinCalledSub;


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        createStartMenu(stage);
    }

    private void createStartMenu(Stage stage) {

        //////�����//////
        AnchorPane root = new AnchorPane();
        stage.setTitle("Lab 10");
        Scene scene = new Scene(root, 500, 250);
        stage.setScene(scene);
        stage.show();

        Label labelHello = UtilsUI.createLabel(root,"WELCOME!",30,30,550,100);
        labelHello.setFont(new Font("Arial", 70));

        //////������ 1//////
        Button btnSubscribersTable = UtilsUI.createButton("Subscribers Table", 30, 200);
        btnSubscribersTable.setOnAction(event -> {
            isItASubscriberTable = true;
            createDialogMenu(stage);
        });

        //////������ 2//////
        Button btnConversationTable = UtilsUI.createButton("Conversation Table", 330, 200);
        btnConversationTable.setOnAction(event -> {
            isItASubscriberTable = false;
            createDialogMenu(stage);
        });

        //////���������� � root//////
        root.getChildren().addAll(btnSubscribersTable, btnConversationTable);
    }

    private void createDialogMenu(Stage generalStage) {
        //������� ��������� ������
        AnchorPane root = createSmallStage(generalStage, "TableMenu");

        //�������� ������
        menuWithTableAddButtons(root);
        //��������� ���� ��� ����� ����������
        menuWithTableAddInfoPickers(root);

        //�������� ���� ������� �� ����������
        menuWithTableAddTables(root);
    }

    //////����� ��� ����������� ���� � ��������//////
    private void menuWithTableAddButtons(AnchorPane root) {

        Button btnUpdate = UtilsUI.createButton("Update", 240, 10);

        Button btnCreate = UtilsUI.createButton("Create", 240, 160);

        Button btnDelete = UtilsUI.createButton("Delete", 240, 110);

        Button btnSave = UtilsUI.createButton("Save Update", 240, 60);

        root.getChildren().addAll(btnCreate, btnUpdate, btnDelete, btnSave);

        //////setOnAction//////

        SubscriberDAO subscriberDAO = new SubscriberDAOImpl();
        ConversationDAO conversationDAO = new ConversationDAOImpl();
        String regex = "[0-9]+";

        btnUpdate.setOnAction(event -> {

            try {
                int selectedIndex = table.getSelectionModel().getSelectedIndex();
                if (selectedIndex != -1) {
                    if (isItASubscriberTable) {
                        subscriberToUpdate = (Subscriber) list.get(selectedIndex);
                        textFieldSubName.setText(subscriberToUpdate.getNumber());

                        if (subscriberToUpdate.isAvailable()) {
                            textFieldSubAvailable.setText("1");
                        } else {
                            textFieldSubAvailable.setText("0");
                        }

                    } else {

//                        conversationToUpdate = (Conversation) list.get(selectedIndex);
//
//                        textFieldConversationSubWhoCall.setText(conversationToUpdate.getSubWhoCallId());
//                        textFielConversatinCalledSub.setText(conversationToUpdate.getCalledSubId());

                    }

                }

            } catch (ArrayIndexOutOfBoundsException e) {
            }


        });

        btnCreate.setOnAction(event -> {
            if (isItASubscriberTable) {

                String number = textFieldSubName.getText();

                //validation and add
                if (number.length() == 7) {
                    if (number.matches(regex)) {

                        Subscriber subscriber = new Subscriber();

                        subscriber.setNumber(number);
                        if (textFieldSubAvailable.getText().equals("0")) {
                            subscriber.setAvailable(false);
                        } else {
                            subscriber.setAvailable(true);
                        }

                        subscriberDAO.insertSubscriber(subscriber);
                        list.add(subscriber);

                    } else {
                        System.out.println("� ������ ������ ���� ������ �����");
                    }
                } else {
                    System.out.println("�������� ����� ������!");
                }


            } else {

                String numberSubWhoCall = textFieldConversationSubWhoCall.getText();
                String numberCalledSub = textFielConversatinCalledSub.getText();

                //validation and add
                if (numberSubWhoCall.length() == 7 & numberCalledSub.length() == 7) {
                    if (numberSubWhoCall.matches(regex) & numberCalledSub.matches(regex)) {

                        Conversation conversation = new Conversation();

                        conversation.setSubWhoCallId(numberSubWhoCall);
                        conversation.setCalledSubId(numberCalledSub);

                        //��������� ���������� �� ����� ������������
                        List<Subscriber> listWirhAllSubscribers = subscriberDAO.getAllSubscriber();
                        List<String> numbers = new ArrayList<>();
                        for (Subscriber s:listWirhAllSubscribers) {
                            numbers.add(s.getNumber());
                        }

                        if(numbers.contains(numberSubWhoCall)&numbers.contains(numberCalledSub)) {

                            conversationDAO.insertConversation(conversation);
                            list.add(conversation);

                        }else {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Ahtung");
                            alert.setHeaderText(null);
                            alert.setContentText("Some testfields are not correct" +
                                    "\nTheu are real important");

                            alert.showAndWait();
                        }

                    } else {
                        System.out.println("� ������ ������ ���� ������ �����");
                    }
                } else {
                    System.out.println("�������� ����� ������!");
                }

            }
        });

        btnDelete.setOnAction(event -> {
            try {
                int selectedIndex = table.getSelectionModel().getSelectedIndex();
                if (selectedIndex != -1) {
                    if (isItASubscriberTable) {
                        Subscriber subscriber = (Subscriber) list.get(selectedIndex);
                        subscriberDAO.deleteSubscriber(subscriber.getNumber());

                        list.remove(selectedIndex);
                    } else {
                        Conversation conversation = (Conversation) list.get(selectedIndex);
                        conversationDAO.deleteConversation(conversation.getID());

                        list.remove(selectedIndex);
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
            }
        });

        btnSave.setOnAction(event -> {

            if (isItASubscriberTable) {

                String number = textFieldSubName.getText();

                //validation and add
                if (number.length() == 7) {
                    if (number.matches(regex)) {

                        String oldSubNumber = subscriberToUpdate.getNumber();
                        list.removeAll(subscriberToUpdate);

                        subscriberToUpdate.setNumber(number);
                        if (textFieldSubAvailable.getText().equals("0")) {
                            subscriberToUpdate.setAvailable(false);
                        } else {
                            subscriberToUpdate.setAvailable(true);
                        }

                        System.out.println(subscriberToUpdate.getNumber());
                        subscriberDAO.updateSubscriber(subscriberToUpdate, oldSubNumber);

                        list.addAll(subscriberToUpdate);

                    } else {
                        System.out.println("� ������ ������ ���� ������ �����");
                    }
                } else {
                    System.out.println("�������� ����� ������!");
                }


            } else {

//                String numberSubWhoCall = textFieldConversationSubWhoCall.getText();
//                String numberCalledSub = textFielConversatinCalledSub.getText();
//
//                //validation and add
//                if (numberSubWhoCall.length() == 7 & numberCalledSub.length() == 7) {
//                    if (numberSubWhoCall.matches(regex) & numberCalledSub.matches(regex)) {
//
//                        list.remove(conversationToUpdate);
//
//                        String id1 = conversationToUpdate.getSubWhoCallId();
//                        String id2 = conversationToUpdate.getCalledSubId();
//
//                        conversationToUpdate.setSubWhoCallId(numberSubWhoCall);
//                        conversationToUpdate.setCalledSubId(numberCalledSub);
//
//                        conversationDAO.updateConversation(conversationToUpdate,id1,id2);
//                        list.add(conversationToUpdate);
//
//                    } else {
//                        System.out.println("� ������ ������ ���� ������ �����");
//                    }
//                } else {
//                    System.out.println("�������� ����� ������!");
//                }

            }
        });
    }

    //////����� ��� ����������� ���� � ��������//////
    private void menuWithTableAddInfoPickers(AnchorPane root) {
        if (isItASubscriberTable) {
            Label labelSubNumber = UtilsUI.createLabel(root, "Subscriber number", 50, 10, 150, 30);
            Label labelSubAvailable = UtilsUI.createLabel(root, "Subscriber Available(0 or 1)", 50, 90, 150, 30);

            textFieldSubName = UtilsUI.createTextField(50, 50, 150, 30);
            textFieldSubAvailable = UtilsUI.createTextField(50, 130, 150, 30);

            root.getChildren().addAll(textFieldSubName, textFieldSubAvailable);

        } else {
            Label conversationSubWhoCall = UtilsUI.createLabel(root, "Sub who call", 50, 10, 150, 30);
            Label conversationCalledSub = UtilsUI.createLabel(root, "Called Sub", 50, 90, 150, 30);

            textFieldConversationSubWhoCall = UtilsUI.createTextField(50, 50, 150, 30);
            textFielConversatinCalledSub = UtilsUI.createTextField(50, 130, 150, 30);

            root.getChildren().addAll(textFieldConversationSubWhoCall, textFielConversatinCalledSub);
        }
    }

    //////����� ��� ����������� ���� � ��������//////
    private void menuWithTableAddTables(AnchorPane root) {
        table = new TableView<>();
        table.setTranslateX(10);
        table.setTranslateY(250);
        list.clear();
        table.setItems(readAllForDB());

        if (isItASubscriberTable) {
            createTableColumn(table, "Number");
            createTableColumn(table, "Available");
        } else {
            createTableColumn(table, "ID");
            createTableColumn(table, "SubWhoCallId");
            createTableColumn(table, "CalledSubId");
        }

        root.getChildren().addAll(table);
    }

    //////��������������� ��� menuWithTableAddTables()//////
    private TableColumn<AllEntitysParent, String> createTableColumn(
            TableView<AllEntitysParent> table, String name) {

        TableColumn<AllEntitysParent, String> tmp
                = new TableColumn<>(name);

        tmp.setCellValueFactory(new PropertyValueFactory<>(name));
        tmp.setPrefWidth(190);

        tmp.setStyle("-fx-alignment: CENTER;"
        );

        table.getColumns().addAll(tmp);

        return tmp;
    }

    //////��������������� ��� menuWithTableAddTables()//////
    private static ObservableList<AllEntitysParent> readAllForDB() {

        if (isItASubscriberTable) {
            SubscriberDAO subscriberDAO = new SubscriberDAOImpl();

            List<Subscriber> subs = subscriberDAO.getAllSubscriber();
            list.addAll(subs);
        } else {
            ConversationDAO conversationDAO = new ConversationDAOImpl();

            List<Conversation> conversations = conversationDAO.getAllConversation();
            list.addAll(conversations);
        }

        return list;
    }

    //////���������� ����//////
    private static AnchorPane createSmallStage(Stage owner, String stageName) {
        Stage createStage = new Stage();
        createStage.setTitle(stageName);
        createStage.initModality(Modality.WINDOW_MODAL);
        createStage.initOwner(owner);

        AnchorPane root = new AnchorPane();

        Scene scene = new Scene(root, 410, 550);
        createStage.setScene(scene);
        createStage.show();

        return root;
    }
}
