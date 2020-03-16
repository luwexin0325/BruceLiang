package com.demo.demo.dto;

import lombok.Data;

/**
 * @author luwenxin
 * @create 2020-03-05
 */
@Data
public class UsersDto {
    private int uid;
    private String userName;
    private String userPwd;
    private int state;
    private String carId;
    private int money;
}
