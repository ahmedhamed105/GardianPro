/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.ParmeterSchema;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.elemam
 */
@Local
public interface ParmeterSchemaFacadeLocal {

    void create(ParmeterSchema parmeterSchema);

    void edit(ParmeterSchema parmeterSchema);

    void remove(ParmeterSchema parmeterSchema);

    ParmeterSchema find(Object id);

    List<ParmeterSchema> findAll();

    List<ParmeterSchema> findRange(int[] range);

    int count();
    
}
