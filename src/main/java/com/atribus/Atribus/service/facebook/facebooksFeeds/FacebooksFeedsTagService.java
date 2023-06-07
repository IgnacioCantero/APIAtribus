package com.atribus.Atribus.service.facebook.facebooksFeeds;

import com.atribus.Atribus.dao.facebook.facebooksFeeds.FacebooksFeedsTagRepository;
import com.atribus.Atribus.entity.facebook.facebooksFeeds.FacebooksFeedsTag;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class FacebooksFeedsTagService {

    @Autowired
    FacebooksFeedsTagRepository facebooksFeedsTagRepository;

    //MOSTRAR FACEBOOKSFEEDSTAG -> GET ALL (READ):
    public List<FacebooksFeedsTag> list() { return facebooksFeedsTagRepository.findAll(); }

    //PAGINACIÓN -> GET:
    public Slice<FacebooksFeedsTag> listPage(Pageable pageable) {
        return facebooksFeedsTagRepository.findAll(pageable);
    }

    //MÉTODO findByFacebooksFeedsId:
    public List<FacebooksFeedsTag> findByFacebooksFeedsId(Long facebooksFeedsId) {
        return facebooksFeedsTagRepository.findFacebooksFeedsTagById_FacebooksFeedsId(facebooksFeedsId);
    }

}
