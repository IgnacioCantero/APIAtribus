package com.atribus.Atribus.entity.twitter.twittersProfiles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "twitters_profiles_followers_words_cloud_bio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TwittersProfilesFollowersWordsCloudBio {

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

        @Column(name = "word")
        private String word;

        @Column(name = "date_created")
        @Temporal(TemporalType.DATE)
        private Date dateCreated;
    }

    //ATRIBUTOS:
    @EmbeddedId
    private CompoundId id;

    @Column(name = "count")
    private int count;

}
