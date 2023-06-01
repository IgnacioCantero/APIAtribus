package com.atribus.Atribus.service.twitter.twittersProfiles;

import com.atribus.Atribus.dao.twitter.twittersProfiles.TwittersProfilesTweetsTagRepository;
import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesTweetsHashtag;
import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesTweetsTag;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TwittersProfilesTweetsTagService {

    @Autowired
    TwittersProfilesTweetsTagRepository twittersProfilesTweetsTagRepository;

    //MOSTRAR TWITTERSPROFILESTWEETSTAGS -> GET ALL (READ):
    public List<TwittersProfilesTweetsTag> list() { return twittersProfilesTweetsTagRepository.findAll(); }

    //PAGINACIÓN -> GET:
    public Slice<TwittersProfilesTweetsTag> listPage(Pageable pageable) {
        return twittersProfilesTweetsTagRepository.findAll(pageable);
    }

    public List<TwittersProfilesTweetsTag> findByTwittersProfileTweetsId(Long id) {
        return twittersProfilesTweetsTagRepository.findById_TwittersProfileTweetsId(id);
    }

}
