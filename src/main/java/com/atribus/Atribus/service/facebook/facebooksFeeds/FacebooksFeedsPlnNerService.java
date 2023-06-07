package com.atribus.Atribus.service.facebook.facebooksFeeds;

import com.atribus.Atribus.dao.facebook.facebooksFeeds.FacebooksFeedsPlnNerRepository;
import com.atribus.Atribus.entity.facebook.facebooksFeeds.FacebooksFeedsPlnNer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class FacebooksFeedsPlnNerService {

    @Autowired
    FacebooksFeedsPlnNerRepository facebooksFeedsPlnNerRepository;

    //MOSTRAR FACEBOOKSFEEDSPLNNER -> GET ALL (READ):
    public List<FacebooksFeedsPlnNer> list() { return facebooksFeedsPlnNerRepository.findAll(); }

    //PAGINACIÓN -> GET:
    public Slice<FacebooksFeedsPlnNer> listPage(Pageable pageable) {
        return facebooksFeedsPlnNerRepository.findAll(pageable);
    }

    //MÉTODO findByFacebooksFeedsId:
    public List<FacebooksFeedsPlnNer> findByFacebooksFeedsId(Long id) {
        return facebooksFeedsPlnNerRepository.findById_FacebooksFeedsId(id);
    }

}
