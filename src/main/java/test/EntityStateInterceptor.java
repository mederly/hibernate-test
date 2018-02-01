package test;

import org.hibernate.EmptyInterceptor;

/**
 * Created by Viliam Repan (lazyman).
 */
public class EntityStateInterceptor extends EmptyInterceptor {

    @Override
    public Boolean isTransient(Object entity) {
        if (entity instanceof EntityState) {
            return ((EntityState) entity).isTransient();
        }
        return null;
    }
}
