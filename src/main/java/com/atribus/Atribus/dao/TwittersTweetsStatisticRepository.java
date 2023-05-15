package com.atribus.Atribus.dao;

import com.atribus.Atribus.entity.TwittersTweetsStatistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface TwittersTweetsStatisticRepository extends JpaRepository<TwittersTweetsStatistic, Long> {

    //FUNCIONES DINÁMICAS:
    @Query("select sta from TwittersTweetsStatistic sta where sta.twittersTweetsId = ?1")
    List<TwittersTweetsStatistic> getTwittersTweetsStatisticByTwittersTweetsId(Long twittersTweetsId);
    //Show by twitters_tweets_id

}
