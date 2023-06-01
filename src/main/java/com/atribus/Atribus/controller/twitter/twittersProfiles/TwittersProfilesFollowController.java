package com.atribus.Atribus.controller.twitter.twittersProfiles;

import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesFollow;
import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesFollower;
import com.atribus.Atribus.service.twitter.twittersProfiles.TwittersProfilesFollowService;
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
@RequestMapping("/twittersprofilesfollows")
@CrossOrigin(origins = "*")
public class TwittersProfilesFollowController {

    @Autowired
    TwittersProfilesFollowService twittersProfilesFollowService;

    //MOSTRAR TWITTERSPROFILESFOLLOWERS -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<TwittersProfilesFollow>> List() {
        List<TwittersProfilesFollow> list = twittersProfilesFollowService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<TwittersProfilesFollow>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<TwittersProfilesFollow> list = twittersProfilesFollowService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //MÉTODO findByCategoryIdAndSearchIdAndDateCreated:
    @GetMapping("/listByCategoryAndDate")
    public ResponseEntity<List<TwittersProfilesFollow>> listByCategoryAndDate(
            @RequestParam("category") int category,
            @RequestParam("dateCreated") Date dateCreated) {
        if (category == -1) {
            List<TwittersProfilesFollow> tweets = twittersProfilesFollowService.findByDateCreated(dateCreated);
            return new ResponseEntity<>(tweets, HttpStatus.OK);
        }
        List<TwittersProfilesFollow> tweets = twittersProfilesFollowService.findByCategoryIdAndDateCreated(category, dateCreated);
        return new ResponseEntity<>(tweets, HttpStatus.OK);
    }

}
