package com.springboot.learn.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.webjars.RequireJS;

@RestController
@RequestMapping("/webjar")
public class WebjarjsController {
	@ResponseBody
	@RequestMapping(value = "/js", produces = "application/javascript")
	public String webjarjs() {
		return RequireJS.getSetupJavaScript("/webjars/");
	}
}
