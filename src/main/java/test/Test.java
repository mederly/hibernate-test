package test;

import org.hibernate.Session;

import java.util.Set;

public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Assignment a1 = new Assignment();
		a1.setId(10);

		AssignmentExtension ae1 = new AssignmentExtension();
		ae1.setOwner(a1);
		a1.getExtensions().add(ae1);

		ExtBoolean eb = new ExtBoolean();
		eb.setOwner(ae1);
		ae1.getBooleans().add(eb);
		eb.setValue(true);

		session.persist(a1);
		session.getTransaction().commit();

		session.close();

		System.out.println("**********************************************************************************");
		session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		Assignment loaded = session.get(Assignment.class, 10);
		AssignmentExtension assignmentExtension = loaded.getExtensions().iterator().next();
		Set<ExtBoolean> booleans = assignmentExtension.getBooleans();
		if (booleans.size() != 1) {
			throw new AssertionError("Unexpected size of booleans collection: " + booleans.size());
		}
		// temporary
		for (ExtBoolean extBoolean : booleans) {
			System.out.println("+++++++++++ deleting " + extBoolean);
			session.delete(extBoolean);
		}
		session.delete(loaded);
		session.getTransaction().commit();
	}

}