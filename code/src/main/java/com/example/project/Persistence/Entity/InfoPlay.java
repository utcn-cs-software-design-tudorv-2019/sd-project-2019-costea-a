package com.example.project.Persistence.Entity;


import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "infoplay")
public class InfoPlay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer id;

    @Column
    private String name;

    @Column
    public String directorPlay;

    @Column
    public String majorActors;

    @Column
    private Date date;

    @Column
    private LocalTime duration;

    @Column
    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirectorPlay() {
        return directorPlay;
    }

    public void setDirectorPlay(String directorPlay) {
        this.directorPlay = directorPlay;
    }

    public String getMajorActors() {
        return majorActors;
    }

    public void setMajorActors(String majorActors) {
        this.majorActors = majorActors;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public Integer getPrice(){ return price;}

    public void setPrice(Integer price){this.price = price;}
}
