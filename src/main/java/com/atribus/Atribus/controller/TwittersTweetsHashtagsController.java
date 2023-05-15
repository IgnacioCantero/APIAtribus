package com.atribus.Atribus.controller;

import com.atribus.Atribus.entity.TwittersTweet;
import com.atribus.Atribus.entity.TwittersTweetsHashtag;
import com.atribus.Atribus.service.TwittersTweetsHashtagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/twitterstweetshashtags")
@CrossOrigin(origins = "*")
public class TwittersTweetsHashtagsController {

    @Autowired
    TwittersTweetsHashtagService twittersTweetsHashtagService;

    //MOSTRAR TWITTERSTWEETSHASTAGS -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<TwittersTweetsHashtag>> List() {
        List<TwittersTweetsHashtag> list = twittersTweetsHashtagService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<TwittersTweetsHashtag>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<TwittersTweetsHashtag> list = twittersTweetsHashtagService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
