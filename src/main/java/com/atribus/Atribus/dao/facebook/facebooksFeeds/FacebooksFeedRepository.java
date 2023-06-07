package com.atribus.Atribus.dao.facebook.facebooksFeeds;

import com.atribus.Atribus.entity.facebook.facebooksFeeds.FacebooksFeed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Date;
import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface FacebooksFeedRepository extends JpaRepository<FacebooksFeed, Long> {

    //FUNCIONES DINÁMICAS:
    @Query("select ff from FacebooksFeed ff where ff.id.facebooksFeedsId = ?1")
    List<FacebooksFeed> getFacebooksFeedById_FacebooksFeedsId(Long facebooksFeedsId);
    //Show by facebooks_feeds_id

    //SERVICE -> CONTROLLER
    List<FacebooksFeed> findByIdSearchIdAndDateCreated(int search, Date dateCreated);
    List<FacebooksFeed> findByIdCategoryIdAndDateCreated(int category, Date dateCreated);
    List<FacebooksFeed> findByDateCreated(Date dateCreated);
    List<FacebooksFeed> findByIdCategoryIdAndIdSearchIdAndDateCreated(int category, int search, Date dateCreated);

}
