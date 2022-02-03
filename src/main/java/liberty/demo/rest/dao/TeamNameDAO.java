package liberty.demo.rest.dao;

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

    // All the methods down bellow are based on CRUD 

    // CREATE|POST a teamName database
    public void createTeamName(TeamName teamName) {
        em.persist(teamName); // persist an instance of the TeamName entity class
    }

    // READ|GET a teamName database
    public TeamName getTeamName(int teamNameId) {
        return em.find(TeamName.class, teamNameId);
    }

}
