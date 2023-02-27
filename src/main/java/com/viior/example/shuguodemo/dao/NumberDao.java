package com.viior.example.shuguodemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.viior.example.shuguodemo.pojo.INumber;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface NumberDao extends BaseMapper<INumber> {
}
