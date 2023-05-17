package com.atribus.Atribus.twittersTweets.dao;

import com.atribus.Atribus.twittersTweets.entity.TwittersTweetsTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface TwittersTweetsTagRepository extends JpaRepository<TwittersTweetsTag, Long> {

    //FUNCIONES DINÁMICAS:
    @Query("select tag from TwittersTweetsTag tag where tag.twittersTweetsId = ?1")
    List<TwittersTweetsTag> getTwittersTweetsTagByTwittersTweetsId(Long twittersTweetsId);
    //Show by twitters_tweets_id

}
