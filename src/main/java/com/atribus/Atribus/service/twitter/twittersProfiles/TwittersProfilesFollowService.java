package com.atribus.Atribus.service.twitter.twittersProfiles;

import com.atribus.Atribus.dao.twitter.twittersProfiles.TwittersProfilesFollowRepository;
import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesFollow;
import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesFollower;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TwittersProfilesFollowService {

    @Autowired
    TwittersProfilesFollowRepository twittersProfilesFollowRepository;

    //MOSTRAR TWITTERSPROFILESFOLLOWS -> GET ALL (READ):
    public List<TwittersProfilesFollow> list() { return twittersProfilesFollowRepository.findAll(); }

    //PAGINACIÓN -> GET:
    public Slice<TwittersProfilesFollow> listPage(Pageable pageable) {
        return twittersProfilesFollowRepository.findAll(pageable);
    }

    public List<TwittersProfilesFollow> findByDateCreated(Date dateCreated) {
        return twittersProfilesFollowRepository.findByDateCreated(dateCreated);
    }

    public List<TwittersProfilesFollow> findByCategoryIdAndDateCreated(int category, Date dateCreated) {
        return twittersProfilesFollowRepository.findById_CategoryIdAndDateCreated(category, dateCreated);
    }

}
