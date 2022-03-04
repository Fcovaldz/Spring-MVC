package com.springboot.app.web.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.app.web.models.Usuario;


@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.home.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.feed.titulo}")
	private String textoFeed;
	
	@Value("${texto.indexcontroller.list.titulo}")
	private String textoList;

	@GetMapping({"/index","/","","/home"})
	public String home(Model model) {
		model.addAttribute("titulo", textoIndex);
		return "home";
	}
	
	@RequestMapping("/feed")
	public String feed(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Francisco");
		usuario.setApellido("Bañuelos");
		usuario.setEmail("algo@algomas.com");
		
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoFeed.concat(usuario.getNombre()));
		return "feed";
	}
	
	@RequestMapping("/list")
	public String listar(Model model) {
		
		model.addAttribute("titulo", textoList);

		return "list";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> llenarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(new Usuario("Francisco","Bañuelos","francisco.ba@algomas.com"),
				new Usuario("Santiago","Adonay","santiago.ad@algomas.com"),
				new Usuario("Bernabe","Del hoyo","bernabe.do@algomas.com"),
				new Usuario("Jose","Jose","josh@algomas.com"));
		return usuarios;
	}
}
