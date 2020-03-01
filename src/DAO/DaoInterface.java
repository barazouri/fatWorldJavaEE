package DAO;

import Entities.User;

public interface DaoInterface {
    boolean register(String userName, String email, String password);
    boolean login(String email, String password);
    boolean validateMailNotExistInDB(String email);
    User getUser(String email);

}

