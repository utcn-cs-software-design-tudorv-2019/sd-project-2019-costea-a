package com.example.project.Persistence.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "play")
public class Play {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idplay", nullable = false)
    public Integer id;

    @Column
    private String name;

    @Column
    public String authorPlay;

    @Column
    private String typePlay;

    @OneToMany(mappedBy = "play", fetch = FetchType.EAGER)
    private List<Review> reviews;

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


    public String getAuthorPlay() {
        return authorPlay;
    }

    public void setAuthorPlay(String authorPlay) {
        this.authorPlay = authorPlay;
    }

    public String getTypePlay() {
        return typePlay;
    }

    public void setTypePlay(String typePlay) {
        this.typePlay = typePlay;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
