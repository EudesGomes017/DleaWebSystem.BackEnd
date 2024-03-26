package com.dleawebsystem.dslist.dto;

import com.dleawebsystem.dslist.entities.GameList;

public class GameLisDTO {

	private Long id;
	private String name;

	public GameLisDTO() {

	}

	public GameLisDTO(GameList entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
