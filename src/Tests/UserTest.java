package Tests;
import Entities.User;

import static org.junit.Assert.*;

public class UserTest {
    private User user;

    @org.junit.Before
    public void setUp() throws Exception {
        user = new User("barazouri24@gmail.com","barAzouri", "12345" );
    }

    @org.junit.Test
    public void testGetters(){
        user.getEmail();
        assertEquals("barazouri24@gmail.com", user.getEmail());
        assertEquals("12345", user.getPassword());
        assertEquals("barAzouri", user.getUser_name());
    }

    @org.junit.Test
    public void testSetters(){
        user.setEmail("GuyGolpur@gmail.com");
        user.setUser_name("guy");
        user.setPassword("1111");
        user.setId(5);
        assertEquals("GuyGolpur@gmail.com", user.getEmail());
        assertEquals("1111", user.getPassword());
        assertEquals("guy", user.getUser_name());
        assertEquals(5, user.getId());

    }


}
