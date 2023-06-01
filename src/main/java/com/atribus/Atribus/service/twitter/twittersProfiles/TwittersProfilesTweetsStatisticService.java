package com.atribus.Atribus.service.twitter.twittersProfiles;

import com.atribus.Atribus.dao.twitter.twittersProfiles.TwittersProfilesTweetsStatisticRepository;
import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesTweetsStatistic;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class TwittersProfilesTweetsStatisticService {

    @Autowired
    TwittersProfilesTweetsStatisticRepository twittersProfilesTweetsStatisticRepository;

    //MOSTRAR TWITTERSPROFILESTWEETSSTATISTICS -> GET ALL (READ):
    public List<TwittersProfilesTweetsStatistic> list() { return twittersProfilesTweetsStatisticRepository.findAll(); }

    //PAGINACIÓN -> GET:
    public Slice<TwittersProfilesTweetsStatistic> listPage(Pageable pageable) {
        return twittersProfilesTweetsStatisticRepository.findAll(pageable);
    }

    public List<TwittersProfilesTweetsStatistic> findByTwittersProfileTweetsId(Long id) {
        return twittersProfilesTweetsStatisticRepository.findByTwittersProfileTweetsId(id);
    }

}
