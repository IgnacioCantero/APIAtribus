package com.atribus.Atribus.entity.twitter.twittersProfiles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "twitters_profiles_tweets_statistics")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TwittersProfilesTweetsStatistic {

    //ATRIBUTOS:
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "twitters_profile_tweets_id")
    //@JsonIgnore    //todo -> dejar con @JsonIgnore para ocultar el id del tweet y mostrar el id del user
    private Long twittersProfileTweetsId;

    @Column(name = "max_for_hour")
    private int maxForHour;

    @Column(name = "hours_of_max")
    private double hoursOfMax;

    @Column(name = "duration")
    private int duration;

    @Column(name = "rapidity")
    private double rapidity;

    @Column(name = "impression_potential")
    private int impressionPotential;

    @Column(name = "impression_estimated")
    private int impressionEstimated;

    @Column(name = "reach_potential")
    private int reachPotential;

    @Column(name = "reach_estimated")
    private int reachEstimated;

    @Column(name = "engagement")
    private double engagement;

    @Column(name = "interaction")
    private int interaction;

    @Column(name = "value_potential")
    private double valuePotential;

    @Column(name = "value_estimated")
    private double valueEstimated;

    @Column(name = "value_ayzenberg")
    private double valueAyzenberg;

    @Column(name = "impact_potential")
    private int impactPotential;

    @Column(name = "impact_estimated")
    private int impactEstimated;

    @Column(name = "count_follower")
    private int countFollower;

}
