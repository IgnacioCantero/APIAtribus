package com.atribus.Atribus.entity.twitter.twittersProfiles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "twitters_profiles_followers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TwittersProfilesFollower {

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

        @Column(name = "twitters_profile_users_id")
        private Long twittersProfileUsersId;
    }

    //ATRIBUTOS:
    @EmbeddedId
    private CompoundId id;

    @Column(name = "name")
    private String name;

    @Column(name = "screen_name")
    private String screenName;

    @Column(name = "description")
    private String description;

    @Column(name = "tweet")
    private int tweet;

    @Column(name = "follower")
    private int follower;

    @Column(name = "follow")
    private int follow;

    @Column(name = "favorite")
    private int favorite;

    @Column(name = "list")
    private int list;

    @Column(name = "importance")
    private double importance;

    @Column(name = "default_avatar")
    private boolean defaultAvatar;

    @Column(name = "last_updated")
    @Temporal(TemporalType.DATE)
    private Date lastUpdated;

    @Column(name = "url_in_bio")
    private boolean urlInBio;

    @Column(name = "verified")
    private boolean verified;

    @Column(name = "language")
    private String language;

    @Column(name = "gender")
    private short gender;

    @Column(name = "geo_enabled")
    private boolean geoEnabled;

    @Column(name = "protected")
    private boolean protectedd;

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

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "url")
    private String url;

    @Column(name = "date_created")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;

    @Column(name = "bot_feature")
    private double botFeature;

    @Column(name = "bot_cap")
    private double botCap;

    @Column(name = "bot_astroturf")
    private double botAstroturf;

    @Column(name = "bot_other")
    private double botOther;

    @Column(name = "bot_spammer")
    private double botSpammer;

    @Column(name = "bot_financial")
    private double botFinancial;

    @Column(name = "bot_fake_follower")
    private double botFakeFollower;

    @Column(name = "bot_self_declared")
    private double botSelfDeclared;

    @Column(name = "age")
    private short age;

}
