/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.WebsiteData;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface WebsiteDataFacadeLocal {

    void create(WebsiteData websiteData);

    void edit(WebsiteData websiteData);

    void remove(WebsiteData websiteData);

    WebsiteData find(Object id);

    List<WebsiteData> findAll();

    List<WebsiteData> findRange(int[] range);

    int count();
    
}
