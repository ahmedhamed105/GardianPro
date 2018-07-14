package Entities;

import Entities.LogScreen;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-12T12:29:54")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-11T15:15:06")
>>>>>>> 607240f5272387efdb26ec8ed872c6fb36ba9ac9
@StaticMetamodel(TrxType.class)
public class TrxType_ { 

    public static volatile SingularAttribute<TrxType, Date> updateDate;
    public static volatile SingularAttribute<TrxType, String> tType;
    public static volatile CollectionAttribute<TrxType, LogScreen> logScreenCollection;
    public static volatile SingularAttribute<TrxType, Integer> id;
    public static volatile SingularAttribute<TrxType, Date> createDate;

}