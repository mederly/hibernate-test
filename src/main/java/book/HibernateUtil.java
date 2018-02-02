package book;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import simple.Child;
import simple.Parent;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(Author.class);
			configuration.addAnnotatedClass(Publisher.class);
			configuration.addAnnotatedClass(Book.class);
			return configuration.configure().buildSessionFactory();
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		getSessionFactory().close();
	}

}