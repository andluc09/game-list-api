package com.gamestore.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamestore.dslist.entities.Game;

		// Terceira Camada - Acesso aos dados (mais próxima do Banco de Dados) 
	// Repository - realiza consulta no BD

												 //  Tipo, Tipo do ID da identidade
public interface GameRepository extends JpaRepository<Game, Long>{

	
	
}
