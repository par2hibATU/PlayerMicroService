package com.par2hib.tictactoe.Repository;

import com.par2hib.tictactoe.DTO.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PlayerRepo extends MongoRepository<Player, String> {
    List<Player> findByName(String name);
}
