package com.atribus.Atribus.dao.twitter.twittersProfiles;

import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesFollowersWordsCloudBio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Date;
import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface TwittersProfilesFollowersWordsCloudBioRepository extends JpaRepository<TwittersProfilesFollowersWordsCloudBio, Long> {

    //FUNCIONES DINÁMICAS:
    @Query("select fol from TwittersProfilesFollowersWordsCloudBio fol where fol.id.profileId = ?1")
    List<TwittersProfilesFollowersWordsCloudBio> getTwittersProfilesFollowersWordsCloudBioByProfileId(int profileId);
    //Show by profile_id

    //SERVICE -> CONTROLLER
    List<TwittersProfilesFollowersWordsCloudBio> getById_DateCreated(Date dateCreated);
    List<TwittersProfilesFollowersWordsCloudBio> getById_CategoryIdAndId_DateCreated(int category, Date dateCreated);

}
