package com.enigmacamp.entity;

import com.enigmacamp.constants.Position;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@NamedQuery(name = "getPlayers", query = "SELECT p FROM Player p ORDER BY p.id")

@Entity
@Table(name = "m_player")
@ToString
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Integer id;
    private @Getter @Setter String name;
    @Column(name = "birth_date")
    private @Getter @Setter Date birthDate;
    private @Getter @Setter String citizenship;
    private @Getter @Setter Double height;

    @Enumerated(EnumType.STRING)
    private @Getter @Setter Position position;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "goal_id")
    private @Getter @Setter Goal goal;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "skill_id")
    private @Getter @Setter @ToString.Exclude Skill skill;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private @Getter @Setter @ToString.Exclude Club club;

    @Column(name = "is_active", nullable = false)
    private @Getter @Setter Boolean isActive = true;
    @Column(name = "is_deleted", nullable = false)
    private @Getter @Setter Boolean isDeleted = false;
}
