package com.gamestore.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gamestore.dslist.dto.GameListDTO;
import com.gamestore.dslist.dto.GameMinDTO;
import com.gamestore.dslist.services.GameListService;
import com.gamestore.dslist.services.GameService;

// Primeira Camada - Controladores REST
	// Comunicação direta para com o app ou aplicação, em outras palavras: o Front-end
// JSON (Requisições HTTP/ REST)

	// Disponibiliza a API, expõe o endpoint para o mundo externo

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

	@Autowired
	private GameListService gameListService; // Injeção de dependência do Service
	
	@Autowired
	private GameService gameService; // Injeção de dependência do Service
	
	@GetMapping
	public List<GameListDTO> findAll() {
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> findByList(@PathVariable Long listId) {
		List<GameMinDTO> result = gameService.findByList(listId);
		return result;
	}
}
