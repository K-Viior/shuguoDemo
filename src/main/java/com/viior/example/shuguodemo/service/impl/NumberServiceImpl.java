package com.viior.example.shuguodemo.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.viior.example.shuguodemo.dao.NumberDao;
import com.viior.example.shuguodemo.pojo.INumber;
import com.viior.example.shuguodemo.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class NumberServiceImpl extends ServiceImpl<NumberDao, INumber> implements NumberService {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Override
    public String saveNumber(INumber number) {
        if (number != null) {
            saveNumberInDB(number);
            redisTemplate.opsForValue().set(UUID.randomUUID().toString(),JSONObject.toJSONString(number));
        }
        number.setNumber(number.getNumber() * 2);
        return JSONObject.toJSONString(number);
    }

    @Override
    public String saveNumberSlowly(INumber number) {
        if (number != null) {
            try {
                Thread.sleep(30*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            saveNumberInDB(number);
            redisTemplate.opsForValue().set(UUID.randomUUID().toString(),JSONObject.toJSONString(number));
        }
        number.setNumber(number.getNumber() * 2);
        return JSONObject.toJSONString(number);
    }
    @Async("numberExecutor")
    public void saveNumberInDB(INumber number){
        save(number);
    }

}

