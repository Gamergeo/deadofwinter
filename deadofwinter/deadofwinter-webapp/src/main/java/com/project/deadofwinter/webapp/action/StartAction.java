package com.project.deadofwinter.webapp.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.deadofwinter.webapp.form.SearchrRandomMainObjectiveForm;

/**
 * Start of the application
 */
@RequestMapping("start.do")
@Controller
public class StartAction extends AbstractAction {

	private static final long serialVersionUID = 817022612156527570L;

	@GetMapping
	public ModelAndView start(ModelMap model) {
		model.addAttribute("message", "euh, ya quelqu'un ?");
		
		return new ModelAndView("start/start", "search", new SearchrRandomMainObjectiveForm());
	}
}
