package com.demo.demo.service;

import com.demo.demo.dto.ContentDto;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author luwenxin
 * @create 2020/1/15
 */
public interface ContentService {
    Map<String,String> insert(ContentDto contentDto);

}
