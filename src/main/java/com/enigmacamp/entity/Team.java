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

    @OneToMany
    @JoinColumn(name = "player_id")
    private @Getter @Setter @ToString.Exclude List<Player> players;

    @OneToMany
    private List<Game> games;
}
