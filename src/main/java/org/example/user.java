package org.example;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
//import org.hibernate.annotations.Entity;

@Entity
@Table(name="users")
public class user {
    @Id
    @GeneratedValue
    public int id;
    @Column
    public String name;
    @Column
    public String login;
    @Column
    public String password;
    @Column
    public boolean banned=false;
    @Column
    public boolean disabled=false;
    user(String name,String login,String password){this.name=name;this.login=login;this.password=password;}
    user(){}
    public int x;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_sender")
    Set<message> sender=new HashSet<message>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_reciever")
    Set<message> reciever=new HashSet<message>();
}

