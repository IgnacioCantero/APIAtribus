package com.atribus.Atribus.controller.twitter.twittersProfiles;

import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesFollowsWordsCloudBio;
import com.atribus.Atribus.service.twitter.twittersProfiles.TwittersProfilesFollowsWordsCloudBioService;
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
@RequestMapping("/twittersprofilesfollowswordscloudbio")
@CrossOrigin(origins = "*")
public class TwittersProfilesFollowsWordsCloudBioController {

    @Autowired
    TwittersProfilesFollowsWordsCloudBioService twittersProfilesFollowsWordsCloudBioService;

    //MOSTRAR TWITTERSPROFILESFOLLOWERSWORDSCLOUDBIO -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<TwittersProfilesFollowsWordsCloudBio>> List() {
        List<TwittersProfilesFollowsWordsCloudBio> list = twittersProfilesFollowsWordsCloudBioService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<TwittersProfilesFollowsWordsCloudBio>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<TwittersProfilesFollowsWordsCloudBio> list = twittersProfilesFollowsWordsCloudBioService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //MÉTODO findByCategoryIdAndDateCreated:
    @GetMapping("/listByCategoryAndDate")
    public ResponseEntity<List<TwittersProfilesFollowsWordsCloudBio>> listByCategoryAndDate(
            @RequestParam("category") int category,
            @RequestParam("dateCreated") Date dateCreated) {
        if (category == -1) {
            List<TwittersProfilesFollowsWordsCloudBio> tweets = twittersProfilesFollowsWordsCloudBioService.findByDateCreated(dateCreated);
            return new ResponseEntity<>(tweets, HttpStatus.OK);
        }
        List<TwittersProfilesFollowsWordsCloudBio> tweets = twittersProfilesFollowsWordsCloudBioService.findByCategoryIdAndDateCreated(category, dateCreated);
        return new ResponseEntity<>(tweets, HttpStatus.OK);
    }

}
