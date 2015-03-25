package db.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by david on 25/03/2015.
 */
@Entity
@Table(name = "Tag")
public class Tag {
    
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private int id;
    
    @Column(name = "Name")
    private String name;

    @ManyToMany(mappedBy = "person_tags")
    private Set<Person> persons;

    @ManyToMany(mappedBy = "band_tags")
    private Set<Band> bands;

    public Tag(String name) {
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

    public Set<Band> getBands() {
        return bands;
    }

    public void setBands(Set<Band> bands) {
        this.bands = bands;
    }
}
