/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.PasswordHistory;
import Entities.ProfileData;
import Entities.User;
import java.util.Collection;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ahmed.ibraheem
 */
@Local
public interface UserFacadeLocal {

    void create(User user);

    void edit(User user);

    void remove(User user);

    User find(Object id);

    List<User> findAll();

    List<User> findRange(int[] range);

    int count();
    
    List<User> search_username(String Username);
<<<<<<< HEAD
//<<<<<<< HEAD
    String password_username(String Username);
    Collection<PasswordHistory> passwordHistory_username(String Username);
//=======
    Collection<ProfileData> userProfile_username(String Username);
    //User password_username(String Username);
=======

    User password_username(String Username);
>>>>>>> c5a3aec9de58765935c07ecd939fe48dbfd9eb9f
    
    Collection<PasswordHistory> passwordHistory_username(String Username); 
 
    int user_status(User User1);
<<<<<<< HEAD
//>>>>>>> 7b65abc5e2d720a09de775c71c2f3e8ac0200a6d
=======

>>>>>>> c5a3aec9de58765935c07ecd939fe48dbfd9eb9f
}
