package db.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by david on 25/03/2015.
 */

@Entity
@Table(name = "Publication")
public class Publication implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private int id;
    
    @Column(name = "Date")
    private long date;
    
    @Column(name = "Content")
    private String content;
    
    @ManyToOne
    @JoinColumn(name = "PublisherId")
    private Publisher publisher;

    public Publication(long date, String content) {
        this.date = date;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
