package com.enigmacamp.repo.implementation;

import com.enigmacamp.entity.Club;
import com.enigmacamp.repo.IBaseRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ClubRepo implements IBaseRepo <Club> {
    private EntityManager em;

    public ClubRepo(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Club club) {
        try {
            em.getTransaction().begin();
            em.persist(club);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public Club getRow(int id) {
        return em.find(Club.class, id);
    }

    @Override
    public List<Club> getRows(int page, int pageSize) {
        TypedQuery<Club> query = em.createQuery("Team.getTeams", Club.class);

        int offset = (page - 1) * pageSize;

        query.setFirstResult(offset);
        query.setMaxResults(pageSize);

        return query.getResultList();
    }

    @Override
    public void update(Club club) {
        try {
            em.getTransaction().begin();
            em.merge(club);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
