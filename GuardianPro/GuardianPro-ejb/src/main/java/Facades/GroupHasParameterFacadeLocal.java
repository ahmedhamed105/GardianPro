/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.GroupHasParameter;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface GroupHasParameterFacadeLocal {

    void create(GroupHasParameter groupHasParameter);

    void edit(GroupHasParameter groupHasParameter);

    void remove(GroupHasParameter groupHasParameter);

    GroupHasParameter find(Object id);

    List<GroupHasParameter> findAll();

    List<GroupHasParameter> findRange(int[] range);

    int count();
    
}
