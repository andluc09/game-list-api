package com.gamestore.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamestore.dslist.dto.GameMinDTO;
import com.gamestore.dslist.services.GameService;

// Primeira Camada - Controladores REST
	// Comunicação direta para com o app ou aplicação, em outras palavras: o Front-end
// JSON (Requisições HTTP/ REST)

	// Disponibiliza a API, expõe o endpoint para o mundo externo

@RestController
@RequestMapping(value = "/games")
public class GameController {

	@Autowired
	private GameService gameService; // Injeção de dependência do Service
	
	@GetMapping
	public List<GameMinDTO> findAll() {
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
	
}
