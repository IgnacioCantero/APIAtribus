package com.atribus.Atribus.entity.facebook.facebooksFeeds;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Entity
@Table(name = "facebooks_feeds_tags")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacebooksFeedsTag {
    @Embeddable
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CompoundId implements Serializable {
        @Column(name = "facebooks_feeds_id")
        private Long facebooksFeedsId;

        @Column(name = "tag")
        private String tag;

        @Column(name = "subtag")
        private String subtag;
    }

    //ATRIBUTOS:
    @EmbeddedId
    private CompoundId id;

}
