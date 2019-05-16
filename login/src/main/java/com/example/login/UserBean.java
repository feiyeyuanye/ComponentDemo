package com.example.login;

/**
 * Created by xwxwaa on 2019/5/9.
 */

public class UserBean {
    private String accountId;
    private String userName;

    public UserBean() {

    }

    public UserBean(String accountId, String userName) {
        this.accountId = accountId;
        this.userName = userName;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
