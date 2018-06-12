/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Groups;
import Entities.Role;
import Entities.RoleHasGroups;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface RoleHasGroupsFacadeLocal {

    void create(RoleHasGroups roleHasGroups);

    void edit(RoleHasGroups roleHasGroups);

    void remove(RoleHasGroups roleHasGroups);

    RoleHasGroups find(Object id);

    List<RoleHasGroups> findAll();

    List<RoleHasGroups> findRange(int[] range);

    int count();
    
    List<RoleHasGroups> find_role_by_group(Groups group);
    
    RoleHasGroups findByGroupRole(Groups group,Role role);
}
