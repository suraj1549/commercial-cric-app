package com.example.cricket.controllers;


import com.example.cricket.models.Player;
import com.example.cricket.repositories.PlayerRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // for returning JSON data(REST apis), converts Java Object to JSON.
@RequestMapping("/api/players") //
public class PlayerController {

    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

//    public PlayerController(PlayerRepository repository){
//        this.playerRepository = repository;
//    }


    @PostMapping
    public Player addPlayer(@RequestBody Player player){
        return playerRepository.save(player);
    }





}
