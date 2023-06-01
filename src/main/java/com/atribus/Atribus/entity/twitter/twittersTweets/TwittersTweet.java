package com.atribus.Atribus.entity.twitter.twittersTweets;

import com.atribus.Atribus.entity.Search;
import com.atribus.Atribus.entity.Categorie;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;
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
    //@JsonIgnore    //todo -> dejar con @JsonIgnore para ocultar el id del tweet y mostrar el id del user
    private Long twittersTweetsId;

            //RELACIÓN CON TWITTERSTWEETSHASHTAG:
//todo -> revisar esta relación ya que solo devuelve un hashtag por tweet
            @OneToMany(mappedBy = "twittersTweet", fetch = FetchType.EAGER)
            @JsonIgnoreProperties({"twittersTweetsId", "dateCreated", "sentimentHuman", "searchs"})
            private Set<TwittersTweetsHashtag> twittersTweetsHashtags;

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

        //RELACIÓN CON TWITTERSUSERS:
        @ManyToOne
        @JoinColumn(name = "twitters_users_id", nullable = false)
        private TwittersUser twittersUsers;

        //RELACIÓN CON TWITTERSTWEETSOCRS:
        @OneToOne(mappedBy = "twittersTweet")
        @JoinColumn(name = "twitters_tweets_id")
        @JsonIgnoreProperties({"twittersTweetsId", "polygone", "startTime", "endTime", "width", "height"})
        private TwittersTweetsOcr twittersTweetsOcr;

        //RELACIÓN CON TWITTERSTWEETSPLNNER:
        @OneToOne(mappedBy = "twittersTweet")
        @JoinColumn(name = "twitters_tweets_id")
        @JsonIgnoreProperties({"twittersTweetsId", "score"})
        private TwittersTweetsPlnNer twittersTweetsPlnNer;

        //RELACIÓN CON TWITTERSTWEETSSTATISTICS:
        @OneToOne(mappedBy = "twittersTweet")
        @JoinColumn(name = "twitters_tweets_id")
        @JsonIgnoreProperties("twittersTweetsId")
        private TwittersTweetsStatistic twittersTweetsStatistic;

        //RELACIÓN CON TWITTERSTWEETSTAGS:
        @OneToOne(mappedBy = "twittersTweet")
        @JoinColumn(name = "twitters_tweets_id")
        @JsonIgnoreProperties("twittersTweetsId")
        private TwittersTweetsTag twittersTweetsTag;

        //RELACIÓN CON TWITTERSTWEETSURLS:
        @OneToOne(mappedBy = "twittersTweet")
        @JoinColumn(name = "twitters_tweets_id")
        @JsonIgnoreProperties("twittersTweetsId")
        private TwittersTweetsUrl twittersTweetsUrl;

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
    @JsonIgnore
    private short sentimentHuman;
    
    @Column(name= "sentiment_train")
    @JsonIgnore
    private boolean sentimentTrain;
    
    @Column(name= "is_reply")
    @JsonIgnore
    private boolean isReply;
    
    @Column(name= "is_retweet")
    @JsonIgnore
    private boolean isRetweet;
    
    @Column(name= "is_favorite")
    @JsonIgnore
    private boolean isFavorite;

    @Column(name= "spam")
    @JsonIgnore
    private short spam;

    @Column(name= "is_delete")
    @JsonIgnore
    private boolean isDelete;
    
    @Column(name= "alert")
    @JsonIgnore
    private boolean alert;
    
    @Column(name= "moderate")
    @JsonIgnore
    private boolean moderate;
    
    @Column(name= "ocr")
    @JsonIgnore
    private boolean ocr;
    
    @Column(name= "pln")
    @JsonIgnore
    private boolean pln;
    
    @Column(name= "pln_ner_label")
    @JsonIgnore
    private String plnNerLabel;

}
