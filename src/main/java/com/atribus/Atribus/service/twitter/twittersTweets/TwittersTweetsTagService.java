package com.atribus.Atribus.service.twitter.twittersTweets;

import com.atribus.Atribus.dao.twitter.twittersTweets.TwittersTweetsTagRepository;
import com.atribus.Atribus.entity.twitter.twittersTweets.TwittersTweetsTag;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TwittersTweetsTagService {

    @Autowired
    TwittersTweetsTagRepository twittersTweetsTagRepository;

    //MOSTRAR TWITTERSTWEETSTAG -> GET ALL (READ):
    public List<TwittersTweetsTag> list() { return twittersTweetsTagRepository.findAll(); }

    //PAGINACIÓN -> GET:
    public Slice<TwittersTweetsTag> listPage(Pageable pageable) {
        return twittersTweetsTagRepository.findAll(pageable);
    }

}
