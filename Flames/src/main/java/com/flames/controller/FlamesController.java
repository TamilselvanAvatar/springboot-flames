package com.flames.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.flames.model.*;
import com.flames.service.Selector;

@Controller
@SessionAttributes
public class FlamesController {
	@Autowired
	public Selector selector;

	@RequestMapping(value = "/flame", method = RequestMethod.GET)
	public String Showpage(@ModelAttribute("flameAttribute") FlameAttributes flameAttribute) {
		// model.addAttribute("flameAttribute",new FlameAttributes());
		return "flames";
	}

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String result(@ModelAttribute("flameAttribute") FlameAttributes flameAttribute, ModelMap model) {
		String res1 = selector.letterSelection(flameAttribute);
		String maleName =  flameAttribute.getMaleName();
		String femaleName =  flameAttribute.getFemaleName();
		
		String male = (maleName.charAt(0)+"").toUpperCase() + maleName.subSequence(1,maleName.length());
		String female = (femaleName.charAt(0)+"").toUpperCase() + femaleName.subSequence(1,femaleName.length());
		if (res1 == "F") {
			model.addAttribute("res", "in Friends");
			model.addAttribute("maleName", male);
			model.addAttribute("femaleName", female);
		}
		if (res1 == "L") {
			model.addAttribute("res", " a Lovers");
			model.addAttribute("maleName", male);
			model.addAttribute("femaleName", female);
		}
		if (res1 == "A") {
			model.addAttribute("res", "in Affection");
			model.addAttribute("maleName", male);
			model.addAttribute("femaleName", female);
		}
		if (res1 == "M") {
			model.addAttribute("res", "end in Marriage");
			model.addAttribute("maleName", male);
			model.addAttribute("femaleName", female);
		}
		if (res1 == "E") {
			model.addAttribute("res", "Enemy");
			model.addAttribute("maleName", male);
			model.addAttribute("femaleName", female);
		}
		if (res1 == "S") {
			model.addAttribute("res", "Sibilings");
			model.addAttribute("maleName", male);
			model.addAttribute("femaleName", female);
		}
		if (res1 == "Same") {
			model.addAttribute("res", "Same name , so Change");
			model.addAttribute("maleName", male);
			model.addAttribute("femaleName", female);
		}
		model.addAttribute("login",res1);
		return "Result";

	}

}
