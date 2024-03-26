package com.dleawebsystem.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dleawebsystem.dslist.dto.GameDTO;
import com.dleawebsystem.dslist.dto.GameMinDTO;
import com.dleawebsystem.dslist.entities.Game;
import com.dleawebsystem.dslist.projections.GameMinProjection;
import com.dleawebsystem.dslist.repositories.GameRepositry;

//@Component sempre registrar um componente
@Service
public class GameService {

	@Autowired
	private GameRepositry gameRepository;

	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}

	@Transactional(readOnly = true) // @Transactional para garantir obdecendo os principios das transações
									// //readOnly = true informamos que não vamos fazer nenhuma operação de escrita
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId) {
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}

}
