package com.atribus.Atribus.dao.twitter.twittersProfiles;

import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesFollowersWordsCloudBio;
import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesFollowsWordsCloudBio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface TwittersProfilesFollowsWordsCloudBioRepository extends JpaRepository<TwittersProfilesFollowsWordsCloudBio, Long> {

    //FUNCIONES DINÁMICAS:
    @Query("select fol from TwittersProfilesFollowsWordsCloudBio fol where fol.id.profileId = ?1")
    List<TwittersProfilesFollowsWordsCloudBio> getTwittersProfilesFollowsWordsCloudBioByProfileId(int profileId);
    //Show by profile_id

    //SERVICE -> CONTROLLER
    List<TwittersProfilesFollowsWordsCloudBio> getById_DateCreated(Date dateCreated);
    List<TwittersProfilesFollowsWordsCloudBio> getById_CategoryIdAndId_DateCreated(int category, Date dateCreated);

}
