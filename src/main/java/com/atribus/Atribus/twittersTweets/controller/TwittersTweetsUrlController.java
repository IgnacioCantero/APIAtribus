package com.atribus.Atribus.twittersTweets.controller;

import com.atribus.Atribus.twittersTweets.entity.TwittersTweetsUrl;
import com.atribus.Atribus.twittersTweets.service.TwittersTweetsUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/twitterstweetsurls")
@CrossOrigin(origins = "*")
public class TwittersTweetsUrlController {

    @Autowired
    TwittersTweetsUrlService twittersTweetsUrlService;

    //MOSTRAR TWITTERSTWEETSURL -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<TwittersTweetsUrl>> List() {
        List<TwittersTweetsUrl> list = twittersTweetsUrlService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<TwittersTweetsUrl>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<TwittersTweetsUrl> list = twittersTweetsUrlService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
