package com.test.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.model.Option;
import com.test.repo.OptionRepo;

@Component
public class MyInitializingBean implements InitializingBean{
	
	@Autowired 
	OptionRepo optionRepo;

	@Override
    public void afterPropertiesSet() throws Exception {
		Option option1 = new Option(1,"Male","N");
		Option option2 = new Option(2,"Fe-Male","N");		
		List<Option> options = Arrays.asList(option1,option2);	
		optionRepo.saveAll(options);
        System.out.println("MyInitializingBean is initialized");
    }
}
