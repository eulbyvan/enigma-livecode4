package com.enigmacamp.service.implementations;

import com.enigmacamp.entity.Goal;
import com.enigmacamp.entity.Match;
import com.enigmacamp.entity.Player;
import com.enigmacamp.repo.implementation.ClubRepo;
import com.enigmacamp.repo.implementation.MatchRepo;
import com.enigmacamp.repo.implementation.PlayerRepo;
import com.enigmacamp.service.IMatchService;

import java.util.List;

public class MatchService implements IMatchService {
    MatchRepo matchRepo;
    ClubRepo clubRepo;

    public MatchService(MatchRepo matchRepo, ClubRepo clubRepo) {
        this.matchRepo = matchRepo;
        this.clubRepo = clubRepo;
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
        int maxKickOff = 10;
        int totalHomeScore = 0;
        int totalAwayScore = 0;
        int maxPlayerPerClub = 11;

//        (int) ((Math.random() * maxKickOff))

        for (int i = 0; i < maxKickOff; i++) {
            Player randomPlayer = match.getHomeClub().getPlayers().get(maxPlayerPerClub);
        }

        match.setHomeScore(totalHomeScore);
        match.setAwayScore(totalAwayScore);
        match.setIsFinished(true);
        matchRepo.update(match);
    }
}
