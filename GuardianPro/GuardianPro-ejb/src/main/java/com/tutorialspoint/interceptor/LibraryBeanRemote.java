/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorialspoint.interceptor;

import com.tutorialspoint.test.Book;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface LibraryBeanRemote {
    
  
    void addBook(String bookName);
    List getBooks();
    public void addBook(Book book);

    
}
