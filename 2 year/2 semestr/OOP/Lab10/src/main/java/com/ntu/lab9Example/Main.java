package com.ntu.lab9Example;


import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.ntu.lab9Example.dao.BookDAO;
import com.ntu.lab9Example.dao.BookDAOImpl;
import com.ntu.lab9Example.dao.BookRegisterDAO;
import com.ntu.lab9Example.dao.BookRegisterDAOImpl;
import com.ntu.lab9Example.dao.PersonReaderDAO;
import com.ntu.lab9Example.dao.PersonReaderDAOImpl;
import com.ntu.lab9Example.domain.Book;
import com.ntu.lab9Example.domain.BookRegister;
import com.ntu.lab9Example.domain.PersonReader;

public class Main {

    private static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {

        BookDAO bookDAO = new BookDAOImpl();
        PersonReaderDAO personReaderDAO = new PersonReaderDAOImpl();
        BookRegisterDAO bookRegisterDAO = new BookRegisterDAOImpl();


        while (true) {
            System.out.println("1: додати книгу              8: змінити дані про читача");
            System.out.println("2: додати читача             9: повернули книгу");
            System.out.println("3: додати запис до реєстру   10: список книг");
            System.out.println("4: видалити книгу            11: список читачів");
            System.out.println("5: видалити читача           12: список записів у реєстрі");
            System.out.println("6: видалити запис в реєстрі  13: список неповернених книжок у реєстрі");
            System.out.println("7: змінити дані про книгу    14: список повернених книжок у реєстрі");

            System.out.print("-> ");

            String s = sc.nextLine();
            switch (s) {
                case "1":
                    System.out.print("Внесіть назву книги: ");
                    String title = sc.nextLine();
                    System.out.print("Внесіть автора книги: ");
                    String author = sc.nextLine();
                    System.out.print("Внесіть рік друку книги: ");
                    int printYear = sc.nextInt();
                    System.out.print("Внесіть кількість сторінок книги: ");
                    int countOfPages = sc.nextInt();

                    Book book = new Book(title, author, printYear, countOfPages);
                    bookDAO.insertBook(book);
                    break;
                case "2":
                    System.out.print("Внесіть імя читача: ");
                    String firstName = sc.nextLine();
                    System.out.print("Внесіть по-батькові читача: ");
                    String middleName = sc.nextLine();
                    System.out.print("Внесіть прізвище читача: ");
                    String lastName = sc.nextLine();
                    System.out.print("Внесіть телефон читача: ");
                    String phone = sc.nextLine();
                    System.out.print("Внесіть дату народження читача (yyyy-MM-dd): ");
                    String birthDt = sc.nextLine();
                    System.out.print("Внесіть адресу читача: ");
                    String address = sc.nextLine();
                    System.out.print("Внесіть серію паспорта: ");
                    String serialOfPassport = sc.nextLine();
                    System.out.print("Внесіть номер паспорта: ");
                    int numOfPassport = sc.nextInt();

                    Date birthDtIn = DateUtil.convertStringIntoSqlDate("2018-04-05");
                    PersonReader personReader = new PersonReader(firstName, middleName, lastName, phone, birthDtIn, serialOfPassport, numOfPassport, address);
                    personReaderDAO.insertPersonReader(personReader);
                    break;
                case "3":
                    System.out.print("Внесіть дату видачі (yyyy-MM-dd): ");
                    String vydanoDt = sc.nextLine();
                    System.out.print("Внесіть ID книги: ");
                    int bookId = sc.nextInt();
                    System.out.print("Внесіть ID читача: ");
                    int personReaderId = sc.nextInt();


                    Book bookFromDB = bookDAO.getBookById(bookId);
                    PersonReader personReaderFromDB = personReaderDAO.getPersonReaderById(personReaderId);

                    Date vydanoDtIn = DateUtil.convertStringIntoSqlDate(vydanoDt);
                    BookRegister bookRegister = new BookRegister(bookFromDB, vydanoDtIn, personReaderFromDB);
                    bookRegisterDAO.insertBookRegister(bookRegister);

                    break;
                case "4":
                    System.out.print("Внесіть ID книги: ");
                    int bookIdDel = sc.nextInt();
                    bookDAO.deleteBook(bookIdDel);

                    break;
                case "5":
                    System.out.print("Внесіть ID читача: ");
                    int personReaderIdDel = sc.nextInt();
                    personReaderDAO.deletePersonReader(personReaderIdDel);
                    break;
                case "6":
                    System.out.print("Внесіть ID запису реєстру: ");
                    int bookRegisterIdDel = sc.nextInt();
                    bookRegisterDAO.deleteBookRegister(bookRegisterIdDel);
                    break;
                case "7":
                    System.out.print("Внесіть ID книги: ");
                    int bookIdToUpdate = sc.nextInt();

                    Book bookToUpdate = bookDAO.getBookById(bookIdToUpdate);

                    System.out.print("Внесіть назву книги: ");
                    bookToUpdate.setTitle(sc.nextLine());
                    System.out.print("Внесіть автора книги: ");
                    bookToUpdate.setAuthor(sc.nextLine());
                    System.out.print("Внесіть рік друку книги: ");
                    bookToUpdate.setPrintYear(sc.nextInt());
                    System.out.print("Внесіть кількість сторінок книги: ");
                    bookToUpdate.setCountOfPages(sc.nextInt());

                    bookDAO.updateBook(bookToUpdate);

                    break;
                case "8":

                    System.out.print("Внесіть ID читача: ");
                    int personReaderIdUpdate = sc.nextInt();

                    PersonReader personReaderToUpdate = personReaderDAO.getPersonReaderById(personReaderIdUpdate);

                    System.out.print("Внесіть імя читача: ");
                    personReaderToUpdate.setFirstName(sc.nextLine());
                    System.out.print("Внесіть по-батькові читача: ");
                    personReaderToUpdate.setLastName( sc.nextLine());
                    System.out.print("Внесіть прізвище читача: ");
                    personReaderToUpdate.setMiddleName( sc.nextLine());
                    System.out.print("Внесіть телефон читача: ");
                    personReaderToUpdate.setPhone( sc.nextLine());
                    System.out.print("Внесіть дату народження читача (yyyy-MM-dd): ");
                    String birthDtToUpdate = sc.nextLine();
                    Date birthDtInToUpdate = DateUtil.convertStringIntoSqlDate(birthDtToUpdate);
                    personReaderToUpdate.setBirthDt(birthDtInToUpdate);
                    System.out.print("Внесіть адресу читача: ");
                    personReaderToUpdate.setAddress(sc.nextLine());
                    System.out.print("Внесіть серію паспорта: ");
                    personReaderToUpdate.setSerialOfPassport( sc.nextLine());
                    System.out.print("Внесіть номер паспорта: ");
                    personReaderToUpdate.setNumOfPassport( sc.nextInt());

                    personReaderDAO.updatePersonReader(personReaderToUpdate);

                    break;
                case "9":

                    System.out.print("Внесіть ID запису реєстру: ");
                    int bookRegisterIdPoverneno = sc.nextInt();

                    BookRegister bookRegisterPoverneno = bookRegisterDAO.getBookRegisterById(bookRegisterIdPoverneno);

                    System.out.print("Внесіть дату поверненя книги (yyyy-MM-dd): ");
                    String povernenoDt= sc.nextLine();
                    Date povernenoDtIn = DateUtil.convertStringIntoSqlDate(povernenoDt);

                    bookRegisterPoverneno.setPovernenoDt(povernenoDtIn);

                    bookRegisterDAO.updateBookRegister(bookRegisterPoverneno);
                    break;
                case "10":
                    List<Book> books = bookDAO.getAllBooks();
                    for (Book item : books) {
                        System.out.println(item);
                    }
                    break;
                case "11":
                    List<PersonReader> personReaders = personReaderDAO.getAllPersonReaders();
                    for (PersonReader item : personReaders) {
                        System.out.println(item);
                    }
                    break;
                case "12":
                    List<BookRegister> bookRegisters = bookRegisterDAO.getAllBookRegisters();
                    for (BookRegister item : bookRegisters) {
                        System.out.println(item);
                    }
                    break;
                case "13":

                    List<BookRegister> bookRegistersNePoverneno = bookRegisterDAO.getAllBookRegisters();

                    for (BookRegister item : bookRegistersNePoverneno) {
                        if(item.getPovernenoDt() == null) {
                            System.out.println(item);
                        }
                    }

                    break;
                case "14":

                    List<BookRegister> bookRegistersPoverneno = bookRegisterDAO.getAllBookRegisters();

                    for (BookRegister item : bookRegistersPoverneno) {
                        if(item.getPovernenoDt() != null) {
                            System.out.println(item);
                        }
                    }

                    break;
                default:
                    return;
            }

        }

    }

}
