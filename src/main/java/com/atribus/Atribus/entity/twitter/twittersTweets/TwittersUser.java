package com.atribus.Atribus.entity.twitter.twittersTweets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "twitters_users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TwittersUser {

    //ATRIBUTOS:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "twitters_users_id")
    private Long twittersUsersId;

    //RELACIÓN CON TWITTERSTWEET:
    @OneToMany(mappedBy = "twittersUsers")
    @JsonIgnore
    private Set<TwittersTweet> twittersTweets;

    @Column(name= "screen_name")
    private String screenName;

    @Column(name= "name")
    private String name;

    @Column(name= "description")
    private String description;

    @Column(name= "url")
    private String url;

    @Column(name= "avatar")
    private String avatar;

    @Column(name= "date_created")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;

    @Column(name= "gender")
    private short gender;

    @Column(name= "location")
    private String location;

    @Column(name= "count_follow")
    private int countFollow;

    @Column(name= "count_follower")
    private int countFollower;

    @Column(name= "count_tweet")
    private int countTweet;

    @Column(name= "count_list")
    private int countList;

    @Column(name= "count_favorite")
    private int countFavorite;

    @Column(name= "is_verified")
    private boolean isVerified;

    @Column(name= "is_default_profile_image")
    private boolean isDefaultProfileImage;

    @Column(name= "bot_feature")
    private double botFeature;

    @Column(name= "bot_cap")
    private double botCap;

    @Column(name= "bot_astroturf")
    private double botAstroturf;

    @Column(name= "bot_other")
    private double botOther;

    @Column(name= "bot_spammer")
    private double botSpammer;

    @Column(name= "bot_financial")
    private double botFinancial;

    @Column(name= "bot_fake_follower")
    private double botFakeFollower;

    @Column(name= "bot_self_declared")
    private double botSelfDeclared;

    @Column(name= "age")
    private double age;

}
