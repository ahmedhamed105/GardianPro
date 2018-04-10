/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.NationalIdHasMaritalStatus;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface NationalIdHasMaritalStatusFacadeLocal {

    void create(NationalIdHasMaritalStatus nationalIdHasMaritalStatus);

    void edit(NationalIdHasMaritalStatus nationalIdHasMaritalStatus);

    void remove(NationalIdHasMaritalStatus nationalIdHasMaritalStatus);

    NationalIdHasMaritalStatus find(Object id);

    List<NationalIdHasMaritalStatus> findAll();

    List<NationalIdHasMaritalStatus> findRange(int[] range);

    int count();
    
}
