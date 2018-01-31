package test;

import org.hibernate.Session;

public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Assignment a1 = new Assignment();
		a1.setId(10);

		AssignmentExtension ae1 = new AssignmentExtension();
		ae1.setOwner(a1);
		a1.setExtension(ae1);

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
		session.delete(loaded);
		session.getTransaction().commit();
	}

}