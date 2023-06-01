package com.atribus.Atribus.dao.twitter.twittersProfiles;

import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesTweetsTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Date;
import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface TwittersProfilesTweetsTagRepository extends JpaRepository<TwittersProfilesTweetsTag, Long> {

    //FUNCIONES DINÁMICAS:
    @Query("select fol from TwittersProfilesTweetsTag fol where fol.id.twittersProfileTweetsId = ?1")
    List<TwittersProfilesTweetsTag> getTwittersProfilesTweetsTagByTwittersProfileTweetsId(Long id);
    //Show by profile_id

    //SERVICE -> CONTROLLER
    List<TwittersProfilesTweetsTag> findById_TwittersProfileTweetsId(Long id);

}
