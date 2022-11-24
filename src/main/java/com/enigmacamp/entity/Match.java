package com.enigmacamp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@NamedQuery(name = "getMatches", query = "SELECT m FROM Match m ORDER BY m.id")

@Entity
@Table(name = "t_match")
@ToString
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "home_score")
    private @Getter @Setter Integer homeScore;
    @Column(name = "away_score")
    private @Getter @Setter Integer awayScore;
    @Column(name = "is_finished")
    private @Getter @Setter Boolean isFinished = false;

    @ManyToOne
    @JoinColumn(name = "home_id")
    private @Getter @Setter Club homeClub;

    @ManyToOne
    @JoinColumn(name = "away_id")
    private @Getter @Setter Club awayClub;
}
