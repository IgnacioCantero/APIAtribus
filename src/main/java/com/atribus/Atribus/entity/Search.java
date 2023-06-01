package com.atribus.Atribus.entity;

import com.atribus.Atribus.entity.twitter.twittersTweets.TwittersTweetsHashtag;
import com.atribus.Atribus.entity.twitter.twittersTweets.TwittersTweet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "searchs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Search {

    //ATRIBUTOS:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "search_id")
    private int searchId;

    @Column(name= "crawlers_id")
    private String crawlersId;

    @Column(name= "category_id")
    private int categoryId;

    @Column(name= "search")
    private String search;

    @Column(name= "active")
    private int active;

    @Column(name= "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp date;

    @Column(name= "timezone")
    private String timezone;

    @Column(name= "geo_unknown")
    private byte geoUnknown;

    @Column(name= "avatar")
    private boolean avatar;

    @Column(name= "min_follower")
    private Long minFollower;

    @Column(name= "max_follower")
    private Long maxFollower;

    @Column(name= "verified")
    private boolean verified;

    @Column(name= "description")
    private String description;

    @Column(name= "app")
    private int app;

    @Column(name= "filter_not_lang")
    private String filterNotLang;

    @Column(name= "filter_not_geo")
    private String filterNotGeo;

    @Column(name= "filter_sentiment")
    private String filterSentiment;

    @Column(name= "filter_user")
    private String filterUser;

    @Column(name= "rss")
    private String rss;

    @Column(name= "pause")
    private boolean pause;

    @Column(name= "mention_limit")
    private int mentionLimit;

    //RELACIÓN CON TWITTERSTWEET:
    @OneToMany(mappedBy = "searchs")
    @JsonIgnore
    private Set<TwittersTweet> twittersTweets;

    //RELACIÓN CON TWITTERSTWEETSHASHTAG:
    @OneToMany(mappedBy = "searchs")
    @JsonIgnore
    private Set<TwittersTweetsHashtag> twittersTweetsHashtags;

}
