package com.enigmacamp.service;

import com.enigmacamp.entity.Player;

import java.util.List;

public interface IPlayerService {
    void addPlayer(Player player);
    Player getPlayer(int id);
    List<Player> getPlayers(int page, int pageSize);
    void update(Player player);
}
