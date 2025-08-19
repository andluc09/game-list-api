package com.gamestore.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gamestore.dslist.dto.GameMinDTO;
import com.gamestore.dslist.entities.Game;
import com.gamestore.dslist.repositories.GameRepository;

		// Segunda Camada - Serviço
	// Injetando dependências de componentes no sistema
 // Camada de Serviço - Quem orquestra todas às operações (onde fica às regras de negócio) 

@Service
public class GameService {

	@Autowired
	private GameRepository gameRepository; // Injeção de dependência do Repository
	
	// Função - que retornará a Lista com os dados mínimos dos Games
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
	
}
