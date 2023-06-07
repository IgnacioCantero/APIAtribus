package com.atribus.Atribus.service.facebook.facebooksFeeds;

import com.atribus.Atribus.dao.facebook.facebooksFeeds.FacebooksFeedRepository;
import com.atribus.Atribus.entity.facebook.facebooksFeeds.FacebooksFeed;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class FacebooksFeedService {

    @Autowired
    FacebooksFeedRepository facebooksFeedRepository;

    //MOSTRAR FACEBOOKSFEED -> GET ALL (READ):
    public List<FacebooksFeed> list() { return facebooksFeedRepository.findAll(); }

    //PAGINACIÓN -> GET:
    public Slice<FacebooksFeed> listPage(Pageable pageable) {
        return facebooksFeedRepository.findAll(pageable);
    }

    //MÉTODO findBySearchIdAndDateCreated:
    public List<FacebooksFeed> findBySearchAndDateCreated(int search, Date dateCreated) {
        return facebooksFeedRepository.findByIdSearchIdAndDateCreated(search, dateCreated);
    }

    //MÉTODO findByCategoryIdAndDateCreated:
    public List<FacebooksFeed> findByCategoryIdAndDateCreated(int category, Date dateCreated) {
        return facebooksFeedRepository.findByIdCategoryIdAndDateCreated(category, dateCreated);
    }

    //MÉTODO findByDateCreated:
    public List<FacebooksFeed> findByDateCreated(Date dateCreated) {
        return facebooksFeedRepository.findByDateCreated(dateCreated);
    }

    //MÉTODO findByCategoryIdAndSearchIdAndDateCreated:
    public List<FacebooksFeed> findByCategoryIdAndSearchAndDateCreated(int category, int search, Date dateCreated) {
        return facebooksFeedRepository.findByIdCategoryIdAndIdSearchIdAndDateCreated(category, search, dateCreated);
    }

}
