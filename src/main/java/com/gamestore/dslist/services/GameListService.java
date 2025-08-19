package com.gamestore.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamestore.dslist.dto.GameListDTO;
import com.gamestore.dslist.entities.GameList;
import com.gamestore.dslist.repositories.GameListRepository;

		// Segunda Camada - Serviço
	// Injetando dependências de componentes no sistema
 // Camada de Serviço - Quem orquestra todas às operações (onde fica às regras de negócio) 

@Service
public class GameListService {

	@Autowired
	private GameListRepository gameListRepository; // Injeção de dependência do Repository
		
	// Função - que retornará a Lista com os dados mínimos dos Games
	@Transactional(readOnly = true) 
	public List<GameListDTO> findAll() {
		List<GameList> result = gameListRepository.findAll();
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
	}
	
}
