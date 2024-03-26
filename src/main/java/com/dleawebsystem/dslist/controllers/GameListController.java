package com.dleawebsystem.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dleawebsystem.dslist.dto.GameLisDTO;
import com.dleawebsystem.dslist.services.GameListService;

@RestController
@RequestMapping(value = "/gamesList")
public class GameListController {

	@Autowired
	private GameListService gameListService;

	@GetMapping
	public List<GameLisDTO> findAll() {
		List<GameLisDTO> result = gameListService.findAll();
		return result;
	}
}
