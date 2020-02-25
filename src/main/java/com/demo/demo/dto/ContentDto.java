package com.demo.demo.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author luwenxin
 * @create 2020/1/15
 */
@Data
public class ContentDto extends entity.Content {
    private Integer tid;

    private String tname;

    private Date ttime;

    private Integer state;
}
