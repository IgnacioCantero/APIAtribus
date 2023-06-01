package com.atribus.Atribus.entity.twitter.twittersProfiles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Entity
@Table(name = "twitters_profiles_tweets_urls")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TwittersProfilesTweetsUrl {

    @Embeddable
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CompoundId implements Serializable {
        @Column(name = "twitters_profile_tweets_id")
        private Long twittersProfileTweetsId;

        @Column(name = "urls")
        private String urls;
    }

    //ATRIBUTOS:
    @EmbeddedId
    private CompoundId id;

}
