package com.enigmacamp;

import com.enigmacamp.utils.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class App {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
    }
}