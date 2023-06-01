package com.atribus.Atribus.entity.twitter.twittersProfiles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "twitters_profiles_statistics")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TwittersProfilesStatistic {
    @Embeddable
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CompoundId implements Serializable {
        @Column(name = "category_id")
        private int categoryId;

        @Column(name = "profile_id")
        private int profileId;

        @Column(name = "date_calculated")
        @Temporal(TemporalType.DATE)
        private Date dateCalculated;
    }

    //ATRIBUTOS:
    @EmbeddedId
    private CompoundId id;

    @Column(name = "follow")
    private int follow;

    @Column(name = "follower")
    private int follower;

    @Column(name = "tweet")
    private int tweet;

    @Column(name = "list")
    private int list;

    @Column(name = "favorite")
    private int favorite;

    @Column(name = "updated")
    private int updated;

    @Column(name = "retweeted")
    private int retweeted;

    @Column(name = "retweeting")
    private int retweeting;

    @Column(name = "mentioned")
    private int mentioned;

    @Column(name = "mentioning")
    private int mentioning;

    @Column(name = "responded")
    private int responded;

    @Column(name = "responding")
    private int responding;

    @Column(name = "importance")
    private double importance;

    @Column(name = "followers_ratio_low_follow")
    private int followersRatioLowFollow;

    @Column(name = "follows_ratio_low_follow")
    private int followsRatioLowFollow;

    @Column(name = "followers_inactive")
    private int followersInactive;

    @Column(name = "follows_inactive")
    private int followsInactive;

    @Column(name = "followers_verified")
    private int followersVerified;

    @Column(name = "follows_verified")
    private int followsVerified;

    @Column(name = "followers_influence")
    private int followersInfluence;

    @Column(name = "follows_influence")
    private int followsInfluence;

    @Column(name = "followers_noob")
    private int followersNoob;

    @Column(name = "follows_noob")
    private int followsNoob;

}
