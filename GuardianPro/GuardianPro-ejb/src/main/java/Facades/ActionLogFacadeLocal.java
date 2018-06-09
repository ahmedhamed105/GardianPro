package Facades;

import Entities.ActionLog;
import Entities.User;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author mohamed.sobhi
 */
@Local
public interface ActionLogFacadeLocal {

    void create(ActionLog actionLog);

    void edit(ActionLog actionLog);

    void remove(ActionLog actionLog);

    ActionLog find(Object id);

    List<ActionLog> findAll();

    List<ActionLog> findRange(int[] range);
    List<ActionLog> getListofLogs(User user , String pagename);
    int count();
    
}