package com.viior.example.shuguodemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.viior.example.shuguodemo.pojo.INumber;


public interface NumberService extends IService<INumber> {
    String saveNumber(INumber number);

    String saveNumberSlowly(INumber number);

}
