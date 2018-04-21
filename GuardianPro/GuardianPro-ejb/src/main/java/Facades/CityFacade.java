/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.City;
import Entities.Country;
import Entities.UserStatus;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ahmed.ibraheem
 */
@Stateless
public class CityFacade extends AbstractFacade<City> implements CityFacadeLocal {

    @PersistenceContext(unitName = "com.guardianpro_GuardianPro-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CityFacade() {
        super(City.class);
    }
    
    @Override
    public List<City> CountryCity(String country)
    {
        Query cities = em.createNamedQuery("Country.findByCountryname");
        cities.setParameter("countryname", country);
        try {
                List<City>  cityList =  cities.getResultList();     
                return cityList;
        } catch (Exception e) {
            return null;
        }
    }
}

