package com.dleawebsystem.dslist.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dleawebsystem.dslist.dto.GameLisDTO;
import com.dleawebsystem.dslist.entities.GameList;
import com.dleawebsystem.dslist.projections.GameMinProjection;
import com.dleawebsystem.dslist.repositories.GameListRepositry;
import com.dleawebsystem.dslist.repositories.GameRepositry;

//@Component sempre registrar um componente
@Service
public class GameListService {

	@Autowired
	private GameListRepositry gameListRepositry;

	@Autowired
	private GameRepositry gameRepository;

	private ModelMapper modelMapper = new ModelMapper();

	@Transactional(readOnly = true)
	public List<GameLisDTO> findAll() {
		List<GameList> result = gameListRepositry.findAll();
		List<GameLisDTO> dto = result.stream().map((user) -> modelMapper.map(user, GameLisDTO.class))
				.collect(Collectors.toList());
		// List<GameLisDTO> dto = result.stream().map(x -> new GameLisDTO(x)).toList();
		return dto;
	}

	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destinationIndex, obj);

		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

		for (int i = min; i <= max; i++) {
			gameListRepositry.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}

}
