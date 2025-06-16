package com.example.cricket.controllers;


import com.example.cricket.models.Player;
import com.example.cricket.repositories.PlayerRepository;
import com.example.cricket.services.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // for returning JSON data(REST apis), converts Java Object to JSON.
@RequestMapping("/api/players") //
public class PlayerController {

    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> addPlayer(@RequestBody Player player){
        return service.addPlayer(player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping
    public List<Player> getAllPlayers(){
        return service.getAllPlayers();
    }
}
