package hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateDao {

    public void save(HibernateInter hibernateInter) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(hibernateInter);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void update(HibernateInter hibernateInter) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(hibernateInter);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(HibernateInter hibernateInter) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(hibernateInter);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Employees> getEmployees() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Employees", Employees.class).list();
        }
    }

    public List<Phones> getPhones() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from Phones", Phones.class).list();
        }
    }

    public List<?> getEntities(String tableName, Class className) {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            return session.createQuery("from " + tableName, className).list();
        }
    }

}
