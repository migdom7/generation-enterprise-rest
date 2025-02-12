/*

*Fecha: 13/05/2021

*@Author NextoMarket

*@Version 1.0

*/
package com.ejemplos.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplos.spring.model.Persona;
import com.ejemplos.spring.model.Proyecto;

import com.ejemplos.spring.service.PersonaService;
import com.ejemplos.spring.service.ProyectoService;

@RestController
public class RESTController {

	@Autowired
	private ProyectoService proyectoService;
	@Autowired
	private PersonaService personaService;

	/*
	 * PROYECTOS
	 */

	@GetMapping("/listarproyectos") // listar proyectos
	public List<Proyecto> getProyectos() {
		return proyectoService.findAll();
	}

	@PostMapping("/addproyecto") // localhost:5000/add
	public void addProyecto(@RequestBody Proyecto proyecto) {
		proyectoService.save(proyecto);
	}

	@DeleteMapping("/eliminarproyecto/{idproyecto}") // eliminar proyectos
	public void eliminarProyecto(@PathVariable("idproyecto") Integer idproyecto) {
		proyectoService.deleteById(idproyecto);
	}

	@GetMapping("/localizarproyecto/{idproyecto}")
	public List<Proyecto> localizarProyecto(@PathVariable Integer idproyecto) {
		return proyectoService.findById(idproyecto);
	}
	
	@PutMapping("/updateProyecto/{idproyecto}")
	public void updateProyecto(@RequestBody Proyecto proyecto) {
		proyectoService.save(proyecto);
	}

	/*
	 * EQUIPO
	 */

	@GetMapping("/equipo") // página del equipo
	public List<Persona> getEquipo() {
		return personaService.findAll();
	}

	@PostMapping("/addpersona") // crear nueva persona que forma aprte del equipo
	public void addPersona(@RequestBody Persona persona) {
		personaService.save(persona);
	}

	@DeleteMapping("/eliminarpersona/{idpersona}") // eliminar persona
	public void eliminarPersona(@PathVariable("idpersona") Integer idpersona) {
		personaService.deleteById(idpersona);
	}

	@GetMapping("/localizarpersona/{idpersona}")
	public List<Persona> localizarPersona(@PathVariable Integer idpersona) {
		return personaService.findById(idpersona);
	}
	
	@PutMapping("/updatePersona/{idpersona}")
	public void updatePersona(@RequestBody Persona persona) {
		personaService.save(persona);
	}

}
