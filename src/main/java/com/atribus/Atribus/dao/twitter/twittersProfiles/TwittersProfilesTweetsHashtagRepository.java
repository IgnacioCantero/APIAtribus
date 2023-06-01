package com.atribus.Atribus.dao.twitter.twittersProfiles;

import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesTweetsHashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Date;
import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface TwittersProfilesTweetsHashtagRepository extends JpaRepository<TwittersProfilesTweetsHashtag, Long> {

    //FUNCIONES DINÁMICAS:
    @Query("select fol from TwittersProfilesTweetsHashtag fol where fol.id.profileId = ?1")
    List<TwittersProfilesTweetsHashtag> getTwittersProfilesTweetsHashtagByProfileId(int profileId);
    //Show by profile_id

    //SERVICE -> CONTROLLER
    List<TwittersProfilesTweetsHashtag> findByDateCreated(Date dateCreated);
    List<TwittersProfilesTweetsHashtag> findById_CategoryIdAndDateCreated(int category, Date dateCreated);

}
