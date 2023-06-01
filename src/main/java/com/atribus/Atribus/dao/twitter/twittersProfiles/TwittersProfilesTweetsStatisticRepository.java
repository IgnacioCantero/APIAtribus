package com.atribus.Atribus.dao.twitter.twittersProfiles;

import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesTweetsHashtag;
import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesTweetsStatistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface TwittersProfilesTweetsStatisticRepository extends JpaRepository<TwittersProfilesTweetsStatistic, Long> {

    //FUNCIONES DINÁMICAS:
    @Query("select fol from TwittersProfilesTweetsStatistic fol where fol.twittersProfileTweetsId = ?1")
    List<TwittersProfilesTweetsStatistic> getTwittersProfilesTweetsStatisticByTwittersProfileTweetsId(Long id);
    //Show by profile_id

    //SERVICE -> CONTROLLER
    List<TwittersProfilesTweetsStatistic> findByTwittersProfileTweetsId(Long id);

}
