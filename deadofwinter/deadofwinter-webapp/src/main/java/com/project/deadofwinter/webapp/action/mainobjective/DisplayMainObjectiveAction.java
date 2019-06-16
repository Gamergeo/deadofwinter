package com.project.deadofwinter.webapp.action.mainobjective;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.deadofwinter.business.mainobjective.SearchMainObjectiveService;
import com.project.deadofwinter.model.Description;
import com.project.deadofwinter.model.Difficulty;
import com.project.deadofwinter.model.MainObjective;
import com.project.deadofwinter.technical.exception.ProjectException;
import com.project.deadofwinter.webapp.action.AbstractAction;
import com.project.deadofwinter.webapp.form.SearchrRandomMainObjectiveForm;

@RequestMapping("mainObjective")
@Controller
public class DisplayMainObjectiveAction extends AbstractAction {

	private static final long serialVersionUID = -253903055924750467L;

	@Autowired
	private SearchMainObjectiveService searchService;
	
	@PostMapping("anewdawn")
	public ModelAndView displayView(@ModelAttribute("search")SearchrRandomMainObjectiveForm search, 
		      BindingResult result, ModelMap model) throws ProjectException {

		MainObjective mainObjective = searchService.search(search.isOriginal(), search.isExtension(), search.isCustom());
		
		return new ModelAndView("/mainObjective/randomMainObjective", "mainObjective", mainObjective);
	}
	
	@GetMapping("displayEdit")
	public ModelAndView displayEdit(@ModelAttribute("id")String id) {

		MainObjective mainObjective = new MainObjective();
		
		mainObjective.setDifficultyNormal(new Difficulty());
		mainObjective.setAdditionalRule(new Description());
		mainObjective.setVictory(new Description());
		
		if (StringUtils.isNotEmpty(id)) {
			mainObjective.setName(id);
		}
			
		return new ModelAndView("mainObjective/displayEditMainObjective", "mainObjective", mainObjective);
	}

	public SearchMainObjectiveService getSearchService() {
		return searchService;
	}

	public void setSearchService(SearchMainObjectiveService searchService) {
		this.searchService = searchService;
	}

}