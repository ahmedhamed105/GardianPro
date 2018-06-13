/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author mohammed.ayad
 */
public class Constants {

    public static final String JNDI_GLOBAL_SEPARATOR = "/";
    public static final String JNDI_GLOBAL_PREFIX = "java:global"
            .concat(JNDI_GLOBAL_SEPARATOR);
    public static final String JNDI_GLOBAL_APP_NAME = JNDI_GLOBAL_PREFIX
            .concat("GuardianPro-ear").concat(JNDI_GLOBAL_SEPARATOR);
    public static final String JNDI_GLOBAL_BUSINESS_MODULE_NAME = JNDI_GLOBAL_APP_NAME
            .concat("GuardianPro-ejb-1.0-SNAPSHOT").concat(JNDI_GLOBAL_SEPARATOR);

    /*start mohammed.ayad 11/6/2018*/
    public static Object lookupEJB(String beanName) {
        String serviceJNDI = getServiceJNDI(beanName);
        System.out.println("service JNDI "+serviceJNDI);
        Object ejbObject = lookup(serviceJNDI);
        return ejbObject;
    }

    public static String getServiceJNDI(String beanName) {
        return JNDI_GLOBAL_BUSINESS_MODULE_NAME + beanName;
    }

    private static Object lookup(String jNDIName) {
        Object ejbObject = null;
        try {
            Context context = getContext();
            ejbObject = context.lookup(jNDIName);
        } catch (NamingException ex) {
            System.err.println(ex);
        }
        return ejbObject;
    }
    
    private static Context getContext() throws NamingException {
		Context context;
		context = new InitialContext();
		return context;
	}

}
