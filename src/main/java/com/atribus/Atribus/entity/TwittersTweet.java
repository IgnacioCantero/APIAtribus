package com.atribus.Atribus.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.persistence.Table;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "twitters_tweets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TwittersTweet {

    //ATRIBUTOS:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "twitters_tweets_id")
    private Long twittersTweetsId;

        //RELACIÓN CON CATEGORIE:
        @ManyToOne
        @JoinColumn(name = "category_id", nullable = false)
        @JsonIgnoreProperties({"categoryId", "active", "date", "app"})
        private Categorie categories;

        //RELACIÓN CON SEARCH:
        @ManyToOne
        @JoinColumn(name = "search_id", nullable = false)
        @JsonIgnoreProperties({"searchId", "crawlersId", "categoryId", "active", "date", "timezone", "geoUnknown", "avatar", "minFollower", "maxFollower", "verified", "description", "app", "filterNotLang", "filterNotGeo", "filterSentiment", "filterUser", "rss", "pause", "mentionLimit"})
        private Search searchs;

        //RELACIÓN CON TWITTERSTWEETSOCRS:
        @OneToOne(mappedBy = "twittersTweet")
        @JoinColumn(name = "twitters_tweets_id")
        @JsonIgnoreProperties("twittersTweetsId")
        @JsonIgnore
        private TwittersTweetsOcr twittersTweetsOcr;

        //RELACIÓN CON TWITTERSTWEETSPLNNER:
        @OneToOne(mappedBy = "twittersTweet")
        @JoinColumn(name = "twitters_tweets_id")
        @JsonIgnoreProperties("twittersTweetsId")
        @JsonIgnore
        private TwittersTweetsPlnNer twittersTweetsPlnNer;

        //RELACIÓN CON TWITTERSTWEETSSTATISTICS:
        @OneToOne(mappedBy = "twittersTweet")
        @JoinColumn(name = "twitters_tweets_id")
        @JsonIgnoreProperties("twittersTweetsId")
        @JsonIgnore
        private TwittersTweetsStatistic twittersTweetsStatistic;

        //RELACIÓN CON TWITTERSTWEETSTAGS:
        @OneToOne(mappedBy = "twittersTweet")
        @JoinColumn(name = "twitters_tweets_id")
        @JsonIgnoreProperties("twittersTweetsId")
        @JsonIgnore
        private TwittersTweetsTag twittersTweetsTag;

        //RELACIÓN CON TWITTERSTWEETSURLS:
        @OneToOne(mappedBy = "twittersTweet")
        @JoinColumn(name = "twitters_tweets_id")
        @JsonIgnoreProperties("twittersTweetsId")
        @JsonIgnore
        private TwittersTweetsUrl twittersTweetsUrl;

    @Column(name= "twitters_users_id")
    private Long twittersUsersId;
    
    @Column(name= "text")
    private String text;
    
    @Column(name= "source")
    private String source;
    
    @Column(name= "picture")
    private String picture;
    
    @Column(name= "lang")
    private String lang;
    
    @Column(name= "date_created")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;

    @Column(name= "datetime_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp datetimeCreated;
    
    @Column(name= "location")
    private String location;
    
    @Column(name= "latitude")
    private double latitude;
    
    @Column(name= "longitude")
    private double longitude;
    
    @Column(name= "county")
    private String county;
    
    @Column(name= "county_code")
    private String countyCode;
    
    @Column(name= "country")
    private String country;
    
    @Column(name= "country_code")
    private String countryCode;
    
    @Column(name= "reply_twitters_users_id")
    private Long replyTwittersUsersId;
    
    @Column(name= "reply_twitters_tweets_id")
    private Long replyTwittersTweetsId;
    
    @Column(name= "retweet_twitters_users_id")
    private Long retweetTwittersUsersId;
    
    @Column(name= "retweet_twitters_tweets_id")
    private Long retweetTwittersTweetsId;
    
    @Column(name= "quoted_twitters_tweets_id")
    private Long quotedTwittersTweetsId;
    
    @Column(name= "type")
    private short type;
    
    @Column(name= "count_retweet")
    private int countRetweet;
    
    @Column(name= "count_favorite")
    private int countFavorite;
    
    @Column(name= "statistic_importance")
    private double statisticImportance;
    
    @Column(name= "sentiment")
    private short sentiment;
    
    @Column(name= "sentiment_human")
    private short sentimentHuman;
    
    @Column(name= "sentiment_train")
    private boolean sentimentTrain;
    
    @Column(name= "is_reply")
    private boolean isReply;
    
    @Column(name= "is_retweet")
    private boolean isRetweet;
    
    @Column(name= "is_favorite")
    private boolean isFavorite;

    @Column(name= "spam")
    private short spam;

    @Column(name= "is_delete")
    private boolean isDelete;
    
    @Column(name= "alert")
    private boolean alert;
    
    @Column(name= "moderate")
    private boolean moderate;
    
    @Column(name= "ocr")
    private boolean ocr;
    
    @Column(name= "pln")
    private boolean pln;
    
    @Column(name= "pln_ner_label")
    private String plnNerLabel;

}
