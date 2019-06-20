package com.project.deadofwinter.webapp.action.mainobjective;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.deadofwinter.business.mainobjective.SearchMainObjectiveService;
import com.project.deadofwinter.model.MainObjective;
import com.project.deadofwinter.model.constant.DescriptionType;
import com.project.deadofwinter.model.constant.DifficultyLevel;
import com.project.deadofwinter.technical.exception.ProjectException;
import com.project.deadofwinter.technical.util.ReplacingNumberUtil;
import com.project.deadofwinter.webapp.action.AbstractAction;
import com.project.deadofwinter.webapp.form.SearchrRandomMainObjectiveForm;

@RequestMapping("mainObjective")
@Controller
public class DisplayMainObjectiveAction extends AbstractAction {

	private static final long serialVersionUID = -253903055924750467L;

	@Autowired
	private SearchMainObjectiveService searchService;
	
	@PostMapping("anewdawn")
	public ModelAndView displayView(@ModelAttribute("search")SearchrRandomMainObjectiveForm search) throws ProjectException {

		MainObjective mainObjective = searchService.search(search.isOriginal(), search.isExtension(), search.isCustom());
		
		return new ModelAndView("/mainObjective/view/displayViewMainObjective", "mainObjective", mainObjective);
	}
	
	@GetMapping("displayEdit")
	public ModelAndView displayEdit(@ModelAttribute("mainObjective") MainObjective mainObjective, @ModelAttribute("errors") ArrayList<String> errors) {

		ModelAndView modelAndView = new ModelAndView("mainObjective/edit/displayEditMainObjective", "mainObjective", new MainObjective());
		modelAndView.addObject("isDifficultyNormal", true);
		
		return modelAndView;
	}
	
	@GetMapping("ajaxNumberToReplace")
	public ModelAndView ajaxNumberToReplace(@ModelAttribute("text")String text,
											@ModelAttribute("type")DescriptionType descriptionType, 
											@ModelAttribute("difficulty") DifficultyLevel difficultyLevel) {
		ModelAndView modelAndView = new ModelAndView("mainObjective/edit/ajaxDisplayEditReplacedNumbers");
		modelAndView.addObject("replacedNumberNumber", ReplacingNumberUtil.getReplacedNumberNumber(text));
		modelAndView.addObject("type", descriptionType);
		modelAndView.addObject("difficulty", difficultyLevel);
		
		return modelAndView;
	}
	
	@PostMapping("ajaxCardEdit")
	public ModelAndView ajaxCardEdit(MainObjective mainObjective, @ModelAttribute("level") DifficultyLevel level) throws ProjectException {
		ModelAndView modelAndView = new ModelAndView("card/edit/editMainObjectiveCard", "mainObjective", mainObjective);
		
		modelAndView.addObject("isDifficultyNormal", level.equals(DifficultyLevel.NORMAL));
		modelAndView.addObject("isDifficultyHard", level.equals(DifficultyLevel.HARD));
		
		return modelAndView;
	}

	public SearchMainObjectiveService getSearchService() {
		return searchService;
	}

	public void setSearchService(SearchMainObjectiveService searchService) {
		this.searchService = searchService;
	}

}
