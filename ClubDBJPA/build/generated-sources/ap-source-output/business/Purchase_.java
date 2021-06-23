package business;

import business.PCodes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-03T17:04:59")
@StaticMetamodel(Purchase.class)
public class Purchase_ { 

    public static volatile SingularAttribute<Purchase, PCodes> pcodes;
    public static volatile SingularAttribute<Purchase, Date> purchdt;
    public static volatile SingularAttribute<Purchase, Double> amt;
    public static volatile SingularAttribute<Purchase, Long> pid;
    public static volatile SingularAttribute<Purchase, String> purchtype;
    public static volatile SingularAttribute<Purchase, String> transcd;
    public static volatile SingularAttribute<Purchase, String> memid;

}