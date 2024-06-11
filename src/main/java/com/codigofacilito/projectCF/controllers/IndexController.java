package com.codigofacilito.projectCF.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {
	
	@GetMapping
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/index-req-mapping" , method = RequestMethod.GET)
	public String indexRequestMapping() {
		return "index";
	}

}
