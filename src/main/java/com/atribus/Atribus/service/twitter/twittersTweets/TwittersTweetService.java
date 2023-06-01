package com.atribus.Atribus.service.twitter.twittersTweets;

import com.atribus.Atribus.dao.twitter.twittersTweets.TwittersTweetRepository;
import com.atribus.Atribus.entity.twitter.twittersTweets.TwittersTweet;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TwittersTweetService {

    @Autowired
    TwittersTweetRepository twittersTweetRepository;

    //MOSTRAR TWITTERSTWEET -> GET ALL (READ):
    public List<TwittersTweet> list() { return twittersTweetRepository.findAll(); }

    //PAGINACIÓN -> GET:
    public Slice<TwittersTweet> listPage(Pageable pageable) {
        return twittersTweetRepository.findAll(pageable);
    }

    //MÉTODO findBySearchIdAndDateCreated:
    public List<TwittersTweet> findBySearchAndDateCreated(int search, Date dateCreated) {
        return twittersTweetRepository.findBySearchsSearchIdAndDateCreated(search, dateCreated);
    }

    //MÉTODO findByCategoryIdAndDateCreated:
    public List<TwittersTweet> findByCategoryIdAndDateCreated(int category, Date dateCreated) {
        return twittersTweetRepository.findByCategoriesCategoryIdAndDateCreated(category, dateCreated);
    }

    //MÉTODO findByDateCreated:
    public List<TwittersTweet> findByDateCreated(Date dateCreated) {
        return twittersTweetRepository.findByDateCreated(dateCreated);
    }

    //MÉTODO findByCategoryIdAndSearchIdAndDateCreated:
    public List<TwittersTweet> findByCategoryIdAndSearchAndDateCreated(int category, int search, Date dateCreated) {
        return twittersTweetRepository.findByCategoriesCategoryIdAndSearchsSearchIdAndDateCreated(category, search, dateCreated);
    }
}
