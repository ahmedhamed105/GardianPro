/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorialspoint.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author ahmed.ibraheem
 */
@Interceptor
public class BusinessInterceptor {
    
     @AroundInvoke
   public Object methodInterceptor(InvocationContext ctx) throws Exception {
      System.out.println("*** Intercepting call to LibraryBean method: " 
      + ctx.getMethod().getName());
      return ctx.proceed();
   }
}
