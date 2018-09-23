/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.timer.schedual;

import Entities.TgroupHasTerminal;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */

@Local
public interface business {
    
    public void execute(TgroupHasTerminal d);
    
}
