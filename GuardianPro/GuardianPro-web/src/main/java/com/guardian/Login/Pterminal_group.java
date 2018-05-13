/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.guardian.Login;

/**
 *
 * @author ahmed.elemam
 */
public class Pterminal_group {
    
       private String name;
       private String serial;
       private String shopname;
       private String pvalue;
       private int  count;
       private int  id;
       private String  type;

    public Pterminal_group(String name, String serial, String shopname, String pvalue, int count, int id, String type) {
        this.name = name;
        this.serial = serial;
        this.shopname = shopname;
        this.pvalue = pvalue;
        this.count = count;
        this.id = id;
        this.type = type;
    }

    public String getPvalue() {
        return pvalue;
    }

    public void setPvalue(String pvalue) {
        this.pvalue = pvalue;
    }


       
       
       

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
       
       
    
}
