package com.atribus.Atribus.dao.twitter.twittersProfiles;

import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Date;
import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface TwittersProfilesUserRepository extends JpaRepository<TwittersProfilesUser, Long> {

    //FUNCIONES DINÁMICAS:
    @Query("select fol from TwittersProfilesUser fol where fol.twittersProfileUsersId = ?1")
    List<TwittersProfilesUser> getTwittersProfilesUsersByTwittersProfileUsersId(Long id);
    //Show by twittersProfilesUsersId

    //SERVICE -> CONTROLLER
    List<TwittersProfilesUser> findByTwittersProfileUsersId(Long id);
    List<TwittersProfilesUser> findByDateCreated(Date dateCreated);

}
