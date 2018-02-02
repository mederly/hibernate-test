package simpleWithCustomPersister;

import org.hibernate.HibernateException;
import org.hibernate.cache.spi.access.EntityRegionAccessStrategy;
import org.hibernate.cache.spi.access.NaturalIdRegionAccessStrategy;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.hibernate.persister.spi.PersisterCreationContext;

import java.io.Serializable;

/**
 * Ugly hack. Not very clean, e.g. because it makes transient instances look like detached ones
 * (because of using default ID unsaved-value strategy). It might bring other problems as well.
 */
public class IdProvidingSingleTableEntityPersister extends SingleTableEntityPersister {

	public IdProvidingSingleTableEntityPersister(PersistentClass persistentClass,
			EntityRegionAccessStrategy cacheAccessStrategy,
			NaturalIdRegionAccessStrategy naturalIdRegionAccessStrategy,
			PersisterCreationContext creationContext) throws HibernateException {
		super(persistentClass, cacheAccessStrategy, naturalIdRegionAccessStrategy, creationContext);
	}

	@Override
	public boolean hasIdentifierProperty() {
		return true;
	}

	@Override
	public Serializable getIdentifier(Object entity, SharedSessionContractImplementor session) {
		return (Serializable) entity;
	}
}
