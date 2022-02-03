package liberty.demo.rest.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import liberty.demo.rest.models.TeamName;

@RequestScoped
public class TeamNameDAO {
    /* 
        - To use the entity manager at runtime, inject it into our CDI bean through 
        the @PersistenceContext annotation.
        - The persistence context synchronizes with the database when a transaction
        commits.
    */
    @PersistenceContext(name = "jpa-unit")
    private EntityManager em;

    // All the methods down bellow are based on CRUD and they all interact with 
    // database instances



    // CREATE|POST 
    public void createTeamName(TeamName teamName) {
        em.persist(teamName); // persist an instance of the TeamName entity class
    }

    // READ|GET 
    public TeamName getTeamName(int teamNameId) {
        return em.find(TeamName.class, teamNameId);
    }

    // READ|GET All TeamNames
    public List<TeamName> getAllTeamNames() {
        return em.createNamedQuery("TeamName.findAll", TeamName.class)
                .getResultList();
    }

    // UPDATE|PUT 
    public void updateTeamName(TeamName teamName) {
        em.merge(teamName);
    }

    // DELETE|DELETE
    public void removeTeamName(TeamName teamName) {
        em.remove(teamName);
    }

    // find teamName --> return a list of the teamNames
    public List<TeamName> findTeamName(String nameA, String nameB, String yearA, String yearB) {
        return em.createNamedQuery("TeamName.findTeamName", TeamName.class)
                .setParameter("namA", nameA)
                .setParameter("nameB", nameB)
                .setParameter("yearA", yearA)
                .setParameter("yearB", yearB)
                .getResultList();
    }


}
