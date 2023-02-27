package com.viior.example.shuguodemo.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("number")
public class INumber {
    private int number;
}
