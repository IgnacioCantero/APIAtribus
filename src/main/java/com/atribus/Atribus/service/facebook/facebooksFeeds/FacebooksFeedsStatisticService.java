package com.atribus.Atribus.service.facebook.facebooksFeeds;

import com.atribus.Atribus.dao.facebook.facebooksFeeds.FacebooksFeedsStatisticRepository;
import com.atribus.Atribus.entity.facebook.facebooksFeeds.FacebooksFeedsStatistic;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class FacebooksFeedsStatisticService {

    @Autowired
    FacebooksFeedsStatisticRepository facebooksFeedsStatisticRepository;

    //MOSTRAR FACEBOOKSFEEDSSTATISTIC -> GET ALL (READ):
    public List<FacebooksFeedsStatistic> list() { return facebooksFeedsStatisticRepository.findAll(); }

    //PAGINACIÓN -> GET:
    public Slice<FacebooksFeedsStatistic> listPage(Pageable pageable) {
        return facebooksFeedsStatisticRepository.findAll(pageable);
    }

    //MÉTODO findByFacebooksFeedsId:
    public List<FacebooksFeedsStatistic> findByFacebooksFeedsId(Long facebooksFeedsId) {
        return facebooksFeedsStatisticRepository.findByFacebooksFeedsId(facebooksFeedsId);
    }

}
