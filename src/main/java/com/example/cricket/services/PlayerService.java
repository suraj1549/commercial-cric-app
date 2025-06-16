package com.example.cricket.services;


import com.example.cricket.models.Player;
import com.example.cricket.repositories.PlayerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository repository){
        playerRepository = repository;
    }

    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    public Optional<Player> findByNameAndRole(String name, String role) {
        return playerRepository.findByNameAndRole(name, role);
    }

    public Player save(Player player){
        return playerRepository.save(player);
    }

    public ResponseEntity<String> addPlayer(@RequestBody Player player) {
        return playerRepository.findByNameAndRole(player.getName(), player.getRole())
                .map(existing -> ResponseEntity.badRequest().body("Player with same name and role already exists."))
                .orElseGet(() -> {
                    playerRepository.save(player);
                    return ResponseEntity.ok("Player added successfully.");
                });
    }



    public void deleteById(Long id){
        playerRepository.deleteById(id);
    }
}
