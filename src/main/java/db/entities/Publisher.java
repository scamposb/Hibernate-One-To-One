package db.entities;

/**
 * Created by david on 24/03/2015.
 */

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Publisher")
public class Publisher implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private int id;
    
    @Column(name = "Type")
    private boolean type;
    
    @OneToMany(mappedBy = "publisher")
    private Set<Publication> publications;

    public Publisher(boolean type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }
}
