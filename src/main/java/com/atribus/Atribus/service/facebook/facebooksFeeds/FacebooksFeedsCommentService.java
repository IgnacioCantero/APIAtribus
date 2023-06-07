package com.atribus.Atribus.service.facebook.facebooksFeeds;

import com.atribus.Atribus.dao.facebook.facebooksFeeds.FacebooksFeedsCommentRepository;
import com.atribus.Atribus.entity.facebook.facebooksFeeds.FacebooksFeed;
import com.atribus.Atribus.entity.facebook.facebooksFeeds.FacebooksFeedsComment;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class FacebooksFeedsCommentService {

    @Autowired
    FacebooksFeedsCommentRepository facebooksFeedsCommentRepository;

    //MOSTRAR FACEBOOKSFEEDSCOMMENT -> GET ALL (READ):
    public List<FacebooksFeedsComment> list() { return facebooksFeedsCommentRepository.findAll(); }

    //PAGINACIÓN -> GET:
    public Slice<FacebooksFeedsComment> listPage(Pageable pageable) {
        return facebooksFeedsCommentRepository.findAll(pageable);
    }

    //MÉTODO findBySearchIdAndDateCreated:
    public List<FacebooksFeedsComment> findBySearchAndDateCreated(int search, Date dateCreated) {
        return facebooksFeedsCommentRepository.findByIdSearchIdAndDateCreated(search, dateCreated);
    }

    //MÉTODO findByCategoryIdAndDateCreated:
    public List<FacebooksFeedsComment> findByCategoryIdAndDateCreated(int category, Date dateCreated) {
        return facebooksFeedsCommentRepository.findByIdCategoryIdAndDateCreated(category, dateCreated);
    }

    //MÉTODO findByDateCreated:
    public List<FacebooksFeedsComment> findByDateCreated(Date dateCreated) {
        return facebooksFeedsCommentRepository.findByDateCreated(dateCreated);
    }

    //MÉTODO findByCategoryIdAndSearchIdAndDateCreated:
    public List<FacebooksFeedsComment> findByCategoryIdAndSearchAndDateCreated(int category, int search, Date dateCreated) {
        return facebooksFeedsCommentRepository.findByIdCategoryIdAndIdSearchIdAndDateCreated(category, search, dateCreated);
    }

}
