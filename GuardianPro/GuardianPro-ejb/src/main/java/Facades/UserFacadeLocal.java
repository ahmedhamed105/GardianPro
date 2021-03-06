/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

//import Entities.Groups;
import Entities.PasswordHistory;
import Entities.ProfileData;
//import Entities.Role;
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
//<<<<<<< HEAD
//<<<<<<< HEAD
    String password_username(String Username);
    Collection<PasswordHistory> passwordHistory_username(String Username);
//=======
    Collection<ProfileData> userProfile_username(String Username);
    //User password_username(String Username);

//    User password_username(String Username);
   
//    Collection<PasswordHistory> passwordHistory_username(String Username); 
 
    int user_status(User User1);
//    Collection<Groups> groupsByUser(String Username);
   // Collection<Role> rolesOfUser(String Username);
    
    boolean user_find(String user);
}
