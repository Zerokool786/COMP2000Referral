package carhiring.models;

import carhiring.models.data.Admin;
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
    private Admin admin;

    @Override
    public void initData() {

        admin = new Admin(Configuration.ADMIN_USERNAME, Configuration.ADMIN_PASSWORD);

    }

    /**
     * @return admin
     */
    public Admin getAdmin() {

        return admin;

    }

}
