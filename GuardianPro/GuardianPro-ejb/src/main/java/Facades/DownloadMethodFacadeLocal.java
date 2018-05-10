/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.DownloadMethod;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface DownloadMethodFacadeLocal {

    void create(DownloadMethod downloadMethod);

    void edit(DownloadMethod downloadMethod);

    void remove(DownloadMethod downloadMethod);

    DownloadMethod find(Object id);

    List<DownloadMethod> findAll();

    List<DownloadMethod> findRange(int[] range);

    int count();
    
}
