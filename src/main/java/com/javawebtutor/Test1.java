package com.javawebtutor;

import org.hibernate.Session;

import java.util.Date;

public class Test1 {
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
		Assignment assignmentLoaded = loaded.getAssignments().iterator().next();
		loaded.getAssignments().remove(assignmentLoaded);
		session.delete(assignmentLoaded);
		session.getTransaction().commit();	}

}