package com.atribus.Atribus.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "twitters_tweets_pln_ner")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TwittersTweetsPlnNer {

    //ATRIBUTOS:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "twitters_tweets_id")
    private Long twittersTweetsId;

    //RELACIÓN CON TWITTERSTWEETS:
    @OneToOne
    @JoinColumn(name = "twitters_tweets_id")
    @JsonBackReference
    private TwittersTweet twittersTweet;

    @Column(name= "word")
    private String word;

    @Column(name= "label")
    private String label;

    @Column(name= "score")
    private double score;

}
