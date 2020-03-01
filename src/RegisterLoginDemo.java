//This is class for testing the register and login function

import DAO.UserDao;
import Entities.User;
import org.hibernate.HibernateException;

public class RegisterLoginDemo {
    public static void main(String[] args) {
        UserDao UserDao = new UserDao();
        try {
            boolean regiser = UserDao.register("barazouri@gmail.com","Bar Azouri", "12345");
            boolean login1 =  UserDao.login("barazouri@gmail.com", "12345");    //login with correct password
            boolean login2 =  UserDao.login("barazouri@gmail.com", "123");      //login with incorrect password

            if(regiser == true) {
                System.out.println("register succeeded");
            }
            else {
                System.out.println("register did not succeed");
            }

            System.out.println("login1: " + login1);
            System.out.println("login 2: " + login2);
            System.out.println(UserDao.getUser("barazouri@gmail.com").toString());

        }
        catch (HibernateException ex){
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }


    }
}
