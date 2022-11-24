package com.enigmacamp.service.implementations;

import com.enigmacamp.entity.Club;
import com.enigmacamp.repo.implementation.ClubRepo;
import com.enigmacamp.service.IClubService;

import java.util.List;

public class ClubService implements IClubService {
    ClubRepo clubRepo;

    public ClubService(ClubRepo clubRepo) {
        this.clubRepo = clubRepo;
    }

    @Override
    public void addClub(Club club) {
        clubRepo.create(club);
    }

    @Override
    public Club getClub(int id) {
        return clubRepo.getRow(id);
    }

    @Override
    public List<Club> getClubs(int page, int pageSize) {
        return clubRepo.getRows(page, pageSize);
    }

    @Override
    public void update(Club club) {
        clubRepo.update(club);
    }
}
