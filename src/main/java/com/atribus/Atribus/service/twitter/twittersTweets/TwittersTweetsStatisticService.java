package com.atribus.Atribus.service.twitter.twittersTweets;

import com.atribus.Atribus.dao.twitter.twittersTweets.TwittersTweetsStatisticRepository;
import com.atribus.Atribus.entity.twitter.twittersTweets.TwittersTweetsStatistic;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TwittersTweetsStatisticService {

    @Autowired
    TwittersTweetsStatisticRepository twittersTweetsStatisticRepository;

    //MOSTRAR TWITTERSTWEETSSTATISCTIC -> GET ALL (READ):
    public List<TwittersTweetsStatistic> list() { return twittersTweetsStatisticRepository.findAll(); }

    //PAGINACIÓN -> GET:
    public Slice<TwittersTweetsStatistic> listPage(Pageable pageable) {
        return twittersTweetsStatisticRepository.findAll(pageable);
    }

}
