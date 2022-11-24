package com.enigmacamp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@NamedQuery(name = "getTeams", query = "SELECT c FROM Club c ORDER BY c.id")

@Entity
@Table(name = "m_club")
@ToString
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Integer id;
    private @Getter @Setter String name;
    private @Getter @Setter String city;

    @Column(name = "is_active", nullable = false)
    private @Getter @Setter Boolean isActive = true;
    @Column(name = "is_deleted", nullable = false)
    private @Getter @Setter Boolean isDeleted = false;

    @OneToMany(mappedBy = "club", fetch = FetchType.LAZY)
    private @Getter @Setter @ToString.Exclude List<Player> players = new ArrayList<>();

    @OneToMany(mappedBy = "homeClub", fetch = FetchType.LAZY)
    private @Getter @Setter @ToString.Exclude List<Match> homeMatches = new ArrayList<>();

    @OneToMany(mappedBy = "awayClub", fetch = FetchType.LAZY)
    private @Getter @Setter @ToString.Exclude List<Match> awayMatches = new ArrayList<>();
}
