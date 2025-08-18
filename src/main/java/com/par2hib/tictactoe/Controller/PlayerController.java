package com.par2hib.tictactoe.Controller;


import com.par2hib.tictactoe.DTO.Player;
import com.par2hib.tictactoe.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        Player newPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers(){
        return new ResponseEntity<>(playerService.getAllPlayers(), HttpStatus.OK);
    }

    @GetMapping("/player/{uniqueId}")
    public ResponseEntity<Player> getPlayerById(@PathVariable String uniqueId){
        return new ResponseEntity<>(playerService.getPlayerById(uniqueId), HttpStatus.OK);
    }

    @GetMapping("/player/{name}")
    public ResponseEntity<List<Player>> getPlayerByName(@PathVariable String name){
        return new ResponseEntity<>(playerService.getPlayerByName(name), HttpStatus.OK);
    }

    @PutMapping("/player/{uniqueId}")
    public ResponseEntity<Player> updatePlayer(@PathVariable String uniqueId, @RequestBody Player player){
        return new ResponseEntity<>(playerService.updatePlayer(uniqueId, player), HttpStatus.OK);
    }

    @DeleteMapping("/player/{uniqueId}")
    public ResponseEntity<String> deletePlayer(@PathVariable String uniqueId){
        String result = playerService.deletePlayer(uniqueId);
        if(result.contains("Not Found")){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result);
    }


    // Confirmation message to connect with the GameService
    @GetMapping("/connection-established")
    public String message(){
        return "Connection established with Game Service";
    }

}
