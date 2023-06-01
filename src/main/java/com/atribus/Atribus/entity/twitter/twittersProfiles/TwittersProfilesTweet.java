package com.atribus.Atribus.entity.twitter.twittersProfiles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "twitters_profiles_tweets")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TwittersProfilesTweet {

    @Embeddable
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CompoundId implements Serializable {
        @Column(name = "twitters_profile_tweets_id")
        private Long twittersProfileTweetsId;

        @Column(name = "category_id")
        private int categoryId;

        @Column(name = "profile_id")
        private int profileId;
    }

    //ATRIBUTOS:
    @EmbeddedId
    private CompoundId id;

    @Column(name = "twitters_profile_users_id")
    private Long twittersProfileUsersId;

    @Column(name = "text")
    private String text;

    @Column(name = "source")
    private String source;

    @Column(name = "picture")
    private String picture;

    @Column(name = "lang")
    private String lang;

    @Column(name = "date_created", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Column(name = "location")
    private String location;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "county")
    private String county;

    @Column(name = "county_code")
    private String countyCode;

    @Column(name = "country")
    private String country;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "reply_twitters_users_id")
    private Long replyTwittersUsersId;

    @Column(name = "reply_twitters_tweets_id")
    private Long replyTwittersTweetsId;

    @Column(name = "retweet_twitters_users_id")
    private Long retweetTwittersUsersId;

    @Column(name = "retweet_twitters_tweets_id")
    private Long retweetTwittersTweetsId;

    @Column(name = "quoted_twitters_tweets_id")
    private Long quotedTwittersTweetsId;

    @Column(name = "count_retweet")
    private int countRetweet;

    @Column(name = "count_favorite")
    private int countFavorite;

    @Column(name = "sentiment")
    private short sentiment;

    @Column(name = "is_reply")
    private boolean isReply;

    @Column(name = "is_retweet")
    private boolean isRetweet;

    @Column(name = "is_favorite")
    private boolean isFavorite;

    @Column(name = "is_delete")
    private boolean isDelete;

    @Column(name = "alert")
    private boolean alert;

    @Column(name = "ocr")
    private boolean ocr;

}
