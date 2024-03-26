package com.dleawebsystem.dslist.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dleawebsystem.dslist.dto.GameLisDTO;
import com.dleawebsystem.dslist.entities.GameList;
import com.dleawebsystem.dslist.repositories.GameListRepositry;

//@Component sempre registrar um componente
@Service
public class GameListService  {

	@Autowired
	private GameListRepositry gameListRepositry;

	private ModelMapper modelMapper = new ModelMapper();

	
	@Transactional(readOnly = true)
	public List<GameLisDTO> findAll() {
		List<GameList> result = gameListRepositry.findAll();
		List<GameLisDTO> dto = result.stream().map((user) -> modelMapper.map(user, GameLisDTO.class))
                .collect(Collectors.toList());
		//List<GameLisDTO> dto = result.stream().map(x -> new GameLisDTO(x)).toList();
		return dto;
	}
}
