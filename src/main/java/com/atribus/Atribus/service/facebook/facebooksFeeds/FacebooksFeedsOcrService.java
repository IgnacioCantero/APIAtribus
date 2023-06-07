package com.atribus.Atribus.service.facebook.facebooksFeeds;

import com.atribus.Atribus.dao.facebook.facebooksFeeds.FacebooksFeedsOcrRepository;
import com.atribus.Atribus.entity.facebook.facebooksFeeds.FacebooksFeed;
import com.atribus.Atribus.entity.facebook.facebooksFeeds.FacebooksFeedsOcr;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class FacebooksFeedsOcrService {

    @Autowired
    FacebooksFeedsOcrRepository facebooksFeedsOcrRepository;

    //MOSTRAR FACEBOOKSFEEDSOCR -> GET ALL (READ):
    public List<FacebooksFeedsOcr> list() { return facebooksFeedsOcrRepository.findAll(); }

    //PAGINACIÓN -> GET:
    public Slice<FacebooksFeedsOcr> listPage(Pageable pageable) {
        return facebooksFeedsOcrRepository.findAll(pageable);
    }

    //MÉTODO findByFacebooksFeedsId:
    public List<FacebooksFeedsOcr> findByFacebooksFeedsId(Long id) {
        return facebooksFeedsOcrRepository.findById_FacebooksFeedsId(id);
    }

}
