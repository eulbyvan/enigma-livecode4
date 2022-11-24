package com.enigmacamp.repo.implementation;

import com.enigmacamp.entity.Team;
import com.enigmacamp.repo.IBaseRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TeamRepo implements IBaseRepo <Team> {
    private EntityManager em;

    public TeamRepo(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Team team) {
        try {
            em.getTransaction().begin();
            em.persist(team);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Team getRow(int id) {
        return em.find(Team.class, id);
    }

    @Override
    public List<Team> getRows(int page, int pageSize) {
        TypedQuery<Team> query = em.createQuery("Team.getTeams", Team.class);

        int offset = (page - 1) * pageSize;

        query.setFirstResult(offset);
        query.setMaxResults(pageSize);

        return query.getResultList();
    }

    @Override
    public void update(Team team) {
        try {
            em.getTransaction().begin();
            em.merge(team);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
