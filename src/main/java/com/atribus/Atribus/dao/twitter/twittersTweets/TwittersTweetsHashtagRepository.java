package com.atribus.Atribus.dao.twitter.twittersTweets;

import com.atribus.Atribus.entity.twitter.twittersTweets.TwittersTweetsHashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface TwittersTweetsHashtagRepository extends JpaRepository<TwittersTweetsHashtag, Long> {

    //FUNCIONES DINÁMICAS:
    @Query("select hash from TwittersTweetsHashtag hash where hash.twittersTweetsId = ?1")
    List<TwittersTweetsHashtag> getTwittersTweetsHashtagByTwittersTweetsId(Long twittersTweetsId);
    //Show by twitters_tweets_id

}
