package com.example.cricket.repositories;

import com.example.cricket.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Long> {


}