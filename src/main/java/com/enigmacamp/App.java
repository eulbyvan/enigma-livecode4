package com.enigmacamp;

import com.enigmacamp.constants.Position;
import com.enigmacamp.entity.Player;
import com.enigmacamp.entity.Skill;
import com.enigmacamp.entity.Team;
import com.enigmacamp.repo.implementation.PlayerRepo;
import com.enigmacamp.repo.implementation.TeamRepo;
import com.enigmacamp.utils.JpaUtil;
import jakarta.persistence.EntityManager;

import java.util.Date;

public class App {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        TeamRepo teamRepo = new TeamRepo(em);
        PlayerRepo playerRepo = new PlayerRepo(em);

        Team team = new Team();
        Skill skill = new Skill();
        Player player = new Player();

        team.setName("t1");
        team.setCity("t1");

        teamRepo.create(team);

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
        player.setTeam(team);

        playerRepo.create(player);

        em.close();
    }
}