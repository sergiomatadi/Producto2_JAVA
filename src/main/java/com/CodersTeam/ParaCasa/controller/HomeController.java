package com.CodersTeam.ParaCasa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.CodersTeam.ParaCasa.entity.Menu;
import com.CodersTeam.ParaCasa.repository.MenuRepository;



@Controller
public class HomeController {
	
	@Autowired
	MenuRepository repositorioMenu;
	
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	
	@GetMapping("/menus/seleccionMenu")
	public ModelAndView SeleccionMenu() {
		Iterable<Menu> menus= repositorioMenu.findAll();
		ModelAndView mv=new ModelAndView("/views/menus/seleccionMenu");
		mv.addObject("menus",menus);
		return mv;
	}
	
	@GetMapping("/menus/menuBebida")
	public String SeleccionBebida() {
		return "/views/menus/menuBebida";
	}
	
	

}
