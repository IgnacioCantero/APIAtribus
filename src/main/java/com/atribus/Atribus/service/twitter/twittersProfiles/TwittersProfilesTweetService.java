package com.atribus.Atribus.service.twitter.twittersProfiles;

import com.atribus.Atribus.dao.twitter.twittersProfiles.TwittersProfilesTweetRepository;
import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesTweet;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TwittersProfilesTweetService {

    @Autowired
    TwittersProfilesTweetRepository twittersProfilesTweetRepository;

    //MOSTRAR TWITTERSPROFILESTWEETS -> GET ALL (READ):
    public List<TwittersProfilesTweet> list() { return twittersProfilesTweetRepository.findAll(); }

    //PAGINACIÓN -> GET:
    public Slice<TwittersProfilesTweet> listPage(Pageable pageable) {
        return twittersProfilesTweetRepository.findAll(pageable);
    }

    public List<TwittersProfilesTweet> findByDateCreated(Date dateCreated) {
        return twittersProfilesTweetRepository.findByDateCreated(dateCreated);
    }

    public List<TwittersProfilesTweet> findByCategoryIdAndDateCreated(int category, Date dateCreated) {
        return twittersProfilesTweetRepository.findById_CategoryIdAndDateCreated(category, dateCreated);
    }

}
