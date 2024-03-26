package com.dleawebsystem.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dleawebsystem.dslist.entities.GameList;

public interface GameListRepositry extends JpaRepository<GameList, Long>{

}
