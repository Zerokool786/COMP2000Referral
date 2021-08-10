package carhiring.models;

import carhiring.models.data.AdminLogin;
import carhiring.utils.Configuration;

/**
 * LoginModel.java
 *
 * @version 1.0
 *
 * It creates a model for the login.
 */
public class LoginModel extends Model {

    // Attributes..
    private AdminLogin admin;

    @Override
    public void initData() {

        admin = new AdminLogin(Configuration.ADMIN_USERNAME, Configuration.ADMIN_PASSWORD);

    }

    /**
     * @return admin
     */
    public AdminLogin getAdmin() {

        return admin;

    }

}
