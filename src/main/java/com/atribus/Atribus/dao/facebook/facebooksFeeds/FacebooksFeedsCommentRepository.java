package com.atribus.Atribus.dao.facebook.facebooksFeeds;

import com.atribus.Atribus.entity.facebook.facebooksFeeds.FacebooksFeed;
import com.atribus.Atribus.entity.facebook.facebooksFeeds.FacebooksFeedsComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Date;
import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface FacebooksFeedsCommentRepository extends JpaRepository<FacebooksFeedsComment, Long> {

    //FUNCIONES DINÁMICAS:
    @Query("select ff from FacebooksFeedsComment ff where ff.id.facebooksFeedsCommentsId = ?1")
    List<FacebooksFeed> getFacebooksFeedsCommentById_FacebooksFeedsCommentsId(Long facebooksFeedsCommentsId);
    //Show by facebooks_feeds_comments_id

    //SERVICE -> CONTROLLER
    List<FacebooksFeedsComment> findByIdSearchIdAndDateCreated(int search, Date dateCreated);
    List<FacebooksFeedsComment> findByIdCategoryIdAndDateCreated(int category, Date dateCreated);
    List<FacebooksFeedsComment> findByDateCreated(Date dateCreated);
    List<FacebooksFeedsComment> findByIdCategoryIdAndIdSearchIdAndDateCreated(int category, int search, Date dateCreated);


}
