package com.qwer.test.model;

import lombok.Data;
@Data
public class User {
    private String name;
    private int accountId;
    private String password;
    private long gmtCreate;
    private long gmtModify;
    private String token;
    private String avatarUrl;

}
