package com.atribus.Atribus.service.twitter.twittersProfiles;

import com.atribus.Atribus.dao.twitter.twittersProfiles.TwittersProfilesFollowsWordsCloudBioRepository;
import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesFollowsWordsCloudBio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TwittersProfilesFollowsWordsCloudBioService {

    @Autowired
    TwittersProfilesFollowsWordsCloudBioRepository twittersProfilesFollowsWordsCloudBioRepository;

    //MOSTRAR TWITTERSPROFILESFOLLOWERSWORDSCLOUDBIO -> GET ALL (READ):
    public List<TwittersProfilesFollowsWordsCloudBio> list() {
        return twittersProfilesFollowsWordsCloudBioRepository.findAll();
    }

    //PAGINACIÓN -> GET:
    public Slice<TwittersProfilesFollowsWordsCloudBio> listPage(Pageable pageable) {
        return twittersProfilesFollowsWordsCloudBioRepository.findAll(pageable);
    }

    //MÉTODO findByDateCreated:
    public List<TwittersProfilesFollowsWordsCloudBio> findByDateCreated(Date dateCreated) {
        return twittersProfilesFollowsWordsCloudBioRepository.getById_DateCreated(dateCreated);
    }

    //MÉTODO findByCategoryIdDateCreated:
    public List<TwittersProfilesFollowsWordsCloudBio> findByCategoryIdAndDateCreated(int category, Date dateCreated) {
        return twittersProfilesFollowsWordsCloudBioRepository.getById_CategoryIdAndId_DateCreated(category, dateCreated);
    }

}
