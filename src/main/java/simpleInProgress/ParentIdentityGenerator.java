package simpleInProgress;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

import java.io.Serializable;

public class ParentIdentityGenerator extends IdentityGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object obj) {
		return ((Child) obj).getParent();
	}

}