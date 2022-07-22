package com.example.util;

import com.example.commons.error.CustomException;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AssertionUtil {

    public void assertGreaterThanZero(int i, CustomException customException){
        if(i<=0){
            throw customException;
        }
    }

    public void assertNotNullOrEmpty(String str, CustomException customException){
        if(ObjectUtils.isEmpty(str)){
            throw customException;
        }
    }


    public void assertGreaterThanZero(double d, CustomException customException){
        if(d<=0){
            throw customException;
        }
    }
}
