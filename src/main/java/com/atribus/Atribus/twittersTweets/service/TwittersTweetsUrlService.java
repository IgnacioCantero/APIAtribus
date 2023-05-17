package com.atribus.Atribus.twittersTweets.service;

import com.atribus.Atribus.twittersTweets.dao.TwittersTweetsUrlRepository;
import com.atribus.Atribus.twittersTweets.entity.TwittersTweetsUrl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TwittersTweetsUrlService {

    @Autowired
    TwittersTweetsUrlRepository twittersTweetsUrlRepository;

    //MOSTRAR TWITTERSTWEETSURL -> GET ALL (READ):
    public List<TwittersTweetsUrl> list() { return twittersTweetsUrlRepository.findAll(); }

    //PAGINACIÓN -> GET:
    public Slice<TwittersTweetsUrl> listPage(Pageable pageable) {
        return twittersTweetsUrlRepository.findAll(pageable);
    }
}
