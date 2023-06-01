package com.atribus.Atribus.controller.twitter.twittersProfiles;

import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesFollowersWordsCloudBio;
import com.atribus.Atribus.service.twitter.twittersProfiles.TwittersProfilesFollowersWordsCloudBioService;
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
@RequestMapping("/twittersprofilesfollowerswordscloudbio")
@CrossOrigin(origins = "*")
public class TwittersProfilesFollowersWordsCloudBioController {

    @Autowired
    TwittersProfilesFollowersWordsCloudBioService twittersProfilesFollowersWordsCloudBioService;

    //MOSTRAR TWITTERSPROFILESFOLLOWERSWORDSCLOUDBIO -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<TwittersProfilesFollowersWordsCloudBio>> List() {
        List<TwittersProfilesFollowersWordsCloudBio> list = twittersProfilesFollowersWordsCloudBioService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<TwittersProfilesFollowersWordsCloudBio>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<TwittersProfilesFollowersWordsCloudBio> list = twittersProfilesFollowersWordsCloudBioService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //MÉTODO findByCategoryIdAndDateCreated:
    @GetMapping("/listByCategoryAndDate")
    public ResponseEntity<List<TwittersProfilesFollowersWordsCloudBio>> listByCategoryAndDate(
            @RequestParam("category") int category,
            @RequestParam("dateCreated") Date dateCreated) {
        if (category == -1) {
            List<TwittersProfilesFollowersWordsCloudBio> tweets = twittersProfilesFollowersWordsCloudBioService.findByDateCreated(dateCreated);
            return new ResponseEntity<>(tweets, HttpStatus.OK);
        }
        List<TwittersProfilesFollowersWordsCloudBio> tweets = twittersProfilesFollowersWordsCloudBioService.findByCategoryIdAndDateCreated(category, dateCreated);
        return new ResponseEntity<>(tweets, HttpStatus.OK);
    }

}
