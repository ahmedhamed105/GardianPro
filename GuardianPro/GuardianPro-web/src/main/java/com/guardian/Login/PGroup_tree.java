package com.guardian.Login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ahmed.elemam
 */
public class PGroup_tree {
    
    private String parameterGroup;
    private int  count;
    private int  id;
   

    /**
     * Creates a new instance of PGroup_tree
     */
    public PGroup_tree() {
    }
    
        public PGroup_tree(String parameterGroup,int  count,int  id) {
            this.parameterGroup = parameterGroup;
            this.count = count;
            this.id = id;
    }

    public String getParameterGroup() {
        return parameterGroup;
    }

    public void setParameterGroup(String parameterGroup) {
        this.parameterGroup = parameterGroup;
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
    
    
    
    
    
}
