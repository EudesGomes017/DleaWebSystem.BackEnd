package com.dleawebsystem.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dleawebsystem.dslist.dto.GameMinDTO;
import com.dleawebsystem.dslist.entities.Game;
import com.dleawebsystem.dslist.repositories.GameRepositry;

//@Component sempre registrar um componente
@Service
public class GameService {

	@Autowired
	private GameRepositry gameRepository;

	public List<GameMinDTO> findAll() {
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}

} 
