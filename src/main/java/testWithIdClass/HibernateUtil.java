package testWithIdClass;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();

			configuration.addAnnotatedClass(AssignmentExtension.class);
			configuration.addAnnotatedClass(ExtBoolean.class);
			configuration.addAnnotatedClass(Assignment.class);
			return configuration.configure().buildSessionFactory();
		} catch (Throwable ex) {
			ex.printStackTrace();
			System.exit(0);
			throw new AssertionError();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}

}