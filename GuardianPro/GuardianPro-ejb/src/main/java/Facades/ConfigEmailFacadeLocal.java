/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.ConfigEmail;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface ConfigEmailFacadeLocal {

    void create(ConfigEmail configEmail);

    void edit(ConfigEmail configEmail);

    void remove(ConfigEmail configEmail);

    ConfigEmail find(Object id);

    List<ConfigEmail> findAll();

    List<ConfigEmail> findRange(int[] range);

    int count();
    
    boolean email_find(String displayname);
    
}
