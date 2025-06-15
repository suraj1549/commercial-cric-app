package com.example.cricket.repositories;

import com.example.cricket.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player,Long> {
    Optional<Player> findByNameAndRole(String name, String role);
}