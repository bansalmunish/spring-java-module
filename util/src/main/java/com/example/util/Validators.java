package com.example.util;

import com.example.util.validator.Validator;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Validators {

    private final ApplicationContext applicationContext;

    public <T> void validate(T obj){
        var resolvableType = ResolvableType.forClassWithGenerics(Validator.class, obj.getClass());
        String[] names =applicationContext.getBeanNamesForType(resolvableType);
        Validator<T> validator = applicationContext.getBean(names[0], Validator.class);
        validator.validate(obj);
    }
}
