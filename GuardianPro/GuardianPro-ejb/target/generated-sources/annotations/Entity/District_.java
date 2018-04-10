package Entity;

import Entity.City;
import Entity.Street;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-10T11:54:33")
@StaticMetamodel(District.class)
public class District_ { 

    public static volatile SingularAttribute<District, String> districtname;
    public static volatile CollectionAttribute<District, Street> streetCollection;
    public static volatile SingularAttribute<District, Integer> id;
    public static volatile SingularAttribute<District, City> cityID;

}