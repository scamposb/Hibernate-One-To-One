package db.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by david on 24/03/2015.
 */

@Entity
@Table(name = "Person")
public class Person implements Serializable {
    
    @Id
    @Column(name = "Id")
    private int id;
    
    @Column(name = "Name")
    private String name;
    
    @Column(name = "Email")
    private String email;
    
    @Column(name = "NIP")
    private int nip;

    @Transient
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Publisher publisher;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "is_member", 
            joinColumns = {@JoinColumn(name = "PersonId", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "BandId", nullable = false, updatable = false)})
    private Set<Band> bands = new HashSet<Band>(0);
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "has_skill",
            joinColumns = {@JoinColumn(name = "PersonId", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "SkillId", nullable = false, updatable = false)})
    private Set<Skill> skills = new HashSet<Skill>(0);

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "person_has_tag",
            joinColumns = {@JoinColumn(name = "PersonId", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "TagId", nullable = false, updatable = false)})
    private Set<Tag> person_tags = new HashSet<Tag>(0);

    public Person(String name, String email, int nip) {
        this.name = name;
        this.email = email;
        this.nip = nip;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNip() {
        return nip;
    }

    public void setNip(int nip) {
        this.nip = nip;
    }

    @Transient
    public Publisher getPublisher() {
        return publisher;
    }

    @Transient
    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Set<Band> getBands() {
        return bands;
    }

    public void setBands(Set<Band> bands) {
        this.bands = bands;
    }
    
    public boolean addBand(Band band){
        try {
            this.bands.add(band);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public boolean addSkill(Skill skill){
        try {
            this.skills.add(skill);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Set<Tag> getPerson_tags() {
        return person_tags;
    }

    public void setPerson_tags(Set<Tag> person_tags) {
        this.person_tags = person_tags;
    }

    public boolean addTag(Tag tag){
        try {
            this.person_tags.add(tag);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
