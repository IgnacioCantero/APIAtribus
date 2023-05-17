package com.atribus.Atribus.twittersTweets.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "twitters_tweets_urls")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TwittersTweetsUrl {

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

    @Column(name= "urls")
    private String urls;
}
