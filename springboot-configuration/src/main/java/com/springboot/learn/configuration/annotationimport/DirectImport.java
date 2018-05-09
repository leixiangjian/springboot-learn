package com.springboot.learn.configuration.annotationimport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import com.springboot.learn.configuration.annotationimport.bean.Broker;
import com.springboot.learn.configuration.annotationimport.bean.Customer;

/**
 * 通过import注解直接导入两种类型的类到spring容器中
 * @author lenovo01
 *
 */
@Component
@Import({Customer.class,Broker.class})
public class DirectImport {
	@Autowired
	Customer customer;
	
	@Autowired
	Broker broker;
	
	public String test() {
		return String.format("%s and %s",customer.test(),broker.test() );
	}
}
