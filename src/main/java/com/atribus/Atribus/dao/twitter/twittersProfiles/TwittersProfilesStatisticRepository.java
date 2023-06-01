package com.atribus.Atribus.dao.twitter.twittersProfiles;

import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesStatistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Date;
import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface TwittersProfilesStatisticRepository extends JpaRepository<TwittersProfilesStatistic, Long> {

    //FUNCIONES DINÁMICAS:
    @Query("select fol from TwittersProfilesStatistic fol where fol.id.profileId = ?1")
    List<TwittersProfilesStatistic> getTwittersProfilesStatisticByProfileId(int profileId);
    //Show by profile_id

    //SERVICE -> CONTROLLER
    List<TwittersProfilesStatistic> getById_DateCalculated(Date dateCalculated);
    List<TwittersProfilesStatistic> getById_CategoryIdAndId_DateCalculated(int category, Date dateCalculated);

}
