package com.ntu.Lab9.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ntu.Lab9.ConnectionFactory;
import com.ntu.Lab9.domain.Book;
import com.ntu.Lab9.domain.BookRegister;
import com.ntu.Lab9.domain.PersonReader;


public class BookRegisterDAOImpl implements BookRegisterDAO {

	@Override
	public BookRegister getBookRegisterById(long id) {
          //try-with-resources 
        try (Connection connection = ConnectionFactory.getConnection();
        	 Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM bookRegister WHERE id=" + id);
        		)
        	{

            

            if(rs.next())
            {
               ///для зручності перенесли даний код у приватний метод extractBookRegisterFromResultSet
            	/*
                 BookRegister bookRegister = new BookRegister();
                 bookRegister.setId(rs.getLong("id"));
                 bookRegister.setBook( (Book)rs.getObject("book") );
                 bookRegister.setVydanoDt( rs.getDate("vydanoDt"));                
                 bookRegister.setPersonReader( (PersonReader)rs.getObject("personReader") );
                 bookRegister.setPovernenoDt( rs.getDate("povernenoDt")); 
         
             
                 return bookRegister;
                */
            	
            	return extractBookRegisterFromResultSet(rs);
            	

            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
     

      return null;
	}

	@Override
	public List<BookRegister> getBookRegisterByVydanoDt(Date vydanoDt) {
		   
            //try-with-resources 
	        try (Connection connection = ConnectionFactory.getConnection();
	        	PreparedStatement ps = connection.prepareStatement("SELECT * FROM bookRegister WHERE vydanoDt=? "))
	        {

	            ps.setDate(1, vydanoDt);
	            
	            ResultSet rs = ps.executeQuery();
	            
	            List<BookRegister> bookRegisters = new ArrayList<>(); 

	            while(rs.next())
	            {
                   BookRegister bookRegister = extractBookRegisterFromResultSet(rs);
                   bookRegisters.add(bookRegister);  //додаємо 
	            }
	            
	            return bookRegisters; //повертаємо список
	            
	        } catch (SQLException ex) {
	            ex.printStackTrace();

	        }
	        

	      return null;
	}

	@Override
	public List<BookRegister> getAllBookRegisters() {
	
		   //try-with-resources 
	        try (Connection connection = ConnectionFactory.getConnection();
	        	 Statement stmt = connection.createStatement();
		         ResultSet rs = stmt.executeQuery("SELECT * FROM bookRegister");
	        		)
	        	{	    	  
		            
		            List<BookRegister> bookRegisters = new ArrayList<>(); //змінна для формування списку

		            while(rs.next())
		            {
	                   BookRegister bookRegister = extractBookRegisterFromResultSet(rs);
	                   bookRegisters.add(bookRegister);  //додаємо
		            }
		            
		            return bookRegisters; //повертаємо список
		            
		        } catch (SQLException ex) {
		            ex.printStackTrace();

		        }

		      return null;
	}

	@Override
	public boolean insertBookRegister(BookRegister bookRegister) {
				
		//try-with-resources 
        try (Connection connection = ConnectionFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(""
            		+ "INSERT INTO bookRegister(bookId, vydanoDt, personReaderId, povernenoDt) "
            		+ "VALUES (?, ?, ?, ?)");
        	)
       	{
      
	        ps.setLong(1, bookRegister.getBook().getId());
            ps.setDate(2, bookRegister.getVydanoDt());
            ps.setLong(3, bookRegister.getPersonReader().getId());
            ps.setDate(4, bookRegister.getPovernenoDt());    

	        int i = ps.executeUpdate(); // for INSERT, UPDATE & DELETE

	      if(i == 1) {

	        return true;

	      }

	    } catch (SQLException ex) {

	        ex.printStackTrace();

	    }

	    return false;
	}

	@Override
	public boolean updateBookRegister(BookRegister bookRegister) {
		
        //try-with-resources 
       try (Connection connection = ConnectionFactory.getConnection();
    		PreparedStatement ps = connection.prepareStatement(""
    				+ " UPDATE bookRegister"
    				+ "    set bookId = ?, vydanoDt = ?, personReaderId = ?, povernenoDt = ? "
    				+ " WHERE id=?");
	      )
	    {   
    	
    	     ps.setLong(1, bookRegister.getBook().getId());
             ps.setDate(2, bookRegister.getVydanoDt());
             ps.setLong(3, bookRegister.getPersonReader().getId());
             ps.setDate(4, bookRegister.getPovernenoDt());      
            ps.setLong(5, bookRegister.getId());  

	        int i = ps.executeUpdate(); // for INSERT, UPDATE & DELETE

	      if(i == 1) {

	        return true;

	      }

	    } catch (SQLException ex) {

	        ex.printStackTrace();

	    }

	    return false;
	}

	@Override
	public boolean deleteBookRegister(long id) {
		
		  //try-with-resources 
	       try (Connection connection = ConnectionFactory.getConnection();
	    		PreparedStatement ps = connection.prepareStatement("DELETE FROM bookRegister WHERE id=?");
		      )
		    {   

	            ps.setLong(1, id);  

		        int i = ps.executeUpdate(); // for INSERT, UPDATE & DELETE

		      if(i == 1) {

		        return true;

		      }

		    } catch (SQLException ex) {

		        ex.printStackTrace();

		    }

		    return false;
	}

	private BookRegister extractBookRegisterFromResultSet(ResultSet rs) throws SQLException {
		
		BookDAO bookDAO =  new BookDAOImpl();	
    	PersonReaderDAO personReaderDAO =  new PersonReaderDAOImpl();
    	
    	Book book = bookDAO.getBookById(rs.getLong("bookid"));
    	PersonReader personReader = personReaderDAO.getPersonReaderById(rs.getLong("personReaderid"));

		 BookRegister bookRegister = new BookRegister();
         bookRegister.setId(rs.getLong("id"));
         bookRegister.setBook( book );
         bookRegister.setVydanoDt( rs.getDate("vydanoDt"));                
         bookRegister.setPersonReader( personReader);
         bookRegister.setPovernenoDt( rs.getDate("povernenoDt")); 
         
             
         return bookRegister;

	}

}
