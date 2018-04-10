/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.ArmyArea;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface ArmyAreaFacadeLocal {

    void create(ArmyArea armyArea);

    void edit(ArmyArea armyArea);

    void remove(ArmyArea armyArea);

    ArmyArea find(Object id);

    List<ArmyArea> findAll();

    List<ArmyArea> findRange(int[] range);

    int count();
    
}
