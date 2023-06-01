package com.atribus.Atribus.service.twitter.twittersTweets;

import com.atribus.Atribus.dao.twitter.twittersTweets.TwittersUserRepository;
import com.atribus.Atribus.entity.twitter.twittersTweets.TwittersUser;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TwittersUserService {

    @Autowired
    TwittersUserRepository twittersUserRepository;

    //MOSTRAR TWITTERSUSER -> GET ALL (READ):
    public List<TwittersUser> list() { return twittersUserRepository.findAll(); }

    //PAGINACIÓN -> GET:
    public Slice<TwittersUser> listPage(Pageable pageable) {
        return twittersUserRepository.findAll(pageable);
    }

}
