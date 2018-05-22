/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.GroupsHasUser;
import Entities.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface GroupsHasUserFacadeLocal {

    void create(GroupsHasUser groupsHasUser);

    void edit(GroupsHasUser groupsHasUser);

    void remove(GroupsHasUser groupsHasUser);

    GroupsHasUser find(Object id);

    List<GroupsHasUser> findAll();

    List<GroupsHasUser> findRange(int[] range);

    int count();
    
    List<GroupsHasUser> find_groups_by_user(User user);
    
}
