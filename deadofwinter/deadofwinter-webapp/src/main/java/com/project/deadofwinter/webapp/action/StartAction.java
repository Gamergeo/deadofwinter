package com.project.deadofwinter.webapp.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.deadofwinter.business.SearchService;
import com.project.deadofwinter.model.MainObjective;
import com.project.deadofwinter.model.Search;
import com.project.deadofwinter.technical.exception.ProjectException;

@RequestMapping
@Controller
public class StartAction extends AbstractAction {

	private static final long serialVersionUID = 817022612156527570L;
	
	@Autowired
	private SearchService searchService;

	@GetMapping(value="/start.do")
	public ModelAndView start(ModelMap model) {
		model.addAttribute("message", "euh, ya quelqu'un ?");
		
		return new ModelAndView("start", "search", new Search());
	}
	
	@PostMapping(value="/anewdawn.do")
	public ModelAndView search(@ModelAttribute("search")Search search, 
		      BindingResult result, ModelMap model) throws ProjectException {

		MainObjective mainObjective = searchService.search(search.isOriginal(), search.isExtension(), search.isCustom());
		
		return new ModelAndView("/mainObjective/randomMainObjective", "mainObjective", mainObjective);
	}

	public SearchService getSearchService() {
		return searchService;
	}

	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}
}
