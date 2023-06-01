package com.atribus.Atribus.dao.twitter.twittersProfiles;

import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesFollower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Date;
import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface TwittersProfilesFollowerRepository extends JpaRepository<TwittersProfilesFollower, Long> {

    //FUNCIONES DINÁMICAS:
    @Query("select fol from TwittersProfilesFollower fol where fol.id.profileId = ?1")
    List<TwittersProfilesFollower> getTwittersProfilesFollowerByProfileId(int profileId);
    //Show by profile_id

    //SERVICE -> CONTROLLER
    List<TwittersProfilesFollower> findByDateCreated(Date dateCreated);

    List<TwittersProfilesFollower> findById_CategoryIdAndDateCreated(int category, Date dateCreated);

}
