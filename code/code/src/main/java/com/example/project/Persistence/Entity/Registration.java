package com.example.project.Persistence.Entity;

import javax.persistence.*;

@Entity
@Table(name = "register")
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idregister", nullable = false)
    private Integer id;

    @Column
    private String username;

    @Column
    private String password;

    public Registration(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Registration(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
