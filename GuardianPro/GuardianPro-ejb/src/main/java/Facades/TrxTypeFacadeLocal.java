/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.TrxType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface TrxTypeFacadeLocal {

    void create(TrxType trxType);

    void edit(TrxType trxType);

    void remove(TrxType trxType);

    TrxType find(Object id);

    List<TrxType> findAll();

    List<TrxType> findRange(int[] range);

    int count();
    
}
