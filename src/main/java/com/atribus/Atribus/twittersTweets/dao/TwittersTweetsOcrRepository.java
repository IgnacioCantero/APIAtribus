package com.atribus.Atribus.twittersTweets.dao;

import com.atribus.Atribus.twittersTweets.entity.TwittersTweetsOcr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface TwittersTweetsOcrRepository extends JpaRepository<TwittersTweetsOcr, Long> {

    //FUNCIONES DINÁMICAS:
    @Query("select ocrs from TwittersTweetsOcr ocrs where ocrs.twittersTweetsId = ?1")
    List<TwittersTweetsOcr> getTwittersTweetsOcrByTwittersTweetsId(Long twittersTweetsId);
    //Show by twitters_tweets_id

}