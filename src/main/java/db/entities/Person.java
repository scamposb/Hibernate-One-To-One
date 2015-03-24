package db.entities;

import javax.persistence.*;
import java.io.Serializable;

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
}
