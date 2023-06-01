package com.atribus.Atribus.service.twitter.twittersProfiles;

import com.atribus.Atribus.dao.twitter.twittersProfiles.TwittersProfilesFollowersWordsCloudBioRepository;
import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesFollowersWordsCloudBio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TwittersProfilesFollowersWordsCloudBioService {

    @Autowired
    TwittersProfilesFollowersWordsCloudBioRepository twittersProfilesFollowersWordsCloudBioRepository;

    //MOSTRAR TWITTERSPROFILESFOLLOWERSWORDSCLOUDBIO -> GET ALL (READ):
    public List<TwittersProfilesFollowersWordsCloudBio> list() {
        return twittersProfilesFollowersWordsCloudBioRepository.findAll();
    }

    //PAGINACIÓN -> GET:
    public Slice<TwittersProfilesFollowersWordsCloudBio> listPage(Pageable pageable) {
        return twittersProfilesFollowersWordsCloudBioRepository.findAll(pageable);
    }

    //MÉTODO findByDateCreated:
    public List<TwittersProfilesFollowersWordsCloudBio> findByDateCreated(Date dateCreated) {
        return twittersProfilesFollowersWordsCloudBioRepository.getById_DateCreated(dateCreated);
    }

    //MÉTODO findByCategoryIdDateCreated:
    public List<TwittersProfilesFollowersWordsCloudBio> findByCategoryIdAndDateCreated(int category, Date dateCreated) {
        return twittersProfilesFollowersWordsCloudBioRepository.getById_CategoryIdAndId_DateCreated(category, dateCreated);
    }

}
