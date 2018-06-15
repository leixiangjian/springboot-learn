package com.springboot.learn.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.learn.web.controller.bean.User;

@RestController
@RequestMapping("/web")
public class WebController {
	private static final Logger logger = LoggerFactory.getLogger(WebController.class);
	@InitBinder
    public void initBinder(WebDataBinder webDataBinder) throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class , new CustomDateEditor(simpleDateFormat , true));
    }
	
	@RequestMapping("/webtest")
	public String webTest(@ModelAttribute User user) {
		logger.info(user.toString());
		return "Hello World!";
	}
	
	/**
	 * <p><strong>请求:</strong>
	 * 在SpringMVC进入httpMsgConvert方法前，
	 * 会根据@RequestBody注解选择适当的HttpMessageConverter实现类来将请求参数解析到string变量中，
	 * 具体来说是使用了StringHttpMessageConverter类
	 * 
	 * <p><strong>响应:</strong>
	 * 当SpringMVC执行readString方法后，
	 * 由于返回值标识了@ResponseBody，SpringMVC将使用StringHttpMessageConverter的write()方法，
	 * 将结果作为String值写入响应报文，当然，此时canWrite()方法返回true
	 * @param string
	 * @return
	 */
	@RequestMapping(value="/httpMsgConvert", method={RequestMethod.POST,RequestMethod.GET})
	public String httpMsgConvert(@RequestBody String string) {
		return "Read string '" + string + "'";
	}
	
	@RequestMapping(value="/requestTest", method={RequestMethod.POST,RequestMethod.GET})
	public String requestTest(HttpServletRequest request) {
		return null;
	}

}
