package com.atribus.Atribus.dao.facebook.facebooksFeeds;

import com.atribus.Atribus.entity.facebook.facebooksFeeds.FacebooksFeedsPlnNer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface FacebooksFeedsPlnNerRepository extends JpaRepository<FacebooksFeedsPlnNer, Long> {

    //FUNCIONES DINÁMICAS:
    @Query("select ff from FacebooksFeedsPlnNer ff where ff.id.facebooksFeedsId = ?1")
    List<FacebooksFeedsPlnNer> getFacebooksFeedsPlnNerById_FacebooksFeedsId(Long facebooksFeedsId);
    //Show by facebooks_feeds_id

    //SERVICE -> CONTROLLER
    List<FacebooksFeedsPlnNer> findById_FacebooksFeedsId(Long facebooksFeedsId);

}
