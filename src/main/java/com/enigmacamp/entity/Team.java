package com.enigmacamp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "m_team")
@ToString
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Integer id;
    private @Getter @Setter String name;
    private @Getter @Setter String city;

    @Column(name = "is_active")
    private @Getter @Setter Boolean isActive;
    @Column(name = "is_deleted")
    private @Getter @Setter Boolean isDeleted;

    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY)
    private @Getter @Setter @ToString.Exclude List<Player> players;

    @OneToMany(mappedBy = "homeTeam", fetch = FetchType.LAZY)
    private @Getter @Setter @ToString.Exclude List<Match> homeMatches;

    @OneToMany(mappedBy = "awayTeam", fetch = FetchType.LAZY)
    private @Getter @Setter @ToString.Exclude List<Match> awayMatches;
}
