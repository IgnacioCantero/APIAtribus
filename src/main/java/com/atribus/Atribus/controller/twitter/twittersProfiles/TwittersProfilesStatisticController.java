package com.atribus.Atribus.controller.twitter.twittersProfiles;

import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesStatistic;
import com.atribus.Atribus.service.twitter.twittersProfiles.TwittersProfilesStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/twittersprofilesstatistics")
@CrossOrigin(origins = "*")
public class TwittersProfilesStatisticController {

    @Autowired
    TwittersProfilesStatisticService twittersProfilesStatisticService;

    //MOSTRAR TWITTERSPROFILESFOLLOWERSWORDSCLOUDBIO -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<TwittersProfilesStatistic>> List() {
        List<TwittersProfilesStatistic> list = twittersProfilesStatisticService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<TwittersProfilesStatistic>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<TwittersProfilesStatistic> list = twittersProfilesStatisticService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //MÉTODO findByCategoryIdAndDateCalculated:
    @GetMapping("/listByCategoryAndDate")
    public ResponseEntity<List<TwittersProfilesStatistic>> listByCategoryAndDate(
            @RequestParam("category") int category,
            @RequestParam("dateCalculated") Date dateCalculated) {
        if (category == -1) {
            List<TwittersProfilesStatistic> tweets = twittersProfilesStatisticService.findByDateCalculated(dateCalculated);
            return new ResponseEntity<>(tweets, HttpStatus.OK);
        }
        List<TwittersProfilesStatistic> tweets = twittersProfilesStatisticService.findByCategoryIdAndDateCalculated(category, dateCalculated);
        return new ResponseEntity<>(tweets, HttpStatus.OK);
    }

}
