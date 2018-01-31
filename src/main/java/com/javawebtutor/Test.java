package com.javawebtutor;

import java.util.Date;

import org.hibernate.Session;

public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		User user = new User();

		user.setUserId(1);
		user.setUsername("pavol");
		user.setCreatedBy("java");
		user.setCreatedDate(new Date());

		Assignment a1 = new Assignment();
		a1.setOwner(user);
		a1.setId(10);
		user.getAssignments().add(a1);

		AssignmentExtension ae1 = new AssignmentExtension();
		ae1.setOwner(a1);
		a1.setExtension(ae1);

		ExtBoolean eb = new ExtBoolean();
		eb.setOwner(ae1);
		ae1.getBooleans().add(eb);
		eb.setValue(true);

		session.persist(user);
		session.getTransaction().commit();

		session.close();

		System.out.println("**********************************************************************************");
		session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();
		User loaded = session.get(User.class, 1);
		session.delete(loaded);
		session.getTransaction().commit();
	}

}