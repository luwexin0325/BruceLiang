package com.demo.demo.service.Impl;

import com.demo.demo.dao.IContentDao;
import com.demo.demo.dto.ContentDto;
import com.demo.demo.service.ContentService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author luwenxin
 * @create 2020/1/15
 */
@Service
public class UsersServiceImpl implements ContentService {
//    @Autowired
    @Mapper
    private IContentDao iContentDao;

    public Map<String, String> insert(ContentDto contentDto) {
        Map<String, String> result = new LinkedHashMap<String, String>();
        int count = iContentDao.insert(contentDto);
        if (count > 0) {
            result.put("200", "ok");
        }
        return result;
    }
}
