package com.atribus.Atribus.dao;

import com.atribus.Atribus.entity.TwittersTweetsUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface TwittersTweetsUrlRepository extends JpaRepository<TwittersTweetsUrl, Long> {

    //FUNCIONES DINÁMICAS:
    @Query("select url from TwittersTweetsUrl url where url.twittersTweetsId = ?1")
    List<TwittersTweetsUrl> getTwittersTweetsUrlByTwittersTweetsId(Long twittersTweetsId);
    //Show by twitters_tweets_id

}
