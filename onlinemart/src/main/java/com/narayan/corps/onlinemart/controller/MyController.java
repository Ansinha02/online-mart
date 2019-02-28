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
		mv.addObject("title", "Home");
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping(value= "/about")
	public ModelAndView about() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value= "/selling")
	public ModelAndView selling() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Sell Here");
		mv.addObject("userClickSelling", true);
		return mv;
	}
	@RequestMapping(value= "/contact")
	public ModelAndView contact() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
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