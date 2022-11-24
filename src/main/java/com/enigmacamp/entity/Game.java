package com.enigmacamp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "t_game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "home_score")
    private @Getter @Setter Integer homeScore;
    @Column(name = "away_score")
    private @Getter @Setter Integer awayScore;

    @ManyToOne
    @JoinColumn(name = "home_id")
    private @Getter @Setter Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_id")
    private @Getter @Setter Team awayTeam;
}
