package com.enigmacamp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NamedQuery(name = "getTeams", query = "SELECT t FROM Team t ORDER BY t.id")

@Entity
@Table(name = "m_team")
@ToString
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Integer id;
    private @Getter @Setter String name;
    private @Getter @Setter String city;

    @Column(name = "is_active", nullable = false)
    private @Getter @Setter Boolean isActive = true;
    @Column(name = "is_deleted", nullable = false)
    private @Getter @Setter Boolean isDeleted = false;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private @Getter @Setter @ToString.Exclude List<Player> players = new ArrayList<>();

    @OneToMany(mappedBy = "homeTeam", fetch = FetchType.LAZY)
    private @Getter @Setter @ToString.Exclude List<Match> homeMatches = new ArrayList<>();

    @OneToMany(mappedBy = "awayTeam", fetch = FetchType.LAZY)
    private @Getter @Setter @ToString.Exclude List<Match> awayMatches = new ArrayList<>();
}
