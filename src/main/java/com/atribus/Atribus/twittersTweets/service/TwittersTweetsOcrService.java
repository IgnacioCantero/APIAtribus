package com.atribus.Atribus.twittersTweets.service;

import com.atribus.Atribus.twittersTweets.dao.TwittersTweetsOcrRepository;
import com.atribus.Atribus.twittersTweets.entity.TwittersTweetsOcr;
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
