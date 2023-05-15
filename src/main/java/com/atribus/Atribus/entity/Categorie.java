package com.atribus.Atribus.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categorie {

    //ATRIBUTOS:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;

    @Column(name= "search")
    private String search;

    @Column(name= "active")
    private int active;

    @Column(name= "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp date;

    @Column(name= "app")
    private int app;

    //RELACIÓN CON TWITTERSTWEET:
    @OneToMany(mappedBy = "categories")
    @JsonIgnore
    private Set<TwittersTweet> twittersTweets;

    //RELACIÓN CON TWITTERSTWEETSHASHTAG:
    @OneToMany(mappedBy = "categories")
    @JsonIgnore
    private Set<TwittersTweetsHashtag> twittersTweetsHashtags;

}
