package com.qwer.test.model;

import lombok.Data;

@Data
public class Question {
    private int id;
    private int accountId;
    private String title;
    private String description;
    private long gmtCreate;
    private long gmtModify;
    private int tag;
    private int star;
    private int browse;
    private int comment;

}
