package com.gamestore.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gamestore.dslist.entities.Game;
import com.gamestore.dslist.projections.GameMinProjection;

		// Terceira Camada - Acesso aos dados (mais próxima do Banco de Dados) 
	// Repository - realiza consulta no BD

												 //  Tipo, Tipo do ID da identidade
public interface GameRepository extends JpaRepository<Game, Long>{

	@Query(nativeQuery = true, value = """			
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	List<GameMinProjection> searchByList(Long listId);
	
}
