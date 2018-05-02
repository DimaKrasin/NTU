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
	


    public static void main(String[] args)  {
    	
    	BookDAO bookDAO =  new BookDAOImpl();
    	PersonReaderDAO personReaderDAO =  new PersonReaderDAOImpl();
    	BookRegisterDAO bookRegisterDAO =  new BookRegisterDAOImpl();
    	
    	  Scanner sc = new Scanner(System.in);
    	  
    	  while (true) {
    		  System.out.println("1: ������ �����              8: ������ ��� ��� ������");
              System.out.println("2: ������ ������             9: ��������� �����");
              System.out.println("3: ������ ����� �� ������   10: ������ ����");
              System.out.println("4: �������� �����            11: ������ �������");
              System.out.println("5: �������� ������           12: ������ ������ � �����");
              System.out.println("6: �������� ����� � �����  13: ������ ������������ ������ � �����");
              System.out.println("7: ������ ��� ��� �����    14: ������ ���������� ������ � �����");

              System.out.print("-> ");

              String s = sc.nextLine();
              switch (s) {
                  case "1":
                	  System.out.print("������ ����� �����: ");
                      String title = sc.nextLine();
                      System.out.print("������ ������ �����: ");
                      String author = sc.nextLine();
                      System.out.print("������ �� ����� �����: ");
                      int printYear = sc.nextInt();
                      System.out.print("������ ������� ������� �����: ");
                      int countOfPages = sc.nextInt();
                      
                	  Book book = new Book(title, author, printYear, countOfPages );    	
                  	  bookDAO.insertBook(book);
                      break;
                  case "2":
                	  System.out.print("������ ��� ������: ");
                      String firstName = sc.nextLine();
                      System.out.print("������ ��-������� ������: ");
                      String middleName = sc.nextLine();
                      System.out.print("������ ������� ������: ");
                      String lastName = sc.nextLine();
                      System.out.print("������ ������� ������: ");
                      String phone = sc.nextLine();
                      System.out.print("������ ���� ���������� ������ (yyyy-MM-dd): ");
                      String birthDt = sc.nextLine();
                      System.out.print("������ ������ ������: ");
                      String address = sc.nextLine();
                      System.out.print("������ ���� ��������: ");
                      String serialOfPassport = sc.nextLine();
                      System.out.print("������ ����� ��������: ");
                      int numOfPassport = sc.nextInt();                 
                      
                      Date birthDtIn = DateUtil.convertStringIntoSqlDate("2018-04-05");
                      PersonReader personReader = new PersonReader(firstName, middleName, lastName, phone, birthDtIn, serialOfPassport, numOfPassport, address );
                      personReaderDAO.insertPersonReader(personReader);
                      break;
                  case "3":
                	  System.out.print("������ ���� ������ (yyyy-MM-dd): ");
                      String vydanoDt = sc.nextLine();
                	  System.out.print("������ ID �����: ");
                      int bookId = sc.nextInt();                
                      System.out.print("������ ID ������: ");
                      int personReaderId = sc.nextInt();
                     
                      
                      Book bookFromDB = bookDAO.getBookById(bookId);
                      PersonReader personReaderFromDB = personReaderDAO.getPersonReaderById(personReaderId);
                      
                	  Date vydanoDtIn = DateUtil.convertStringIntoSqlDate(vydanoDt);                  	
                  	  BookRegister bookRegister = new BookRegister(bookFromDB, vydanoDtIn, personReaderFromDB);
                  	  bookRegisterDAO.insertBookRegister(bookRegister);
                      
                      break;
                  case "4":
                	  System.out.print("������ ID �����: ");
                      int bookIdDel = sc.nextInt();
                      bookDAO.deleteBook(bookIdDel);
                     
                      break;
                  case "5":
                	  System.out.print("������ ID ������: ");
                      int personReaderIdDel = sc.nextInt();
                      personReaderDAO.deletePersonReader(personReaderIdDel);
                      break;
                  case "6":
                	  System.out.print("������ ID ������ ������: ");
                      int bookRegisterIdDel = sc.nextInt();
                      bookRegisterDAO.deleteBookRegister(bookRegisterIdDel);
                      break;
                  case "7":
                     
                      break;
                  case "8":
                     
                      break;
                  case "9":
                    
                      break;
                  case "10":
                	  List<Book> books = bookDAO.getAllBooks();
                	  for(Book item: books) {
                		  System.out.println(item);
                	  }                      
                      break;
                  case "11":
                	  List<PersonReader> personReaders = personReaderDAO.getAllPersonReaders();
                	  for(PersonReader item: personReaders) {
                		  System.out.println(item);
                	  }   
                      break;
                  case "12":
                	  List<BookRegister> bookRegisters = bookRegisterDAO.getAllBookRegisters();
                	  for(BookRegister item: bookRegisters) {
                		  System.out.println(item);
                	  } 
                      break;
                  case "13":
                 
                      break;
                  case "14":
                     
                      break;
                  default:
                	 return;
              }

          }	  
    	
    }

}
