package com.tgr;

import com.tgr.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Date;

@Controller
public class HomeController {

	@Autowired
	ResourceService resourceService;

	@RequestMapping("/")
	public ModelAndView home() throws IOException {
		ModelAndView model = new ModelAndView("home");

		model.addObject("stories",resourceService.getStoriesObject());
		model.addObject("time", new Date());
		return model;
	}

}