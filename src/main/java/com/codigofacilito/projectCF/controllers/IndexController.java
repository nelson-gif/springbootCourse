package com.codigofacilito.projectCF.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("titulo", "Soy el titulo desde getMapping controller");
		model.addAttribute("saludo", "Soy el saludo desde getMapping controller");
		model.addAttribute("show", false);
		//List<String> series = List.of("Dexter", "Game of thrones", "vikings");
		//model.addAttribute("series", series);
		return "index";
	}
	
	@PostMapping("/index-post")
	public String indexRequestMapping() {
		return "index";
	}
	
	@GetMapping("index-mv")
	public ModelAndView indexMV(ModelAndView mv) {
		mv.addObject("titulo", "titulo de MV");
		mv.addObject("saludo", "saludo de MV");
		mv.addObject("show", true);
		
		//List<String> series = List.of("Dexter", "Game of thrones", "vikings");
		//mv.addObject("series", series);
		
		mv.setViewName("index");
		
		return mv;
	}
	
	@ModelAttribute("series")
	public List<String> getSeries(){
		return List.of("Dexter", "Game of thrones", "vikings", "Flash", "The last of us");
	}

}
