package com.CodersTeam.ParaCasa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.CodersTeam.ParaCasa.entity.Producto;
import com.CodersTeam.ParaCasa.entity.Tipo;
import com.CodersTeam.ParaCasa.repository.ProductoRepository;
import com.CodersTeam.ParaCasa.repository.TipoRepository;


@Controller
public class ProductoController {
	
	@Autowired
	ProductoRepository proRep;
	
	@Autowired
	TipoRepository tipoRep;
	
	@GetMapping("/productos")
	public ModelAndView urlProductos() {
		Iterable<Producto> productos = proRep.findAll();
		Iterable<Tipo> tipos=tipoRep.findAll();
		
		ModelAndView mv=new ModelAndView("/views/productos/listarProductos.html");
		mv.addObject("productos",productos);
		mv.addObject("tipos",tipos);		
		return mv;	
	}
	
	@GetMapping("/productos/crearProducto")
	public ModelAndView crearMenu() {
		
		ModelAndView mv=new ModelAndView("/views/productos/crearProducto.html");
		
		Iterable<Tipo> tiposDisponibles=tipoRep.findAll();
	
		mv.addObject("tiposDisponibles",tiposDisponibles);	
		
		return mv;
	
	}
	
	@PostMapping("/agregarProducto")
	public ModelAndView crearProducto(@RequestParam("descripcion")String descripcion,@RequestParam("kcal")int kcal,@RequestParam("tipo") long idTipo) {
		
		Optional<Tipo> ot=tipoRep.findById(idTipo);
		Tipo t=ot.get();
		
		Producto p=new Producto(null, descripcion, kcal, t);
		proRep.save(p);
		
		
		return urlProductos();
	}
	
	@GetMapping("/editarProducto")
	public ModelAndView editarTipo(@RequestParam("id") long id) {
		ModelAndView mv=new ModelAndView("/views/productos/editarProducto");
		
		
		Optional<Producto> op=proRep.findById(id);		
		Producto p=op.get();
		Iterable<Tipo> tipos=tipoRep.findAll();
		
		
		mv.addObject("producto",p);
		mv.addObject("tipos",tipos);
		
		
		return mv;
	}
	
	@PostMapping("/guardarProducto")
	public ModelAndView guardarProducto(@RequestParam("id")long id, @RequestParam("descripcion")String descripcion,@RequestParam("kcal")int kcal,@RequestParam("tipo")long idTipo) {
		Optional<Producto> op=proRep.findById(id);
		Optional<Tipo> ot=tipoRep.findById(idTipo);
		Producto p=op.get();
		Tipo t=ot.get();
		p.setDescripcion(descripcion);
		p.setKcal(kcal);
		p.setTipo(t);
		
		proRep.save(p);
		
		return urlProductos();
	}
	
	@PostMapping("/eliminarProducto")
	public ModelAndView eliminarProducto(@RequestParam("id")long id) {
		proRep.deleteById(id);
		
		
		return urlProductos();
	}
	
	
}
