package org.example;

import javax.persistence.*;
import java.util.Date;
//import org.hibernate.annotations.Entity;

@Entity
@Table(name="messages")
public class message {
    @Id
    @GeneratedValue
    public int id;
    @Column
    public String text;
    @Column
    public Date date;
    @Column
    public boolean sended;
}

