package com.ntu.lab9;

import com.ntu.lab9.dao.ConversationDAO;
import com.ntu.lab9.dao.ConversationDAOImpl;
import com.ntu.lab9.dao.SubscriberDAO;
import com.ntu.lab9.dao.SubscriberDAOImpl;
import com.ntu.lab9.entitys.Conversation;
import com.ntu.lab9.entitys.Subscriber;

import java.util.List;
import java.util.Scanner;

public class Main2 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String regex = "[0-9]+";

        SubscriberDAO subscriberDAO = new SubscriberDAOImpl();
        ConversationDAO conversationDAO = new ConversationDAOImpl();


        while (true) {
            System.out.println("1: ������ ��������");
            System.out.println("2: �������� ��������");
            System.out.println("3: ������ ��� ��� ��������");
            System.out.println("4: ������� ��� ������� ��������");
            System.out.println("5: ��������� ���������");

            System.out.print("-> ");

            String s = sc.nextLine();
            switch (s) {
                case "1":
                    System.out.print("������ ����� ��������: ");
                    String number = sc.nextLine();

                    //validation and add
                    if (number.length() == 7) {
                        if (number.matches(regex)) {
                            Subscriber subscriber = new Subscriber(number);
                            subscriberDAO.insertSubscriber(subscriber);
                        } else {
                            System.out.println("� ������ ������ ���� ������ �����");
                        }
                    } else {
                        System.out.println("�������� ����� ������!");
                    }


                    break;
                case "2":
                    System.out.print("������ ID(�����) ��������: ");
                    String numberToDelete = sc.nextLine();

                    //validation and delete
                    if (numberToDelete.length() == 7) {
                        if (numberToDelete.matches(regex)) {
                            subscriberDAO.deleteSubscriber(numberToDelete);
                        } else {
                            System.out.println("� ������ ������ ���� ������ �����");
                        }
                    } else {
                        System.out.println("�������� ����� ������!");
                    }

                    break;
                case "3":

                    System.out.print("������ ID(�����) ��������: ");
                    String numberToUpdate = sc.nextLine();

                    Subscriber subscriberToUpdate = null;

                    //validation and get
                    if (numberToUpdate.length() == 7) {
                        if (numberToUpdate.matches(regex)) {


                            subscriberToUpdate = subscriberDAO.getSubscriberById(numberToUpdate);


                        } else {
                            System.out.println("� ������ ������ ���� ������ �����");
                        }
                    } else {
                        System.out.println("�������� ����� ������!");
                    }

                    System.out.print("������ ����� ID(�����) ��������: ");
                    String newNumberToUpdate = sc.nextLine();

                    //validation and get
                    if (numberToUpdate.length() == 7) {
                        if (numberToUpdate.matches(regex)) {

                            subscriberToUpdate.setNumber(newNumberToUpdate);
                            subscriberDAO.updateSubscriber(subscriberToUpdate);


                        } else {
                            System.out.println("� ������ ������ ���� ������ �����");
                        }
                    } else {
                        System.out.println("�������� ����� ������!");
                    }

                    break;
                case "4":

                    List<Subscriber> subs = subscriberDAO.getAllSubscriber();
                    for (Subscriber item : subs) {
                        System.out.println(item.getNumber());
                    }

                    break;
                case "5":

                    System.out.print("������ ����� �������� ������� ������: ");
                    String numberWhoCall = sc.nextLine();

                    System.out.print("������ ����� �������� �������� ������: ");
                    String numberForWhoCall = sc.nextLine();

                    //validation and add
                    if (numberWhoCall.length() == 7 & numberForWhoCall.length() == 7) {
                        if (numberWhoCall.matches(regex) & numberForWhoCall.matches(regex)) {

                            Subscriber subscriberWhoCall = subscriberDAO.getSubscriberById(numberWhoCall);
                            Subscriber subscriberForWhoCall = subscriberDAO.getSubscriberById(numberForWhoCall);

                            if (subscriberWhoCall.isAvailable() & subscriberForWhoCall.isAvailable()) {

                                subscriberWhoCall.setAvailable(false);
                                subscriberForWhoCall.setAvailable(false);

                                subscriberWhoCall.call(subscriberForWhoCall);
                                Conversation conversation = new Conversation(subscriberWhoCall.getNumber()
                                        , subscriberForWhoCall.getNumber());

                                conversationDAO.insertConversation(conversation);

                                subscriberWhoCall.setAvailable(true);
                                subscriberForWhoCall.setAvailable(true);
                            }
                        } else {
                            System.out.println("� ������ ������ ���� ������ �����");
                        }
                    } else {
                        System.out.println("�������� ����� ������!");
                    }

                    break;
                default:
                    return;
            }

        }

    }

}
