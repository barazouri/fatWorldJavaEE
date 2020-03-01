package Logic;

import DAO.UserDao;
import Entities.User;

import java.io.Serializable;

public class UserFunctionality implements Serializable {
    private static final long serialVersionUID = 1L;
    public UserFunctionality() {
    }
    public static boolean login(String email, String password) {
        UserDao user = new UserDao();
        return user.login(email, password);
    }
    public static boolean register(String userName, String email, String password) {
        UserDao user = new UserDao();
        return user.register(userName, email, password);
    }
    public static User getUser(String email) {
        UserDao user = new UserDao();
        return user.getUser(email);
    }

    }
