package com.atribus.Atribus.entity.twitter.twittersProfiles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "twitters_profiles_tweets_tags")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TwittersProfilesTweetsTag {

    @Embeddable
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CompoundId implements Serializable {
        @Column(name = "twitters_profile_tweets_id")
        private Long twittersProfileTweetsId;

        @Column(name = "tag")
        private String tag;

        @Column(name = "subtag")
        private String subtag;
    }

    //ATRIBUTOS:
    @EmbeddedId
    private CompoundId id;

}
