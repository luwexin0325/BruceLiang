package com.demo.demo.dao;

import com.demo.demo.dto.ContentDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author luwenxin
 * @create 2020/1/15
 */
//@Repository
public interface IContentDao {
   long countByExample(entity.ContentExample example);

   int deleteByExample(entity.ContentExample example);

   int insert(entity.Content record);

   int insertSelective(entity.Content record);

   List<entity.Content> selectByExample(entity.ContentExample example);

   int updateByExampleSelective(@Param("record") entity.Content record, @Param("example") entity.ContentExample example);

   int updateByExample(@Param("record") entity.Content record, @Param("example") entity.ContentExample example);
}
