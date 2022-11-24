package com.enigmacamp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "m_skill")
@ToString
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Integer id;
    @Column(length = 10)
    private @Getter @Setter Integer agility;
    @Column(name = "shoot_power")
    private @Getter @Setter Integer shootPower;
    @Column(length = 10)
    private @Getter @Setter Integer strength;
    @Column(length = 10)
    private @Getter @Setter Integer reflex;
    @Column(length = 10)
    private @Getter @Setter Integer dribble;
    @Column(length = 10)
    private @Getter @Setter Integer stamina;
    @Column(length = 10)
    private @Getter @Setter Integer determination;
}
