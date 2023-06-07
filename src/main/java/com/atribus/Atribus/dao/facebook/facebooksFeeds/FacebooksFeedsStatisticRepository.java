package com.atribus.Atribus.dao.facebook.facebooksFeeds;

import com.atribus.Atribus.entity.facebook.facebooksFeeds.FacebooksFeedsStatistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface FacebooksFeedsStatisticRepository extends JpaRepository<FacebooksFeedsStatistic, Long> {

    //FUNCIONES DINÁMICAS:
    @Query("select ff from FacebooksFeedsStatistic ff where ff.facebooksFeedsId = ?1")
    List<FacebooksFeedsStatistic> getFacebooksFeedByFacebooksFeedsId(Long facebooksFeedsId);
    //Show by facebooks_feeds_id

    //SERVICE -> CONTROLLER
    List<FacebooksFeedsStatistic> findByFacebooksFeedsId(Long facebooksFeedsId);

}
