package com.springboot.learn.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.webjars.RequireJS;

@Controller
@RequestMapping("/webjar")
public class WebjarjsController {
	@ResponseBody
	@RequestMapping(value = "/js", produces = "application/javascript")
	public String webjarjs() {
		return RequireJS.getSetupJavaScript("/webjars/");
	}
	
	@RequestMapping(value = "/forwardUrl")
	public String forwardhtml() {
		return "forward:/webjar/view";
	}
	
	@RequestMapping(value = "/view")
	public ModelAndView view () {
		ModelAndView  modelView = new ModelAndView ();
		modelView.setViewName("/index");
		return modelView;
	}
	
	@RequestMapping(value = "/redirectUrl")
	public String redirectUrl() {
		return "redirect:/webjar/view";
	}
}
