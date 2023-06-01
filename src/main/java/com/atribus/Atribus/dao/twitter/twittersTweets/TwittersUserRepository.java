package com.atribus.Atribus.dao.twitter.twittersTweets;

import com.atribus.Atribus.entity.twitter.twittersTweets.TwittersUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface TwittersUserRepository extends JpaRepository<TwittersUser, Long> {

    //FUNCIONES DINÁMICAS:
    @Query("select twittersUsers from TwittersUser twittersUsers where twittersUsers.twittersUsersId = ?1")
    List<TwittersUser> getTwittersUserByTwittersUsersId(Long twittersUsersId);
    //Show by twitters_users_id

}
