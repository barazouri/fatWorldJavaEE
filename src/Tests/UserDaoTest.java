package Tests;

import DAO.UserDao;
import Entities.User;

import static org.junit.Assert.*;

public class UserDaoTest {

    @org.junit.Before
    public void setUp() throws Exception {
        UserDao UserDao = new UserDao();
        UserDao.register("barazouri@gmail.com", "Bar", "12345");
    }

    @org.junit.Test
    public void testGetters ()  {
        UserDao UserDao = new UserDao();
        assertEquals(true, UserDao.login("barazouri@gmail.com", "12345"));
        assertEquals(false, UserDao.login("barazouri@gmail.com", "1212"));

    }
}
