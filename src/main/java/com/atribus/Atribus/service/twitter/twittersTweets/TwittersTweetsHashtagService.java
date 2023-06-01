package com.atribus.Atribus.service.twitter.twittersTweets;

import com.atribus.Atribus.dao.twitter.twittersTweets.TwittersTweetsHashtagRepository;
import com.atribus.Atribus.entity.twitter.twittersTweets.TwittersTweetsHashtag;
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

    //MOSTRAR TWITTERSTWEETSHASTAGS -> GET ALL (READ):
    public List<TwittersTweetsHashtag> list() { return twittersTweetsHashtagRepository.findAll(); }

    //PAGINACIÓN -> GET:
    public Slice<TwittersTweetsHashtag> listPage(Pageable pageable) {
        return twittersTweetsHashtagRepository.findAll(pageable);
    }

}
