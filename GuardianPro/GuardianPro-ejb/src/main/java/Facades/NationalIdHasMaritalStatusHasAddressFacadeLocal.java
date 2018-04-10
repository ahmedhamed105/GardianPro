/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.NationalIdHasMaritalStatusHasAddress;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface NationalIdHasMaritalStatusHasAddressFacadeLocal {

    void create(NationalIdHasMaritalStatusHasAddress nationalIdHasMaritalStatusHasAddress);

    void edit(NationalIdHasMaritalStatusHasAddress nationalIdHasMaritalStatusHasAddress);

    void remove(NationalIdHasMaritalStatusHasAddress nationalIdHasMaritalStatusHasAddress);

    NationalIdHasMaritalStatusHasAddress find(Object id);

    List<NationalIdHasMaritalStatusHasAddress> findAll();

    List<NationalIdHasMaritalStatusHasAddress> findRange(int[] range);

    int count();
    
}
