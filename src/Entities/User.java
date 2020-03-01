package Entities;


import java.io.Serializable;
import javax.persistence.*;


@Entity(name = "users")

public class User implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(
            name = "Id"
    )
    private long id;
    @Column(
            name = "user_name"
    )
    private String user_name;
    @Column(
            name = "email"
    )
    private String email;
    @Column(
            name = "Password"
    )
    private String password;

    /**
     * User Constructor
     * @param email String that describe the Email of the user.
     * @param user_name String that describe the user name of the user.
     * @param password String that describe the password of the user.
     */
    public User(String email, String user_name, String password) {
        this.user_name = user_name;
        this.email = email;
        this.password = password;
    }
    /**
     * User default Constructor
     */
    public User(){
        this.user_name = null;
        this.email = null;
        this.password = null;

    }

    /**
     * Users Constructor
     * @param id long for user id.
     * @param user_name String that describe the user name of the user.
     * @param email String that describe the Email of the user.
     * @param password String that describe the password of the user.
     */
    public User(long id, String user_name, String email, String password) {
        this.id = id;
        this.user_name = user_name;
        this.email = email;
        this.password = password;
    }


    public User(User user) {
        this.id = user.id;
        this.user_name = user.user_name;
        this.email = user.email;
        this.password = user.password;
    }

    /**
     * User getUser_name
     * @return String return the user name of the user.
     */
    public String getUser_name() {
        return user_name;
    }
    /**
     * User getEmail
     * @return String  return the user Email.
     */
    public String getEmail() {
        return email;
    }
    /**
     * User getPassword
     * @return String  return the user Password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * User getId
     * @return long  return the user ID.
     */
    public long getId() {
        return id;
    }

    /**
     * User setId
     * @param id long to set the id of the user.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * User setUser_name
     * @param user_name String to set user name of the user.
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    /**
     * User setEmail
     * @param email String to set email of the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * User setPassword
     * @param password String to set password of the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
