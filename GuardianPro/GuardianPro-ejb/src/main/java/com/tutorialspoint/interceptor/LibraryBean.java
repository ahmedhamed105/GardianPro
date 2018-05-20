/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorialspoint.interceptor;

import com.tutorialspoint.test.Book;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

/**
 *
 * @author ahmed.ibraheem
 */
@Interceptors ({BusinessInterceptor.class})
@Stateless
public class LibraryBean implements LibraryBeanRemote{
    
    List<String> bookShelf;    

   public LibraryBean(){
      bookShelf = new ArrayList<String>();
   }

   public void addBook(String bookName) {
      bookShelf.add(bookName);
   } 
   
   public void addBook(Book book) {
      //bookShelf.add(bookName);
   } 

   public List<String> getBooks() {
      return bookShelf;
   }   
}
