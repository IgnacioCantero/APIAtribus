package com.atribus.Atribus.service.twitter.twittersProfiles;

import com.atribus.Atribus.dao.twitter.twittersProfiles.TwittersProfilesStatisticRepository;
import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesStatistic;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TwittersProfilesStatisticService {

    @Autowired
    TwittersProfilesStatisticRepository twittersProfilesStatisticRepository;

    //MOSTRAR TWITTERSPROFILESFOLLOWERSWORDSCLOUDBIO -> GET ALL (READ):
    public List<TwittersProfilesStatistic> list() {
        return twittersProfilesStatisticRepository.findAll();
    }

    //PAGINACIÓN -> GET:
    public Slice<TwittersProfilesStatistic> listPage(Pageable pageable) {
        return twittersProfilesStatisticRepository.findAll(pageable);
    }

    //MÉTODO findByDateCalculated:
    public List<TwittersProfilesStatistic> findByDateCalculated(Date dateCalculated) {
        return twittersProfilesStatisticRepository.getById_DateCalculated(dateCalculated);
    }

    //MÉTODO findByCategoryIdDateCalculated:
    public List<TwittersProfilesStatistic> findByCategoryIdAndDateCalculated(int category, Date dateCalculated) {
        return twittersProfilesStatisticRepository.getById_CategoryIdAndId_DateCalculated(category, dateCalculated);
    }

}
