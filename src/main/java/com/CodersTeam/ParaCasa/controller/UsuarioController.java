package com.CodersTeam.ParaCasa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.CodersTeam.ParaCasa.entity.Usuario;
import com.CodersTeam.ParaCasa.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioRepository proRep;
	
	@GetMapping("/views/usuarios")
	public ModelAndView urlUsuarios() {
		Iterable<Usuario> usuarios = proRep.findAll();
		
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/views/usuarios/listarUsuario.html");
		mv.addObject("usuarios",usuarios);
		
		return mv;	
	}
}

