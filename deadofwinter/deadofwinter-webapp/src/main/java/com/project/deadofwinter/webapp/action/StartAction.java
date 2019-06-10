package com.project.deadofwinter.webapp.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.deadofwinter.model.Search;

@RequestMapping
@Controller
public class StartAction extends AbstractAction {

	private static final long serialVersionUID = 817022612156527570L;

	@GetMapping(value="/start")
	public ModelAndView start(ModelMap model) {
//
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("welcome");
//		mv.getModel().put("data", "Welcome home man");

		model.addAttribute("message", "euh, ya quelqu'un ?");
		
		return new ModelAndView("start", "search", new Search());
	}
	
	@PostMapping(value="/anewdawn")
	public ModelAndView search(@ModelAttribute("search")Search search, 
		      BindingResult result, ModelMap model) {

		model.addAttribute("message", search.isCustom());
		
		return new ModelAndView("start", "search", search);
	}
}
