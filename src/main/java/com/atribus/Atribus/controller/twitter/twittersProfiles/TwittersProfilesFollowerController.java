package com.atribus.Atribus.controller.twitter.twittersProfiles;

import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesFollower;
import com.atribus.Atribus.service.twitter.twittersProfiles.TwittersProfilesFollowerService;
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
@RequestMapping("/twittersprofilesfollowers")
@CrossOrigin(origins = "*")
public class TwittersProfilesFollowerController {

    @Autowired
    TwittersProfilesFollowerService twittersProfilesFollowerService;

    //MOSTRAR TWITTERSPROFILESFOLLOWERS -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<TwittersProfilesFollower>> List() {
        List<TwittersProfilesFollower> list = twittersProfilesFollowerService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<TwittersProfilesFollower>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<TwittersProfilesFollower> list = twittersProfilesFollowerService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //MÉTODO findByCategoryIdAndDateCreated:
    @GetMapping("/listByCategoryAndDate")
    public ResponseEntity<List<TwittersProfilesFollower>> listByCategoryAndDate(
            @RequestParam("category") int category,
            @RequestParam("dateCreated") Date dateCreated) {
        if (category == -1) {
            List<TwittersProfilesFollower> tweets = twittersProfilesFollowerService.findByDateCreated(dateCreated);
            return new ResponseEntity<>(tweets, HttpStatus.OK);
        }
        List<TwittersProfilesFollower> tweets = twittersProfilesFollowerService.findByCategoryIdAndDateCreated(category, dateCreated);
        return new ResponseEntity<>(tweets, HttpStatus.OK);
    }

}
