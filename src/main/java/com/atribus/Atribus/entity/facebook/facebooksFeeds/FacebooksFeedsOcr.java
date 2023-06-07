package com.atribus.Atribus.entity.facebook.facebooksFeeds;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "facebooks_feeds_ocrs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacebooksFeedsOcr {
    @Embeddable
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CompoundId implements Serializable {
        @Column(name = "facebooks_feeds_id")
        private Long facebooksFeedsId;

        @Column(name = "text")
        private String text;

        @Column(name = "polygone")
        private String polygone;

        @Column(name = "start_time")
        private double startTime;

        @Column(name = "end_time")
        private double endTime;
    }

    //ATRIBUTOS:
    @EmbeddedId
    private CompoundId id;

    @Column(name = "width")
    private int width;

    @Column(name = "height")
    private int height;

}
