/*
 * class ClienteRest
 * 11/05/2021
 * v 1.0
 * @Miguel
 */

package com.ejemplos.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplos.spring.model.Cliente;
import com.ejemplos.spring.model.Proyecto;
import com.ejemplos.spring.service.ClienteService;
import com.ejemplos.spring.service.ProyectoService;

@RestController
public class ProyectoController {

	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ProyectoService proyectoService;

	@GetMapping("/listar")
	public List<Cliente> getClientes() {
		return clienteService.findAll();
	}

	@PostMapping("/add") // localhost:5000/add
	public void addProyecto(@RequestBody Proyecto proyecto) {
		proyectoService.save(proyecto);
	}

}
