package com.atribus.Atribus.entity.twitter.twittersProfiles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "twitters_profiles_tweets_hashtags")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TwittersProfilesTweetsHashtag {

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

        @Column(name = "hashtag")
        private String hashtag;
    }

    //ATRIBUTOS:
    @EmbeddedId
    private CompoundId id;

    @Column(name = "date_created")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;

    @Column(name = "sentiment")
    private short sentiment;

}
