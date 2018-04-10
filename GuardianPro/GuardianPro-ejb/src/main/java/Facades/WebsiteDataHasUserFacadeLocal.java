/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.WebsiteDataHasUser;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface WebsiteDataHasUserFacadeLocal {

    void create(WebsiteDataHasUser websiteDataHasUser);

    void edit(WebsiteDataHasUser websiteDataHasUser);

    void remove(WebsiteDataHasUser websiteDataHasUser);

    WebsiteDataHasUser find(Object id);

    List<WebsiteDataHasUser> findAll();

    List<WebsiteDataHasUser> findRange(int[] range);

    int count();
    
}
