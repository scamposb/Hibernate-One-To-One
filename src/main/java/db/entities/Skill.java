package db.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by david on 25/03/2015.
 */
@Entity
@Table(name = "Skill")
public class Skill {
    
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private int id;
    
    @Column(name = "Name")
    private String name;

    @ManyToMany(mappedBy = "skills")
    private Set<Person> persons;

    public Skill(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }
}
