package com.atribus.Atribus.controller.twitter.twittersProfiles;

import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesTweet;
import com.atribus.Atribus.service.twitter.twittersProfiles.TwittersProfilesTweetService;
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
@RequestMapping("/twittersprofilestweets")
@CrossOrigin(origins = "*")
public class TwittersProfilesTweetController {

    @Autowired
    TwittersProfilesTweetService twittersProfilesTweetService;

    //MOSTRAR TWITTERSPROFILESTWEETS -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<TwittersProfilesTweet>> List() {
        List<TwittersProfilesTweet> list = twittersProfilesTweetService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<TwittersProfilesTweet>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<TwittersProfilesTweet> list = twittersProfilesTweetService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //MÉTODO findByCategoryIdAndDateCreated:
    //todo -> REVISAR POR QUÉ NO LA TIRA!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @GetMapping("/listByCategoryAndDate")
    public ResponseEntity<List<TwittersProfilesTweet>> listByCategoryAndDate(
            @RequestParam("category") int category,
            @RequestParam("dateCreated") long dateCreatedMil) {

        Date dateCreated = new Date(dateCreatedMil * 1000);

        if (category == -1) {
            List<TwittersProfilesTweet> tweets = twittersProfilesTweetService.findByDateCreated(dateCreated);
            return new ResponseEntity<>(tweets, HttpStatus.OK);
        }
        List<TwittersProfilesTweet> tweets = twittersProfilesTweetService.findByCategoryIdAndDateCreated(category, dateCreated);
        return new ResponseEntity<>(tweets, HttpStatus.OK);
    }

}
