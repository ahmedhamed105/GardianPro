/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.ConfigParmeter;
import Entities.TerminalParserLog;
import Entities.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author mohammed.ayad
 */
@Stateless
public class TerminalParserLogFacade extends AbstractFacade<TerminalParserLog> implements TerminalParserLogFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TerminalParserLogFacade() {
        super(TerminalParserLog.class);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public void saveNewTerminalLog(TerminalParserLog parserLog) {
        User user = em.find(User.class, 1);
        System.out.println("user name >>>>> " + user.getFirstName());
        parserLog.setUserId(user);
        create(parserLog);

    }

    @Override
    public ConfigParmeter loadTimerParserParametes(String parameterName, String parameterValue) {
        try {
            TypedQuery<ConfigParmeter> query = em.createNamedQuery(ConfigParmeter.NAMED_QUERY_FIND_BY_PARAMETER, ConfigParmeter.class);
            query.setParameter(parameterName, parameterValue);
            ConfigParmeter result = query.getSingleResult();
            return result;
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void refresh(ConfigParmeter configParmeter) {
        em.refresh(configParmeter);
    }
}
