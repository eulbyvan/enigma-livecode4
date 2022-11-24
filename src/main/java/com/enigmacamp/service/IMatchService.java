package com.enigmacamp.service;

import com.enigmacamp.entity.Match;

import java.util.List;

public interface IMatchService {
    void addMatch(Match match);
    Match getMatch(int id);
    List<Match> getMatches(int page, int pageSize);
    void startMatch(Match match);
}
