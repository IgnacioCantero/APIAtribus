package com.atribus.Atribus.dao.twitter.twittersProfiles;

import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesTweetsHashtag;
import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesTweetsUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface TwittersProfilesTweetsUrlRepository extends JpaRepository<TwittersProfilesTweetsUrl, Long> {

    //FUNCIONES DINÁMICAS:
    @Query("select fol from TwittersProfilesTweetsUrl fol where fol.id.twittersProfileTweetsId = ?1")
    List<TwittersProfilesTweetsUrl> getTwittersProfilesTweetsUrlById_TwittersProfileTweetsId(Long id);
    //Show by profile_id

    //SERVICE -> CONTROLLER
    List<TwittersProfilesTweetsUrl> findById_TwittersProfileTweetsId(Long id);

}
