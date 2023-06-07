package com.atribus.Atribus.entity.facebook.facebooksFeeds;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "facebooks_feeds_comments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacebooksFeedsComment {
    @Embeddable
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CompoundId implements Serializable {
        @Column(name = "facebooks_feeds_comments_id")
        private int facebooksFeedsCommentsId;

        @Column(name = "category_id")
        private int categoryId;

        @Column(name = "search_id")
        private int searchId;
    }

    //ATRIBUTOS:
    @EmbeddedId
    private CompoundId id;

    @Column(name = "facebooks_feeds_id")
    private Long facebooksFeedsId;

    @Column(name = "text")
    private String text;

    @Column(name= "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp dateCreated;

    @Column(name = "sentiment")
    private short sentiment;

    @Column(name = "lang")
    private String lang;

}
