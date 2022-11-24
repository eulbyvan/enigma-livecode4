package com.enigmacamp.service;

import com.enigmacamp.entity.Club;

import java.util.List;

public interface IClubService {
    void addClub(Club club);
    Club getClub(int id);
    List<Club> getClubs(int page, int pageSize);
    void update(Club club);
}
