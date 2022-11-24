package com.enigmacamp.repo.implementation;

import com.enigmacamp.entity.Match;
import com.enigmacamp.repo.IBaseRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class MatchRepo implements IBaseRepo <Match> {
    private EntityManager em;

    public MatchRepo(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Match data) {
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
    public Match getRow(int id) {
        return em.find(Match.class, id);
    }

    @Override
    public List<Match> getRows(int page, int pageSize) {
        TypedQuery<Match> query = em.createQuery("Match.getMatches", Match.class);

        int offset = (page - 1) * pageSize;

        query.setFirstResult(offset);
        query.setMaxResults(pageSize);

        return query.getResultList();
    }

    @Override
    public void update(Match data) {
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
