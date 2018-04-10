package Entity;

import Entity.NationalId;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-10T11:54:33")
@StaticMetamodel(Religion.class)
public class Religion_ { 

    public static volatile CollectionAttribute<Religion, NationalId> nationalIdCollection;
    public static volatile SingularAttribute<Religion, Integer> id;
    public static volatile SingularAttribute<Religion, String> religionName;

}