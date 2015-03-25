package db.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by david on 24/03/2015.
 */

@Entity
@Table(name = "Band")
public class Band implements Serializable {

    @Id
    @Column(name = "Id")
    private int id;

    @Column(name = "Name")
    private String name;

    @Transient
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Publisher publisher;
    
    @ManyToMany(mappedBy = "bands")
    private Set<Person> members;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "band_has_tag",
            joinColumns = {@JoinColumn(name = "BandId", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "TagId", nullable = false, updatable = false)})
    private Set<Tag> band_tags = new HashSet<Tag>(0);

    public Band(String name) {
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

    @Transient
    public Publisher getPublisher() {
        return publisher;
    }

    @Transient
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Set<Person> getMembers() {
        return members;
    }

    public void setMembers(Set<Person> members) {
        this.members = members;
    }

    public Set<Tag> getBand_tags() {
        return band_tags;
    }

    public void setBand_tags(Set<Tag> band_tags) {
        this.band_tags = band_tags;
    }

    public boolean addTag(Tag tag){
        try {
            this.band_tags.add(tag);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
