package com.atribus.Atribus.service.twitter.twittersTweets;

import com.atribus.Atribus.dao.twitter.twittersTweets.TwittersTweetsOcrRepository;
import com.atribus.Atribus.entity.twitter.twittersTweets.TwittersTweetsOcr;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TwittersTweetsOcrService {

    @Autowired
    TwittersTweetsOcrRepository twittersTweetsOcrRepository;

    //MOSTRAR TWITTERSTWEET -> GET ALL (READ):
    public List<TwittersTweetsOcr> list() { return twittersTweetsOcrRepository.findAll(); }

    //PAGINACIÓN -> GET:
    public Slice<TwittersTweetsOcr> listPage(Pageable pageable) {
        return twittersTweetsOcrRepository.findAll(pageable);
    }

}
