package com.atribus.Atribus.twittersTweets.service;

import com.atribus.Atribus.twittersTweets.dao.TwittersTweetsHashtagRepository;
import com.atribus.Atribus.twittersTweets.entity.TwittersTweetsHashtag;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TwittersTweetsHashtagService {

    @Autowired
    TwittersTweetsHashtagRepository twittersTweetsHashtagRepository;

    //MOSTRAR TWITTERSTWEET -> GET ALL (READ):
    public List<TwittersTweetsHashtag> list() { return twittersTweetsHashtagRepository.findAll(); }

    //PAGINACIÓN -> GET:
    public Slice<TwittersTweetsHashtag> listPage(Pageable pageable) {
        return twittersTweetsHashtagRepository.findAll(pageable);
    }

}
