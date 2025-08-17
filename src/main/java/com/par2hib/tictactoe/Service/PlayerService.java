package com.par2hib.tictactoe.Service;


import com.par2hib.tictactoe.DTO.Player;
import com.par2hib.tictactoe.Repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepo playerRepo;

    public Player addPlayer(Player player) {
        return playerRepo.save(player);
    }

    public List<Player> getAllPlayers(){
        return playerRepo.findAll();
    }

    public Player getPlayerById(String uniqueId) {
        return playerRepo.findById(uniqueId).get();
    }

    public List<Player> getPlayerByName(String name) {
        return playerRepo.findByName(name);
    }

    // updates by ID
    public Player updatePlayer(String uniqueId, Player player){
        Optional<Player> QueryPlayer = playerRepo.findById(uniqueId);
        if(!QueryPlayer.isPresent()){
            throw new RuntimeException("Player not found");
        }
        Player existingPlayer = QueryPlayer.get();
        existingPlayer.setName(player.getName());
        existingPlayer.setAge(player.getAge());
        existingPlayer.setPassword(player.getPassword());
        return playerRepo.save(existingPlayer);
    }

    public String deletePlayer(String uniqueId){
        if(playerRepo.findById(uniqueId).isPresent()){
            playerRepo.deleteById(uniqueId);
            return "Player Deleted with Id: " + uniqueId;
        }
        return "Player Not Found";
    }

}
