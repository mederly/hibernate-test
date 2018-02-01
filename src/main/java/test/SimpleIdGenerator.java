package test;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

/**
 * Created by Viliam Repan (lazyman).
 */
public class SimpleIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        ExtBoolean b = (ExtBoolean) object;
        System.out.println("Generated >>>> " + b.isValue() );
        return b.isValue();
    }
}
