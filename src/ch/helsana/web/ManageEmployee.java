package ch.helsana.web;

import ch.helsana.web.hib.entities.Employee;
import ch.helsana.web.hib.init.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.List;

/**
 * Created by hkfq4 on 08.02.2017.
 */
public class ManageEmployee {

    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public static void main(String[] args) {

        ManageEmployee ME = new ManageEmployee();

        /* Add few employee records in database */
        System.out.println("---> Employee einfügen");
        Integer empID1 = ME.addEmployee("Zara", "Ali", 1000);
        Integer empID2 = ME.addEmployee("Daisy", "Das", 5000);
        Integer empID3 = ME.addEmployee("John", "Paul", 10000);

        /* List down all the employees */
        System.out.println("---> Employees auflisten (1)");
        ME.listEmployees();

        /* Update employee's records */
        System.out.println("---> Employee " + empID2 + " update Salary");
        ME.updateEmployee(empID2, 5555);

        /* Delete an employee from the database */
        System.out.println("---> Employee " + empID3 + " delete");
        ME.deleteEmployee(empID3);

        /* List down all the employees */
        System.out.println("---> Employees auflisten (2)");
        ME.listEmployees();

    }


    /* Method to CREATE an employee in the database */
    public Integer addEmployee(String fname, String lname, int salary) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        Integer employeeID = null;

        try {
            tx = session.beginTransaction();
            Employee employee = new Employee();
            employee.setFirstName(fname);
            employee.setLastName(lname);
            employee.setSalary(salary);
            employeeID = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        System.out.println("employeeID in der Function: " + employeeID);


        return employeeID;
    }

    /* Method to  READ all the employees */
    public void listEmployees() {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM Employee").list();

            for (Iterator iterator = employees.iterator(); iterator.hasNext(); ) {
                Employee employee = (Employee) iterator.next();
                System.out.print("Firstname: " + employee.getFirstName());
                System.out.print(" Lasttname: " + employee.getLastName());
                System.out.print(" Salary: " + employee.getSalary());
                System.out.println(" ID: " + employee.getId());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to UPDATE salary for an employee */
    public void updateEmployee(Integer EmployeeID, int salary) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            Employee employee = (Employee) session.get(Employee.class, EmployeeID);
            employee.setSalary(salary);
            session.update(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /* Method to DELETE an employee from the records */
    public void deleteEmployee(Integer EmployeeID) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Employee employee = (Employee) session.get(Employee.class, EmployeeID);
            session.delete(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
