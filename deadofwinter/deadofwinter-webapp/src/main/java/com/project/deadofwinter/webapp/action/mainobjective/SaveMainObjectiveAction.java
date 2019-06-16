package com.project.deadofwinter.webapp.action.mainobjective;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.deadofwinter.business.mainobjective.MainObjectiveService;
import com.project.deadofwinter.model.MainObjective;
import com.project.deadofwinter.webapp.action.AbstractAction;

@RequestMapping("mainObjective")
@Controller
public class SaveMainObjectiveAction extends AbstractAction {

	private static final long serialVersionUID = 8673509513091804769L;
	
	@Autowired
	private MainObjectiveService mainObjectiveService;
	
	@PostMapping("save")
	public ModelAndView save(@ModelAttribute("mainObjective")MainObjective mainObjective, 
		      BindingResult result, ModelMap model) {
		
		mainObjectiveService.save(mainObjective);
		
		ModelAndView modelAndView =  new ModelAndView("redirect:/mainObjective/displayEdit.do");
		modelAndView.addObject("id", mainObjective.getName());
	
		return modelAndView;
	}
}
