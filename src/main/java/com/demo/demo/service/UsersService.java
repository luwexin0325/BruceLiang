package com.demo.demo.service;

import com.demo.demo.dto.ContentDto;

import java.util.Map;

/**
 * @author luwenxin
 * @create 2020/1/15
 */
public interface UsersService {
    Map<String,String> insert(ContentDto contentDto);

}
