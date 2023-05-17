package com.atribus.Atribus.twittersTweets.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "twitters_tweets_hashtags")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TwittersTweetsHashtag {

    //ATRIBUTOS:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "twitters_tweets_id")
    private Long twittersTweetsId;

        //RELACIÓN CON CATEGORIE:
        @ManyToOne
        @JoinColumn(name = "category_id", nullable = false)
        @JsonBackReference
        @JsonIgnoreProperties({"categoryId", "active", "date", "app"})
        private Categorie categories;

        //RELACIÓN CON SEARCH:
        @ManyToOne
        @JoinColumn(name = "search_id", nullable = false)
        @JsonIgnoreProperties({"searchId", "crawlersId", "categoryId", "active", "date", "timezone", "geoUnknown", "avatar", "minFollower", "maxFollower", "verified", "description", "app", "filterNotLang", "filterNotGeo", "filterSentiment", "filterUser", "rss", "pause", "mentionLimit"})
        private Search searchs;

        //RELACIÓN CON TWITTERSTWEETS:
        @ManyToOne
        @JoinColumn(name = "twitters_tweets_id", nullable = false, insertable = false, updatable = false)
        @JsonBackReference
        private TwittersTweet twittersTweet;

    @Column(name= "hashtag")
    private String hashtag;

    @Column(name= "date_created")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;

    @Column(name= "sentiment_human")
    private short sentimentHuman;

}
