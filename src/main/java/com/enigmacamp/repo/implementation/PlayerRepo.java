package com.enigmacamp.repo.implementation;

import com.enigmacamp.entity.Player;
import com.enigmacamp.repo.IBaseRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PlayerRepo implements IBaseRepo<Player> {
    private EntityManager em;

    public PlayerRepo(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Player data) {
        try {
            em.getTransaction().begin();
            em.persist(data);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Player getRow(int id) {
        return em.find(Player.class, id);
    }

    @Override
    public List<Player> getRows(int page, int pageSize) {
        TypedQuery<Player> query = em.createQuery("Player.getPlayers", Player.class);

        int offset = (page - 1) * pageSize;

        query.setFirstResult(offset);
        query.setMaxResults(pageSize);

        return query.getResultList();
    }

    @Override
    public void update(Player data) {
        try {
            em.getTransaction().begin();
            em.merge(data);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
