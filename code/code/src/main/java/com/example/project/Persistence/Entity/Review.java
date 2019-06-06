package com.example.project.Persistence.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreview", nullable = false)
    private Integer id;

    @Column
    private String namePlay;

    @Column
    private String typePlay;

    @Column
    private String authorReview;

    @Column
    private String textReview;

    @ManyToOne
    @JoinColumn(name = "play")
    @NotNull
    private Play play;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamePlay() {
        return namePlay;
    }

    public void setNamePlay(String namePlay) {
        this.namePlay = namePlay;
    }

    public String getTypePlay() {
        return typePlay;
    }

    public void setTypePlay(String typePlay) {
        this.typePlay = typePlay;
    }

    public String getAuthorReview() {
        return authorReview;
    }

    public void setAuthorReview(String authorReview) {
        this.authorReview = authorReview;
    }

    public String getTextReview() {
        return textReview;
    }

    public void setTextReview(String textReview) {
        this.textReview = textReview;
    }

    public Play getPlay() {
        return play;
    }

    public void setPlay(Play play) {
        this.play = play;
    }
}
