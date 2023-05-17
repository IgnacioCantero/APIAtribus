package com.atribus.Atribus.twittersTweets.service;

import com.atribus.Atribus.twittersTweets.dao.TwittersUserRepository;
import com.atribus.Atribus.twittersTweets.entity.TwittersUser;
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
