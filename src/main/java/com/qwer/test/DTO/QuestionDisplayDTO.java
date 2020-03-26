package com.qwer.test.DTO;

import com.qwer.test.model.User;
import lombok.Data;

@Data
public class QuestionDisplayDTO {
    private int id;
    private int accountId;
    private String title;
    private String description;
    private String gmtCreate;
    private String gmtModify;
    private int tag;
    private int star;
    private int browse;
    private int comment;
    private User user;
}
