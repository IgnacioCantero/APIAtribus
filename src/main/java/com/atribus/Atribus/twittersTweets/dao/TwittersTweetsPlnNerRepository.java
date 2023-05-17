package com.atribus.Atribus.twittersTweets.dao;

import com.atribus.Atribus.twittersTweets.entity.TwittersTweetsPlnNer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface TwittersTweetsPlnNerRepository extends JpaRepository<TwittersTweetsPlnNer, Long> {

    //FUNCIONES DINÁMICAS:
    @Query("select pln from TwittersTweetsPlnNer pln where pln.twittersTweetsId = ?1")
    List<TwittersTweetsPlnNer> getTwittersTweetsPlnNerByTwittersTweetsId(Long twittersTweetsId);
    //Show by twitters_tweets_id

}
