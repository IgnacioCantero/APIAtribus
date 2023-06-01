package com.atribus.Atribus.dao.twitter.twittersProfiles;

import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesFollow;
import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesFollower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Date;
import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface TwittersProfilesFollowRepository extends JpaRepository<TwittersProfilesFollow, Long> {

    //FUNCIONES DINÁMICAS:
    @Query("select fol from TwittersProfilesFollow fol where fol.id.profileId = ?1")
    List<TwittersProfilesFollow> getTwittersProfilesFollowByProfileId(int profileId);
    //Show by profile_id

    //SERVICE -> CONTROLLER
    List<TwittersProfilesFollow> findByDateCreated(Date dateCreated);

    List<TwittersProfilesFollow> findById_CategoryIdAndDateCreated(int category, Date dateCreated);

}
