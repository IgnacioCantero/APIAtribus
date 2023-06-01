package com.atribus.Atribus.service.twitter.twittersProfiles;

import com.atribus.Atribus.dao.twitter.twittersProfiles.TwittersProfilesUserRepository;
import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesUser;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TwittersProfilesUserService {

    @Autowired
    TwittersProfilesUserRepository twittersProfilesUserRepository;


    //MOSTRAR TWITTERSPROFILESTWEETS -> GET ALL (READ):
    public List<TwittersProfilesUser> list() { return twittersProfilesUserRepository.findAll(); }

    //PAGINACIÓN -> GET:
    public Slice<TwittersProfilesUser> listPage(Pageable pageable) {
        return twittersProfilesUserRepository.findAll(pageable);
    }

    public List<TwittersProfilesUser> findByDateCreated(Date dateCreated) {
        return twittersProfilesUserRepository.findByDateCreated(dateCreated);
    }

    public List<TwittersProfilesUser> findByTwittersProfileUsersId(Long id) {
        return twittersProfilesUserRepository.findByTwittersProfileUsersId(id);
    }


}
