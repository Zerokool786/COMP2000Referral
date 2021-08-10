package carhiring.models.data;

/**
 * Admin.java
 *
 * @version 1.0
 *
 * It is used to represents the admin
 * credientials so that it can access
 * the admin control system.
 */
public class AdminLogin {

    // Attributes..
    private String username;
    private String password;

    /**
     * Constructor to initialise the admin
     * details.
     *
     * @param username of admin
     * @param password of admin
     */
    public AdminLogin(String username, String password) {

        this.username = username;
        this.password = password;

    }

    /**
     * @return username
     */
    public String getUsername() {

        return username;

    }

    /**
     * @return password
     */
    public String getPassword() {

        return password;

    }

}
