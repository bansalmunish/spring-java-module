package com.example.util;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AssertionUtil {

    public void assertGreaterThanZero(int i){
        if(i<=0){
            throw new RuntimeException("less than zero");
        }
    }

    public void assertNotNullOrEmpty(String str){
        if(ObjectUtils.isEmpty(str)){
            throw new RuntimeException("less than zero");
        }
    }


    public void assertGreaterThanZero(double d){
        if(d<=0){
            throw new RuntimeException("less than zero");
        }
    }
}
