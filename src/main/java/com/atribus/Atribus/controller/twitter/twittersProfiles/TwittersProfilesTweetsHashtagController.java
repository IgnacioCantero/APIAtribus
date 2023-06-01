package com.atribus.Atribus.controller.twitter.twittersProfiles;

import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesTweetsHashtag;
import com.atribus.Atribus.service.twitter.twittersProfiles.TwittersProfilesTweetsHashtagsService;
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
@RequestMapping("/twittersprofilestweetshashtags")
@CrossOrigin(origins = "*")
public class TwittersProfilesTweetsHashtagController {

    @Autowired
    TwittersProfilesTweetsHashtagsService twittersProfilesTweetsHastagsService;

    //MOSTRAR TWITTERSPROFILESTWEETSHASHTAGS -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<TwittersProfilesTweetsHashtag>> List() {
        List<TwittersProfilesTweetsHashtag> list = twittersProfilesTweetsHastagsService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<TwittersProfilesTweetsHashtag>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<TwittersProfilesTweetsHashtag> list = twittersProfilesTweetsHastagsService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //MÉTODO findByCategoryIdAndDateCreated:
    @GetMapping("/listByCategoryAndDate")
    public ResponseEntity<List<TwittersProfilesTweetsHashtag>> listByCategoryAndDate(
            @RequestParam("category") int category,
            @RequestParam("dateCreated") Date dateCreated) {
        if (category == -1) {
            List<TwittersProfilesTweetsHashtag> tweets = twittersProfilesTweetsHastagsService.findByDateCreated(dateCreated);
            return new ResponseEntity<>(tweets, HttpStatus.OK);
        }
        List<TwittersProfilesTweetsHashtag> tweets = twittersProfilesTweetsHastagsService.findByCategoryIdAndDateCreated(category, dateCreated);
        return new ResponseEntity<>(tweets, HttpStatus.OK);
    }

}
