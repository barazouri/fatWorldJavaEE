package DAO;

import Entities.User;
import Hibernate.HibernetFactory;
import Logic.Md5;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao implements DaoInterface {

    /**
     * UserDao addUser(String userName, String email, String password)
     * @param userName  of the user that try to register.
     * @param email  of the user that try to register.
     * @param password  of the user that try to register.
     * @return boolean return true if the register was succeed and false if not.
     */
    public boolean register(String userName, String email, String password) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernetFactory.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            if (this.validateMailNotExistInDB(email)) {
                User user = new User(email, userName, Md5.md5(password));
                session.save(user);
                session.getTransaction().commit();
                return true;
            } else {
                return false;
            }
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
            throw new HibernateException(ex.getMessage());
        }
        finally {
            session.close();
        }
    }

    /**
     * login(String email, String password)
     * @param email String for email that the user try to login with.
     * @param password String for Password that the user try to login with.
     * @return boolean return true if the email and the password are correct and false if not.
     */
    public boolean login(String email, String password) {
        Transaction transaction = null;
        boolean returnValue = false;
        Session session = null;
        try {
            session = HibernetFactory.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            List<User> userList = session.createNativeQuery("select * from users where users.Email = :email").addEntity(User.class).setParameter("email", email).list();
            if(userList.size() > 0 && userList.get(0).getPassword().equals(Md5.md5(password))){
                returnValue = true;
            }
            return returnValue;
        } catch (HibernateException ex) {
            if (transaction != null) {
                transaction.rollback();
            }

            ex.printStackTrace();
            throw new HibernateException(ex.getMessage());
        }
        finally {
            session.close();
        }
        }

    /**
     * UserDao validateMailNotExistInDB.
     * @param email String for Email that we need to validate if exist in DB table.
     * @return boolean return false if the email is already exist in users table and false if not.
     */
    public boolean validateMailNotExistInDB(String email) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernetFactory.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            List<User> userList = session.createNativeQuery("select * from users where users.Email = :email").addEntity(User.class).setParameter("email", email).list();
            if(userList.size() >= 1){
                return false; //email already exist in DB
            }
            else{
                return true;
            }
        } catch (HibernateException var5) {
            if (transaction != null) {
                transaction.rollback();
            }

            var5.printStackTrace();
            throw new HibernateException(var5.getMessage());
        }
        finally {
            session.close();
        }
        }
    /**
     * getUser by email.
     * @param email String for Email that we want to get.
     * @return User return User object with all details.
     */
    public User getUser(String email) {
        Session session = null;
        try{
            session = HibernetFactory.getSessionFactory().openSession();
            session.beginTransaction();
            List<User> userList = session.createNativeQuery("select * from users where users.Email = :email").addEntity(User.class).setParameter("email", email).list();
            if(userList.size() >= 0) {
                return userList.get(0);
            }
            else {
                return new User();
            }
        }
        catch (HibernateException ex) {
            throw new HibernateException(ex);
        }
        finally {
            session.close();
        }

    }
}
