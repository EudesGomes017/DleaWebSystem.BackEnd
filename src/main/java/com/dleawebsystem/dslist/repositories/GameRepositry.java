package com.dleawebsystem.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dleawebsystem.dslist.entities.Game;

public interface GameRepositry extends JpaRepository<Game, Long>{

}
