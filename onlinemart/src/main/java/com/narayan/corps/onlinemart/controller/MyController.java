package com.narayan.corps.onlinemart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//instead of PageController

@Controller
public class MyController {

	@RequestMapping(value= {"/" , "/home", "/index"})
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", "welcome to spring MVC");
		return mv;
	}
	
}



//@RequestMapping(value= {"/test"})
//public ModelAndView test(@RequestParam(value="greeting", required=false)String greeting) {
//	
//	if(greeting==null)
//		greeting="Parameter not paassed";
//	ModelAndView mv = new ModelAndView("page");
//	mv.addObject("greeting", greeting);
//	return mv;
//}

//@RequestMapping(value= {"/test/{greeting}"})
//public ModelAndView test(@PathVariable("greeting")String greeting) {
//	
//	if(greeting==null)
//		greeting="Parameter not paassed";
//	ModelAndView mv = new ModelAndView("page");
//	mv.addObject("greeting", greeting);
//	return mv;
//}