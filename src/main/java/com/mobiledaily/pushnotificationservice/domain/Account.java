package com.mobiledaily.pushnotificationservice.domain;

/**
 * Created with IntelliJ IDEA.
 * User: johnson
 * Date: 10/31/12
 * Time: 8:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class Account {
    public static final String USER_NAME = "userName";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";
    public static final String ADDRESS = "address";
    private String userName;
    private String password;
    private String email;
    private String phone;
    private String address;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
