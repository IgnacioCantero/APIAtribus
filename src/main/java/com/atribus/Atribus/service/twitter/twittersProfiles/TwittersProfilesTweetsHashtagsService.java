package com.atribus.Atribus.service.twitter.twittersProfiles;

import com.atribus.Atribus.dao.twitter.twittersProfiles.TwittersProfilesTweetsHashtagRepository;
import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesTweetsHashtag;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TwittersProfilesTweetsHashtagsService {

    @Autowired
    TwittersProfilesTweetsHashtagRepository twittersProfilesTweetsHastagRepository;

    //MOSTRAR TWITTERSPROFILESTWEETSHASHTAGS -> GET ALL (READ):
    public List<TwittersProfilesTweetsHashtag> list() { return twittersProfilesTweetsHastagRepository.findAll(); }

    //PAGINACIÓN -> GET:
    public Slice<TwittersProfilesTweetsHashtag> listPage(Pageable pageable) {
        return twittersProfilesTweetsHastagRepository.findAll(pageable);
    }

    public List<TwittersProfilesTweetsHashtag> findByDateCreated(Date dateCreated) {
        return twittersProfilesTweetsHastagRepository.findByDateCreated(dateCreated);
    }

    public List<TwittersProfilesTweetsHashtag> findByCategoryIdAndDateCreated(int category, Date dateCreated) {
        return twittersProfilesTweetsHastagRepository.findById_CategoryIdAndDateCreated(category, dateCreated);
    }

}
