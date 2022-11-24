package com.enigmacamp;

import com.enigmacamp.constants.Position;
import com.enigmacamp.entity.Player;
import com.enigmacamp.entity.Skill;
import com.enigmacamp.entity.Club;
import com.enigmacamp.repo.implementation.PlayerRepo;
import com.enigmacamp.repo.implementation.ClubRepo;
import com.enigmacamp.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        ClubRepo clubRepo = new ClubRepo(em);
        PlayerRepo playerRepo = new PlayerRepo(em);

        //region test create team and player
        Club club = new Club();
        Skill skill = new Skill();
        Player player = new Player();

        club.setName("t1");
        club.setCity("t1");

        player.setName("p1");
        player.setBirthDate(new Date());
        player.setCitizenship("p1");
        player.setHeight(1.80);
        player.setPosition(Position.CenterForward);
        skill.setAgility(7);
        skill.setShootPower(7);
        skill.setStrength(7);
        skill.setReflex(7);
        skill.setDribble(7);
        skill.setStamina(7);
        skill.setDetermination(7);
        skill.setPlayer(player);
        player.setSkill(skill);
        player.setClub(club);

        club.getPlayers().add(player);

        clubRepo.create(club);

        playerRepo.create(player);

//        team.getPlayers().forEach(System.out::println);

        clubRepo.getRow(1).getPlayers().forEach(System.out::println);

        em.close();
        //endregion
    }
}