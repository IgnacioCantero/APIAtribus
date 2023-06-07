package com.atribus.Atribus.entity.facebook.facebooksFeeds;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "facebooks_feeds")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacebooksFeed {
    @Embeddable
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CompoundId implements Serializable {
        @Column(name = "facebooks_feeds_id")
        private Long facebooksFeedsId;

        @Column(name = "category_id")
        private int categoryId;

        @Column(name = "search_id")
        private int searchId;
    }

    //ATRIBUTOS:
    @EmbeddedId
    private CompoundId id;

    @Column(name = "facebooks_users_pages_id")
    private Long facebooksUsersPagesId;

    @Column(name = "name")
    private String name;

    @Column(name = "message")
    private String message;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "picture")
    private String picture;

    @Column(name = "link")
    private String link;

    @Column(name = "lang")
    private String lang;

    @Column(name = "date_created")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;

    @Column(name= "datetime_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp datetimeCreated;

    @Column(name = "count_like")
    private int countLike;

    @Column(name = "count_comment")
    private int countComment;

    @Column(name = "count_share")
    private int countShare;

    @Column(name = "count_reaction")
    private int countReaction;

    @Column(name = "sentiment")
    private short sentiment;

    @Column(name = "is_like")
    private boolean isLike;

    @Column(name = "is_reply")
    private boolean isReply;

    @Column(name = "is_delete")
    private boolean isDelete;

    @Column(name = "alert")
    private boolean alert;

    @Column(name = "ocr")
    private boolean ocr;

    @Column(name = "pln")
    private boolean pln;

    @Column(name = "pln_ner_label")
    private String plnNerLabel;

}
