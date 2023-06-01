package com.atribus.Atribus.controller.twitter.twittersProfiles;

import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesTweetsHashtag;
import com.atribus.Atribus.entity.twitter.twittersProfiles.TwittersProfilesTweetsTag;
import com.atribus.Atribus.service.twitter.twittersProfiles.TwittersProfilesTweetsTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/twittersprofilestweetstags")
@CrossOrigin(origins = "*")
public class TwittersProfilesTweetsTagController {

    @Autowired
    TwittersProfilesTweetsTagService twittersProfilesTweetsTagService;

    //MOSTRAR TWITTERSPROFILESTWEETSTAGS -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<TwittersProfilesTweetsTag>> List() {
        List<TwittersProfilesTweetsTag> list = twittersProfilesTweetsTagService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<TwittersProfilesTweetsTag>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<TwittersProfilesTweetsTag> list = twittersProfilesTweetsTagService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //MÉTODO findByTwittersProfileTweetsId:
    @GetMapping("/listByTwittersProfilesTweetsId")
    public ResponseEntity<List<TwittersProfilesTweetsTag>> twittersprofilestweetstags(
            @RequestParam("id") Long id){
        List<TwittersProfilesTweetsTag> tweets = twittersProfilesTweetsTagService.findByTwittersProfileTweetsId(id);
        return new ResponseEntity<>(tweets, HttpStatus.OK);
    }

}
