package com.project.deadofwinter.webapp.action.mainobjective;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.deadofwinter.business.mainobjective.MainObjectiveService;
import com.project.deadofwinter.model.MainObjective;
import com.project.deadofwinter.technical.exception.ProjectException;
import com.project.deadofwinter.webapp.action.AbstractAction;

@RequestMapping("mainObjective")
@Controller
public class SaveMainObjectiveAction extends AbstractAction {

	private static final long serialVersionUID = 8673509513091804769L;
	
	@Autowired
	private MainObjectiveService mainObjectiveService;
	
	@PostMapping("save")
	public ModelAndView save(@ModelAttribute("mainObjective")MainObjective mainObjective) throws ProjectException {
		
		List<String> errors = new ArrayList<String>();
		
		mainObjective.validate(errors);
		
		if (errors.size() != 0) {
			
			ModelAndView modelAndView = new ModelAndView("mainObjective/edit/displayEditMainObjective", "mainObjective", mainObjective);
			modelAndView.addObject("isDifficultyNormal", true);
			modelAndView.addObject("errors", errors);
			
			return modelAndView;
		}
		
		mainObjectiveService.save(mainObjective);
		
		return new ModelAndView("redirect:/mainObjective/displayEdit.do", "mainObjective", mainObjective);
	}
}
