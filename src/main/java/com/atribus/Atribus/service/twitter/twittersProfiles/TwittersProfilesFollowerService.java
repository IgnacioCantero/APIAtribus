package com.atribus.Atribus.service.twitter.twittersProfiles;

import com.atribus.Atribus.dao.twitter.twittersProfiles.TwittersProfilesFollowerRepository;
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
public class TwittersProfilesFollowerService {

    @Autowired
    TwittersProfilesFollowerRepository twittersProfilesFollowerRepository;

    //MOSTRAR TWITTERSPROFILESFOLLOWERS -> GET ALL (READ):
    public List<TwittersProfilesFollower> list() { return twittersProfilesFollowerRepository.findAll(); }

    //PAGINACIÓN -> GET:
    public Slice<TwittersProfilesFollower> listPage(Pageable pageable) {
        return twittersProfilesFollowerRepository.findAll(pageable);
    }

    public List<TwittersProfilesFollower> findByDateCreated(Date dateCreated) {
        return twittersProfilesFollowerRepository.findByDateCreated(dateCreated);
    }

    public List<TwittersProfilesFollower> findByCategoryIdAndDateCreated(int category, Date dateCreated) {
        return twittersProfilesFollowerRepository.findById_CategoryIdAndDateCreated(category, dateCreated);
    }

}
