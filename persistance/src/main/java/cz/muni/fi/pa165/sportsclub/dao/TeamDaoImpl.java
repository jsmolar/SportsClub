package cz.muni.fi.pa165.sportsclub.dao;

import cz.muni.fi.pa165.sportsclub.entity.Team;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by norbert on 24.10.16.
 */

@Repository
@Transactional
public class TeamDaoImpl implements TeamDao {

    @PersistenceContext
    EntityManager em;

    public void create(Team team) {
        em.persist(team);
    }

    public Team update(Team team) {
        return em.merge(team);
    }

    public void remove(Team team) {
        em.remove(team);
    }

    public Team findById(Long id) {
        return em.find(Team.class, id);
    }
}