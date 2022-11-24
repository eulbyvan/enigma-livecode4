package com.enigmacamp.service.implementations;

import com.enigmacamp.entity.Match;
import com.enigmacamp.repo.implementation.MatchRepo;
import com.enigmacamp.service.IMatchService;

import java.util.List;

public class MatchService implements IMatchService {
    MatchRepo matchRepo;

    public MatchService(MatchRepo matchRepo) {
        this.matchRepo = matchRepo;
    }

    @Override
    public void addMatch(Match match) {
        matchRepo.create(match);
    }

    @Override
    public Match getMatch(int id) {
        return matchRepo.getRow(id);
    }

    @Override
    public List<Match> getMatches(int page, int pageSize) {
        return matchRepo.getRows(page, pageSize);
    }

    @Override
    public void startMatch(Match match) {
        match.setHomeScore((int) ((Math.random() * 10)));
        match.setAwayScore((int) ((Math.random() * 10)));
        match.setIsFinished(true);
        matchRepo.update(match);
    }
}
