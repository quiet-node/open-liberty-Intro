package liberty.demo.rest.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    - JPA, Java Persistence API, is an API used to map Java objects to relational database.
    - JPA maps an entity type to a database table and persisted instances will be represented as rows in the table
*/


@Entity // JPA Entity class
// any POJO class can be designated as a JPA entity
@Table(name = "Team_Names") // Specifies details of the name of the database (table)

/* @NamedQuery specifies a predefined database query that is run by an Entity Manager instace*/
@NamedQuery(name = "TeamName.findAll", query = "SELECT e FROM team_names e")
@NamedQuery(name = "TeamName.findTeamName", query="SELECT e FROM Team_Names e "
+ "WHERE e.parentNameA = :parentNameA AND " 
+ " e.yearBornA = :yearBornA e.parentNameB = :parentNameB AND e.yearBornB = :yearBornB")

@Data // getters, setters, toString, Equals, HashCode
@NoArgsConstructor // default constructor
@AllArgsConstructor // constructor with all arguments
public class TeamName implements Serializable {
    private static final long serialVersionUID = 1L;

    /* @GeneratedValue specifies the strategy used for generating the value of primary key ID */
    /* @stratege = GenerationType.AUTP indecates the generation strat is automatically selected*/
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id 
    @Column(name = "Team_Name_ID") 
    private int id;  // primary key

    @Column(name = "Parent_Name_A")
    private String nameA;
    @Column(name = "Parent_Name_B")
    private String nameB;
    @Column(name = "Year_BornA")
    private String yearA;
    @Column(name = "Year_BornB")
    private String yearB;

    
}
