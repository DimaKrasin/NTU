package com.ntu.lab9Example.dao;

import java.sql.Date;
import java.util.List;

import com.ntu.lab9Example.domain.BookRegister;

public interface BookRegisterDAO {	
	
    BookRegister getBookRegisterById(long id);
    List<BookRegister> getBookRegisterByVydanoDt(Date vydanoDt);
    List<BookRegister> getAllBookRegisters();
    boolean insertBookRegister(BookRegister bookRegister);
    boolean updateBookRegister(BookRegister bookRegister);
    boolean deleteBookRegister(long id);

}
