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
    public void create(Player player) {
        try {
            em.getTransaction().begin();
            em.persist(player);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e.getMessage());
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
    public void update(Player player) {
        try {
            em.getTransaction().begin();
            em.merge(player);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e.getMessage());
        }
    }
}
