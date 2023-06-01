package com.atribus.Atribus.dao.twitter.twittersProfiles;

import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesTweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Date;
import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface TwittersProfilesTweetRepository extends JpaRepository<TwittersProfilesTweet, Long> {

    //FUNCIONES DINÁMICAS:
    @Query("select fol from TwittersProfilesTweet fol where fol.id.profileId = ?1")
    List<TwittersProfilesTweet> getTwittersProfilesTweetByProfileId(int profileId);
    //Show by profile_id

    //SERVICE -> CONTROLLER
    List<TwittersProfilesTweet> findByDateCreated(Date dateCreated);
    List<TwittersProfilesTweet> findById_CategoryIdAndDateCreated(int category, Date dateCreated);

}
