package com.training.architecture.java.springwebapp.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.training.architecture.java.springwebapp.business.BusinessClass;

@Controller
@RequestMapping(value="/basic")
public class BasicController {

	@Autowired
	private BusinessClass businessClass;
	
	@RequestMapping(value="/page1")
	public String getSimplePage(@RequestParam(value="id")Long id){
		String str = businessClass.sayHello(id);
		return "page1";
	}
	
	@RequestMapping(value="/page2")
	public ModelAndView getSimplePage2(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("page2");
		return mv;
	}
	
	@RequestMapping(value="/page3")
	public String getSimplePage3(@RequestParam(value="param1")String param1){
		return "";
	}
	
	@RequestMapping(value="/page4/{paramName}")
	public String getSimplePage4(@PathVariable(value="paramName")String param1){
		return "";
	}
	
	@RequestMapping(value="page5")
	public String getSimplePage5(@ModelAttribute(value="object") Object param){
		return "";
	}
	
	@ModelAttribute(value="types")
	public List<Object> getReferenceData(){
		return Collections.emptyList();
	}
	
	
}
