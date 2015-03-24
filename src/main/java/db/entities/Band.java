package db.entities;

import javax.persistence.*;
import java.io.Serializable;

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
}
