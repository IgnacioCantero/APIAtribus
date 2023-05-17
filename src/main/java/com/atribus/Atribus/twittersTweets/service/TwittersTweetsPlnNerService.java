package com.atribus.Atribus.twittersTweets.service;

import com.atribus.Atribus.twittersTweets.dao.TwittersTweetsPlnNerRepository;
import com.atribus.Atribus.twittersTweets.entity.TwittersTweetsPlnNer;
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
