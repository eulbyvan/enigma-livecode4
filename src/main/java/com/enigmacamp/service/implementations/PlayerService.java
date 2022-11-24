package com.enigmacamp.service.implementations;

import com.enigmacamp.entity.Player;
import com.enigmacamp.repo.implementation.PlayerRepo;
import com.enigmacamp.service.IPlayerService;

import java.util.List;

public class PlayerService implements IPlayerService {
    PlayerRepo playerRepo;

    public PlayerService(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    @Override
    public void addPlayer(Player player) {
        playerRepo.create(player);
    }

    @Override
    public Player getPlayer(int id) {
        return playerRepo.getRow(id);
    }

    @Override
    public List<Player> getPlayers(int page, int pageSize) {
        return playerRepo.getRows(page, pageSize);
    }

    @Override
    public void update(Player player) {
        playerRepo.update(player);
    }
}
