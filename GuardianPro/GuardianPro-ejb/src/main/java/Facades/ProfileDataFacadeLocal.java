/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.ProfileData;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface ProfileDataFacadeLocal {

    void create(ProfileData profileData);

    void edit(ProfileData profileData);

    void remove(ProfileData profileData);

    ProfileData find(Object id);

    List<ProfileData> findAll();

    List<ProfileData> findRange(int[] range);

    int count();
    
}
