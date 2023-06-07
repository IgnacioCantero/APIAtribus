package com.atribus.Atribus.dao.facebook.facebooksFeeds;

import com.atribus.Atribus.entity.facebook.facebooksFeeds.FacebooksFeedsOcr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface FacebooksFeedsOcrRepository extends JpaRepository<FacebooksFeedsOcr, Long> {

    //FUNCIONES DINÁMICAS:
    @Query("select ff from FacebooksFeedsOcr ff where ff.id.facebooksFeedsId = ?1")
    List<FacebooksFeedsOcr> getFacebooksFeedsOcrById_FacebooksFeedsId(Long facebooksFeedsId);
    //Show by facebooks_feeds_id

    //SERVICE -> CONTROLLER
    List<FacebooksFeedsOcr> findById_FacebooksFeedsId(Long facebooksFeedsId);

}
