package com.atribus.Atribus.controller.twitter.twittersTweets;

import com.atribus.Atribus.entity.twitter.twittersTweets.TwittersTweetsTag;
import com.atribus.Atribus.service.twitter.twittersTweets.TwittersTweetsTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/twitterstweetstags")
@CrossOrigin(origins = "*")
public class TwittersTweetsTagController {

    @Autowired
    TwittersTweetsTagService twittersTweetsTagService;

    //MOSTRAR TWITTERSTWEETSTAG -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<TwittersTweetsTag>> List() {
        List<TwittersTweetsTag> list = twittersTweetsTagService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<TwittersTweetsTag>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<TwittersTweetsTag> list = twittersTweetsTagService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
