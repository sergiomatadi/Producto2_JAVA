package com.CodersTeam.ParaCasa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.CodersTeam.ParaCasa.entity.Menu;
import com.CodersTeam.ParaCasa.entity.Producto;
import com.CodersTeam.ParaCasa.entity.Tipo;
import com.CodersTeam.ParaCasa.repository.TipoRepository;


@Controller
public class TipoController {

	@Autowired
	TipoRepository tipoRep;
	
	@GetMapping("/tipos")
	public ModelAndView urlTipos() {
		Iterable<Tipo> tipos = tipoRep.findAll();
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/views/tipos/listarTipos.html");
		mv.addObject("tipos",tipos);
		
		return mv;
	}
	
	@GetMapping("/tipos/crearTipo")
	public ModelAndView crearMenu() {
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/views/tipos/crearTipo.html");
		return mv;
	
	}
	
	@PostMapping("/agregarTipo")
	public ModelAndView agregarTipo(@RequestParam("nombre") String nombre) {
		
		
		Tipo t = new Tipo(0L,nombre);
		t=tipoRep.save(t);
	
			
		return urlTipos();
	}
	
	@GetMapping("/editarTipo")
	public ModelAndView editarTipo(@RequestParam("id") long id) {
		ModelAndView mv=new ModelAndView("/views/tipos/editarTipo");
		
		
		Optional<Tipo> ot=tipoRep.findById(id);		
		Tipo t=ot.get();
		Iterable<Tipo> EditarTipo=tipoRep.findAll();
		
		
		mv.addObject("tipo",t);
		mv.addObject("EditarTipo",EditarTipo);
		
		
		return mv;
	}
	
	@PostMapping("/modificarTipo")
	public ModelAndView modificarTipo(@RequestParam("id")long id,@RequestParam("nombre")String nombre) {
		Optional<Tipo> ot=tipoRep.findById(id);
		Tipo t=ot.get();
		
		t.setNombre(nombre);
		tipoRep.save(t);
		
		return urlTipos();
	}
	
	
	@PostMapping("/eliminarTipo")
	public ModelAndView eliminarTipo(@RequestParam("id")long id) {
		tipoRep.deleteById(id);
		return urlTipos();
	}
	
}