package com.ntu.Lab10Luda;

import com.ntu.Lab10Luda.DAO.*;
import com.ntu.Lab10Luda.Entity.Parent;
import com.ntu.Lab10Luda.Entity.Personclient;
import com.ntu.Lab10Luda.Entity.Ticket;
import com.ntu.Lab10Luda.Entity.Ticketregister;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    private static TextField textFieldTicketTicketName;
    private static TextField textFieldTicketRace;
    private static TextField textFieldTicketTrainNumber;
    private static TextField textFieldTicketSittingNumber;

    private static TextField textFieldPersonClientFirstName;
    private static TextField textFieldPersonClientLastName;
    private static TextField textFieldPersonClientPhone;
    private static TextField textFieldPersonClientSerialOfPassport;

    private static TextField textFieldTicketRegisterTicketID;
    private static TextField textFieldTicketRegisterPersonClientId;

    private static boolean isItATicketTable;
    private static boolean isItAPersonClientTable;
    private static boolean isItATicketRegisterTable;

    private static long ticketIdToUpdate;
    private static long personClientIDToUpdate;
    private static long ticketRegisterIDToUpdate;

    private static TicketregisterDAO ticketregisterDAO = new TicketRegisterDAOimpl();
    private static TicketDAO ticketDAO = new TicketDAOimpl();
    private static PersonclientDAO personclientDAO = new PersonclientDAOimpl();

    private static TableView<Parent> table;
    private static ObservableList<Parent> list = FXCollections.observableArrayList();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        createStartMenu(primaryStage);
    }

    private void createStartMenu(Stage stage) {

        AnchorPane root = new AnchorPane();
        stage.setTitle("Lab 10");
        Scene scene = new Scene(root, 500, 260);
        stage.setScene(scene);
        stage.show();

        Label label = new Label("WELCOME!");
        label.setFont(new Font("Arial", 70));
        label.setTranslateX(50);
        label.setTranslateY(50);
        Label label1 = new Label("By Goloborodko");
        label1.setFont(new Font("Arial", 20));
        label1.setTranslateX(170);
        label1.setTranslateY(160);
        root.getChildren().addAll(label, label1);

        Button btnUserTable = UtilsUI.createButton("Ticket Table", 30, 200);
        btnUserTable.setOnAction(event -> {

            isItATicketTable = true;
            isItAPersonClientTable = false;
            isItATicketRegisterTable = false;

            createDialogMenu(stage);
        });

        Button btnConferenceTable = UtilsUI.createButton("PersonClient Table", 185, 200);
        btnConferenceTable.setOnAction(event -> {
            isItATicketTable = false;
            isItAPersonClientTable = true;
            isItATicketRegisterTable = false;

            createDialogMenu(stage);
        });


        Button btnConferenceUserTable = UtilsUI.createButton("TicketRegister Table", 350, 200);
        btnConferenceUserTable.setOnAction(event -> {
            isItATicketTable = false;
            isItAPersonClientTable = false;
            isItATicketRegisterTable = true;

            createDialogMenu(stage);
        });


        root.getChildren().addAll(btnUserTable, btnConferenceTable, btnConferenceUserTable);
    }

    private void createDialogMenu(Stage generalStage) {

        AnchorPane root = createSmallStage(generalStage, "TableMenu");

        menuWithTableAddButtons(root);

        menuWithTableAddInfoPickers(root);

        menuWithTableAddTables(root);
    }


    private void menuWithTableAddButtons(AnchorPane root) {

        Button btnUpdate = UtilsUI.createButton("Update", 240, 10);

        Button btnCreate = UtilsUI.createButton("Create", 240, 160);

        Button btnDelete = UtilsUI.createButton("Delete", 240, 110);

        Button btnSave = UtilsUI.createButton("Save Update", 240, 60);

        root.getChildren().addAll(btnCreate, btnUpdate, btnDelete, btnSave);

        btnUpdate.setOnAction(event -> {
            try {
                int selectedIndex = table.getSelectionModel().getSelectedIndex();
                if (selectedIndex != -1) {

                    if (isItATicketTable) {
                        Ticket ticket = (Ticket) list.get(selectedIndex);

                        ticketIdToUpdate = ticket.getId();

                        textFieldTicketTicketName.setText(ticket.getTicketname());
                        textFieldTicketRace.setText(ticket.getRace());
                        textFieldTicketTrainNumber.setText(String.valueOf(ticket.getTrainnumber()));
                        textFieldTicketSittingNumber.setText(String.valueOf(ticket.getSittingnumber()));

                        list.remove(selectedIndex);
                    }

                    if (isItAPersonClientTable) {
                        Personclient personclient = (Personclient) list.get(selectedIndex);

                        personClientIDToUpdate = personclient.getID();

                        textFieldPersonClientFirstName.setText(personclient.getFirstName());
                        textFieldPersonClientLastName.setText(personclient.getLastName());
                        textFieldPersonClientPhone.setText(personclient.getPhone());
                        textFieldPersonClientSerialOfPassport.setText(personclient.getSerialOfPassport());

                        list.remove(selectedIndex);
                    }

                    if (isItATicketRegisterTable) {
                        System.out.println("Unavailable function!");
//                        Ticketregister ticketregister = (Ticketregister) list.get(selectedIndex);
//                        ticketRegisterIDToUpdate = ticketregister.getID();
//
//                        textFieldTicketRegisterTicketID.setText(String.valueOf(ticketregister.getTicketId()));
//                        textFieldTicketRegisterPersonClientId.setText(String.valueOf(ticketregister.getPersonclientId()));
//
//                        list.remove(selectedIndex);
                    }

                }

            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
        });

        btnCreate.setOnAction(event -> {
            if (isItATicketTable) {
                Ticket ticket = new Ticket();

                ticket.setTicketname(textFieldTicketTicketName.getText());
                ticket.setRace(textFieldTicketRace.getText());
                ticket.setSittingnumber(Integer.valueOf(textFieldTicketSittingNumber.getText()));
                ticket.setTrainnumber(Integer.valueOf(textFieldTicketTrainNumber.getText()));

                ticketDAO.insertTicket(ticket);

                list.add(ticket);
            }

            if (isItAPersonClientTable) {
                Personclient personclient = new Personclient();

                personclient.setFirstName(textFieldPersonClientFirstName.getText());
                personclient.setLastName(textFieldPersonClientLastName.getText());
                personclient.setPhone(textFieldPersonClientPhone.getText());
                personclient.setSerialOfPassport(textFieldPersonClientSerialOfPassport.getText());

                personclientDAO.insertPersonclient(personclient);

                list.add(personclient);
            }

            if (isItATicketRegisterTable) {
                Ticketregister ticketregister = new Ticketregister();

                ticketregister.setPersonclientId(Long.valueOf(textFieldTicketRegisterPersonClientId.getText()));
                ticketregister.setTicketId(Long.valueOf(textFieldTicketRegisterTicketID.getText()));

                ticketregisterDAO.insertTicketregister(ticketregister);

                list.addAll(ticketregister);
            }
        });

        btnDelete.setOnAction(event -> {
            try {
                int selectedIndex = table.getSelectionModel().getSelectedIndex();
                if (selectedIndex != -1) {
                    {

                        if (isItATicketTable) {
                            Ticket ticket = (Ticket) list.get(selectedIndex);

                            ticketDAO.deleteTicket(ticket.getId());
                            list.remove(selectedIndex);
                        }

                        if (isItAPersonClientTable) {
                            Personclient personclient = (Personclient) list.get(selectedIndex);

                            personclientDAO.deletePersonclient(personclient.getID());
                            list.remove(selectedIndex);
                        }

                        if (isItATicketRegisterTable) {
                            Ticketregister ticketregister = (Ticketregister) list.get(selectedIndex);

                            ticketregisterDAO.deleteTicketregister(ticketregister.getID());
                            list.remove(selectedIndex);
                        }
                    }
                }
            } catch (ArrayIndexOutOfBoundsException ignored) {
            }
        });

        btnSave.setOnAction(event -> {
            if (isItATicketTable) {

                if (ticketIdToUpdate != -1) {
                    Ticket ticket = ticketDAO.getTicketById(ticketIdToUpdate);

                    ticket.setTicketname(textFieldTicketTicketName.getText());
                    ticket.setRace(textFieldTicketRace.getText());
                    ticket.setSittingnumber(Integer.valueOf(textFieldTicketSittingNumber.getText()));
                    ticket.setTrainnumber(Integer.valueOf(textFieldTicketTrainNumber.getText()));

                    ticketDAO.updateTicket(ticket);

                    list.add(ticket);

                    ticketIdToUpdate = -1;
                }
            }

            if (isItAPersonClientTable) {

                if (personClientIDToUpdate != -1) {
                    Personclient personclient = personclientDAO.getPersonclientById(personClientIDToUpdate);

                    personclient.setFirstName(textFieldPersonClientFirstName.getText());
                    personclient.setLastName(textFieldPersonClientLastName.getText());
                    personclient.setPhone(textFieldPersonClientPhone.getText());
                    personclient.setSerialOfPassport(textFieldPersonClientSerialOfPassport.getText());

                    personclientDAO.updatePersonclient(personclient);

                    list.add(personclient);

                    personClientIDToUpdate = -1;
                }
            }

            if (isItATicketRegisterTable) {
                System.out.println("Unavailable function!");
            }
        });

    }

    private void menuWithTableAddInfoPickers(AnchorPane root) {
        if (isItATicketTable) {

            textFieldTicketTicketName = UtilsUI.createTextField(50, 50, 150, 30);
            textFieldTicketRace = UtilsUI.createTextField(50, 90, 150, 30);
            textFieldTicketSittingNumber = UtilsUI.createTextField(50, 130, 150, 30);
            textFieldTicketTrainNumber = UtilsUI.createTextField(50, 170, 150, 30);

            textFieldTicketTicketName.setPromptText("Ticket name");
            textFieldTicketRace.setPromptText("Ticket race");
            textFieldTicketSittingNumber.setPromptText("Sitting number");
            textFieldTicketTrainNumber.setPromptText("Train Number");

            textFieldPersonClientFirstName = null;
            textFieldPersonClientLastName = null;
            textFieldPersonClientPhone  = null;
            textFieldPersonClientSerialOfPassport = null;

            textFieldTicketRegisterPersonClientId = null;
            textFieldTicketRegisterTicketID = null;
        }

        if (isItAPersonClientTable) {
            textFieldPersonClientFirstName = UtilsUI.createTextField(50, 50, 150, 30);
            textFieldPersonClientLastName = UtilsUI.createTextField(50, 90, 150, 30);
            textFieldPersonClientPhone = UtilsUI.createTextField(50, 130, 150, 30);
            textFieldPersonClientSerialOfPassport = UtilsUI.createTextField(50, 170, 150, 30);

            textFieldPersonClientFirstName.setPromptText("First name");
            textFieldPersonClientLastName.setPromptText("Last name");
            textFieldPersonClientPhone.setPromptText("Phone");
            textFieldPersonClientSerialOfPassport.setPromptText("Serial Of Passport");

            textFieldTicketTicketName = null;
            textFieldTicketRace = null;
            textFieldTicketSittingNumber = null;
            textFieldTicketTrainNumber = null;

            textFieldTicketRegisterPersonClientId = null;
            textFieldTicketRegisterTicketID = null;
        }

        if (isItATicketRegisterTable) {
            textFieldTicketRegisterPersonClientId =  UtilsUI.createTextField(50, 50, 150, 30);
            textFieldTicketRegisterTicketID = UtilsUI.createTextField(50, 90, 150, 30);

            textFieldTicketRegisterPersonClientId.setPromptText("PersonClient ID");
            textFieldTicketRegisterTicketID.setPromptText("Ticket ID ");

            textFieldPersonClientFirstName = null;
            textFieldPersonClientLastName = null;
            textFieldPersonClientPhone  = null;
            textFieldPersonClientSerialOfPassport = null;

            textFieldTicketTicketName = null;
            textFieldTicketRace = null;
            textFieldTicketSittingNumber = null;
            textFieldTicketTrainNumber = null;
        }

        if (textFieldTicketTicketName != null) {
            root.getChildren().addAll(
                    textFieldTicketTicketName,
                    textFieldTicketRace,
                    textFieldTicketSittingNumber,
                    textFieldTicketTrainNumber);
        }

        if (textFieldPersonClientFirstName != null) {
            root.getChildren().addAll(
                    textFieldPersonClientFirstName,
                    textFieldPersonClientLastName,
                    textFieldPersonClientPhone,
                    textFieldPersonClientSerialOfPassport
            );
        }

        if(textFieldTicketRegisterPersonClientId!=null){
            root.getChildren().addAll(textFieldTicketRegisterPersonClientId,
            textFieldTicketRegisterTicketID);
        }

    }

    private void menuWithTableAddTables(AnchorPane root) {
        table = new TableView<>();
        table.setTranslateX(10);
        table.setPrefWidth(390);
        table.setTranslateY(250);
        list.clear();
        table.setItems(readAllForDB());

        if (isItATicketTable) {
            createTableColumn(table, "id");
            createTableColumn(table, "ticketname");
            createTableColumn(table, "race");
            createTableColumn(table, "trainnumber");
            createTableColumn(table, "sittingnumber");
        }

        if (isItAPersonClientTable) {
            createTableColumn(table, "ID");
            createTableColumn(table, "firstName");
            createTableColumn(table, "lastName");
            createTableColumn(table, "phone");
            createTableColumn(table, "serialOfPassport");
        }

        if (isItATicketRegisterTable) {
            createTableColumn(table, "ID");
            createTableColumn(table, "ticketId");
            createTableColumn(table, "personclientId");
        }


        root.getChildren().addAll(table);
    }


    private TableColumn<Parent, String> createTableColumn(
            TableView<Parent> table, String name) {

        TableColumn<Parent, String> tmp
                = new TableColumn<>(name);

        tmp.setCellValueFactory(new PropertyValueFactory<>(name));
        tmp.setPrefWidth(80);

        tmp.setStyle("-fx-alignment: CENTER;"
        );

        table.getColumns().addAll(tmp);

        return tmp;
    }


    private static ObservableList<Parent> readAllForDB() {

        if (isItATicketTable) {
            List<Ticket> tickets = ticketDAO.getAllTickets();
            list.addAll(tickets);
        }

        if (isItAPersonClientTable) {
            List<Personclient> personclients = personclientDAO.getAllPersonclients();
            list.addAll(personclients);
        }

        if (isItATicketRegisterTable) {
            List<Ticketregister> ticketregisters = ticketregisterDAO.getAllTicketregister();
            list.addAll(ticketregisters);
        }

        return list;
    }


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
