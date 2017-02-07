package ch.helsana.web;

import ch.helsana.web.hib.entities.Books;
import ch.helsana.web.hib.init.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by hkfq4 on 07.02.2017.
 */
public class DemoFourth {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Books book = (Books) session.get(Books.class, 5);

        session.delete(book);
        session.getTransaction().commit();

        session.close();

    }

}
