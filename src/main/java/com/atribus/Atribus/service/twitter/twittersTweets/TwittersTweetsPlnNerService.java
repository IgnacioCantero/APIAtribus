package com.atribus.Atribus.service.twitter.twittersTweets;

import com.atribus.Atribus.dao.twitter.twittersTweets.TwittersTweetsPlnNerRepository;
import com.atribus.Atribus.entity.twitter.twittersTweets.TwittersTweetsPlnNer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TwittersTweetsPlnNerService {

    @Autowired
    TwittersTweetsPlnNerRepository twittersTweetsPlnNerRepository;

    //MOSTRAR TWITTERSTWEETSPLNNER -> GET ALL (READ):
    public List<TwittersTweetsPlnNer> list() { return twittersTweetsPlnNerRepository.findAll(); }

    //PAGINACIÓN -> GET:
    public Slice<TwittersTweetsPlnNer> listPage(Pageable pageable) {
        return twittersTweetsPlnNerRepository.findAll(pageable);
    }

}
