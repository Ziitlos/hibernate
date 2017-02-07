package ch.helsana.web;

import ch.helsana.web.hib.entities.Books;
import ch.helsana.web.hib.init.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by hkfq4 on 07.02.2017.
 */
public class DemoFirst {

    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Books book = new Books();
        book.setId(5);
        book.setIsbn("ISBN 987654");
        book.setTitle("TITEL Der blaue Gepard.");
        book.setYear(2015);

        session.save(book);
        session.getTransaction().commit();

        session.close();


    }

}
