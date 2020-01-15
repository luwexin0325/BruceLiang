package com.demo.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Content {
    private Integer tid;

    private String tname;

    private Date ttime;

    private Integer state;

}