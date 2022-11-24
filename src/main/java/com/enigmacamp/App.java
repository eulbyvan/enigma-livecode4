package com.enigmacamp;

import com.enigmacamp.constants.Position;
import com.enigmacamp.entity.Match;
import com.enigmacamp.entity.Player;
import com.enigmacamp.entity.Skill;
import com.enigmacamp.entity.Club;
import com.enigmacamp.repo.implementation.MatchRepo;
import com.enigmacamp.repo.implementation.PlayerRepo;
import com.enigmacamp.repo.implementation.ClubRepo;
import com.enigmacamp.service.implementations.ClubService;
import com.enigmacamp.service.implementations.MatchService;
import com.enigmacamp.service.implementations.PlayerService;
import com.enigmacamp.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        ClubRepo clubRepo = new ClubRepo(em);
        ClubService clubService = new ClubService(clubRepo);

        PlayerRepo playerRepo = new PlayerRepo(em);
        PlayerService playerService = new PlayerService(playerRepo);

        MatchRepo matchRepo = new MatchRepo(em);
        MatchService matchService = new MatchService(matchRepo);


        //region test create team, skill and player
//        Club club = new Club();
//        Skill skill = new Skill();
//        Player player = new Player();
//
//        club.setName("c2");
//        club.setCity("c2");
//
//        player.setName("p2");
//        player.setBirthDate(new Date());
//        player.setCitizenship("p2");
//        player.setHeight(1.80);
//        player.setPosition(Position.Back);
//        skill.setAgility(7);
//        skill.setShootPower(7);
//        skill.setStrength(7);
//        skill.setReflex(7);
//        skill.setDribble(7);
//        skill.setStamina(7);
//        skill.setDetermination(7);
//        skill.setPlayer(player);
//        player.setSkill(skill);
//        player.setClub(club);
//
//        club.getPlayers().add(player);
////
//        clubService.addClub(club);
//
//        playerRepo.create(player);

//        clubRepo.getRow(1).getPlayers().forEach(System.out::println);
//
        //endregion

        //region add match
//        Match match = new Match();
//        Club homeClub = clubService.getClub(1);
//        Club awayClub = clubService.getClub(2);
//
//        match.setHomeClub(homeClub);
//        match.setAwayClub(awayClub);
//
//        matchService.addMatch(match);
//
//        homeClub.getHomeMatches().add(match);
//
//        awayClub.getAwayMatches().add(match);

//        Club club1 = clubService.getClub(1);
//        Club club2 = clubService.getClub(1);
//
//        System.out.println("== home matches club 1 ==");
        clubService.getClub(1).getHomeMatches().forEach(System.out::println);
//
//        System.out.println("== away match club 1 ==");
//        club1.getAwayMatches().forEach(System.out::println);

        //endregion

        //region start match
//        Match match = matchService.getMatch(1);
//
//        matchService.startMatch(match);
        //endregion





        em.close();
    }
}