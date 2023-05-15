package com.atribus.Atribus.service;

import com.atribus.Atribus.dao.TwittersTweetsMaxIdRepository;
import com.atribus.Atribus.entity.TwittersTweet;
import com.atribus.Atribus.entity.TwittersTweetsMaxId;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TwittersTweetsMaxIdService {

    @Autowired
    TwittersTweetsMaxIdRepository twittersTweetsMaxIdRepository;

    //MOSTRAR TWITTERSTWEET -> GET ALL (READ):
    public List<TwittersTweetsMaxId> list() { return twittersTweetsMaxIdRepository.findAll(); }

    //PAGINACIÓN -> GET:
    public Slice<TwittersTweetsMaxId> listPage(Pageable pageable) {
        return twittersTweetsMaxIdRepository.findAll(pageable);
    }

}
