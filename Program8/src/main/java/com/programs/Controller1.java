package com.programs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controller1 {
	
	@RequestMapping("/")
	public String DataAccpet() {
		return "DataAccept";
	}
	
	@RequestMapping("Display")
	public ModelAndView Display(@RequestParam String name,@RequestParam long phone, @RequestParam String email,@RequestParam String address, @RequestParam int age) {
		ModelAndView mv = new ModelAndView("Display");
		mv.addObject(name);
		mv.addObject(phone);
		mv.addObject(address);
		mv.addObject(email);
		mv.addObject(age);
		return mv;
	}

}
