package simpleWithDetach;

import org.hibernate.Session;

public class TestMergeParentChild {
    public static void main(String[] args) {
        try {
            Parent detached = createAndDetach();
            System.out.println("**********************************************************************************");
            update(detached);
        } finally {
            HibernateUtil.shutdown();
        }
    }

    private static Parent createAndDetach() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Parent parent = new Parent();
        parent.setId(10);

        Child child = new Child();
        child.setParent(parent);
        parent.getChildren().add(child);
        child.setValue("old");

        session.save(parent);
        session.flush();
        session.detach(parent);
        session.getTransaction().commit();

        session.close();
        return parent;
    }

    private static void update(Parent detached) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Child oldChild = detached.getChildren().iterator().next();
        Child newChild = new Child();
        newChild.setParent(detached);
        newChild.setValue("new");

        detached.getChildren().add(newChild);
        detached.getChildren().remove(oldChild);

        session.merge(detached);
        session.getTransaction().commit();

        session.close();
    }
}