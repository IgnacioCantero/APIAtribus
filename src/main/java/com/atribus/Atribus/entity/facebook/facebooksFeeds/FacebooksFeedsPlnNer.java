package com.atribus.Atribus.entity.facebook.facebooksFeeds;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Entity
@Table(name = "facebooks_feeds_pln_ner")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacebooksFeedsPlnNer {
    @Embeddable
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CompoundId implements Serializable {
        @Column(name = "facebooks_feeds_id")
        private Long facebooksFeedsId;

        @Column(name = "word")
        private String word;

        @Column(name = "label")
        private String label;
    }

    //ATRIBUTOS:
    @EmbeddedId
    private CompoundId id;

    @Column(name = "score")
    private double score;

}
