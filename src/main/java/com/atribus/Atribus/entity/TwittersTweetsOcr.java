package com.atribus.Atribus.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "twitters_tweets_ocrs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TwittersTweetsOcr {

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

    @Column(name= "text")
    private String text;

    @Column(name= "polygone")
    private String polygone;

    @Column(name= "start_time")
    private double startTime;

    @Column(name= "end_time")
    private double endTime;

    @Column(name= "width")
    private int width;

    @Column(name= "height")
    private int height;

}
