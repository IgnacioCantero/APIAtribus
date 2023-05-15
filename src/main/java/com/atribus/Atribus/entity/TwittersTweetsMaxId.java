package com.atribus.Atribus.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "twitters_tweets_max_ids")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TwittersTweetsMaxId {

    //ATRIBUTOS:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "search_id")
    private int searchId;

        //RELACIÓN CON SEARCH:
        @OneToOne
        @JoinColumn(name = "search_id")
        @JsonBackReference
        private Search search;

    @Column(name= "twitters_tweets_id")
    private Long twittersTweetsId;

}
