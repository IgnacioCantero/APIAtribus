package com.atribus.Atribus.service.twitter.twittersProfiles;

import com.atribus.Atribus.dao.twitter.twittersProfiles.TwittersProfilesTweetsUrlRepository;
import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesTweetsHashtag;
import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesTweetsUrl;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class TwittersProfilesTweetsUrlService {

    @Autowired
    TwittersProfilesTweetsUrlRepository twittersProfilesTweetsUrlRepository;

    //MOSTRAR TWITTERSPROFILESTWEETSURLS -> GET ALL (READ):
    public List<TwittersProfilesTweetsUrl> list() { return twittersProfilesTweetsUrlRepository.findAll(); }

    //PAGINACIÓN -> GET:
    public Slice<TwittersProfilesTweetsUrl> listPage(Pageable pageable) {
        return twittersProfilesTweetsUrlRepository.findAll(pageable);
    }

    public List<TwittersProfilesTweetsUrl> findByTwittersProfileTweetsId(Long id) {
        return twittersProfilesTweetsUrlRepository.findById_TwittersProfileTweetsId(id);
    }

}
