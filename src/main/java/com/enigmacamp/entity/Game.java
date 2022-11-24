package com.enigmacamp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "t_game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "home_id")
    private @Getter @Setter Team home;

    @ManyToOne
    @JoinColumn(name = "away_id")
    private @Getter @Setter Team away;

    @OneToOne
    private @Getter @Setter Score score;
}
