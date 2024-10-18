package com.esporte.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esporte.demo.model.UsuarioModel;
import com.esporte.demo.repository.UsuarioRepository;


@RestController
@RequestMapping("Esporte")
public class UsuarioController {
	@Autowired
	
	UsuarioRepository repository;
	
	@GetMapping("get")
	public List<UsuarioModel> listarUsuarios() {
	List<UsuarioModel> lista = repository.findAll();
		return lista;
	}
	
	@PostMapping("cadastrar")
		public ResponseEntity<?> salvarUsuario(@RequestBody UsuarioDTO user) {
			UsuarioModel usuario = new UsuarioModel(user);
			repository.save(usuario);
			return ResponseEntity.ok("usuario salvo com sucesso");
		}


}
