package com.atribus.Atribus.dao.facebook.facebooksFeeds;

import com.atribus.Atribus.entity.facebook.facebooksFeeds.FacebooksFeedsTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface FacebooksFeedsTagRepository extends JpaRepository<FacebooksFeedsTag, Long> {

    //FUNCIONES DINÁMICAS:
    @Query("select ff from FacebooksFeedsTag ff where ff.id.facebooksFeedsId = ?1")
    List<FacebooksFeedsTag> getFacebooksFeedsTagById_FacebooksFeedsId(Long facebooksFeedsId);
    //Show by facebooks_feeds_id

    //SERVICE -> CONTROLLER
    List<FacebooksFeedsTag> findFacebooksFeedsTagById_FacebooksFeedsId(Long facebooksFeedsId);

}
