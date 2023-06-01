package com.atribus.Atribus.controller.twitter.twittersTweets;

import com.atribus.Atribus.entity.twitter.twittersTweets.TwittersTweetsStatistic;
import com.atribus.Atribus.service.twitter.twittersTweets.TwittersTweetsStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/twitterstweetsstatistics")
@CrossOrigin(origins = "*")
public class TwittersTweetsStatisticController {

    @Autowired
    TwittersTweetsStatisticService twittersTweetsStatisticService;

    //MOSTRAR TWITTERSTWEETSSTATISTICS -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<TwittersTweetsStatistic>> List() {
        List<TwittersTweetsStatistic> list = twittersTweetsStatisticService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<TwittersTweetsStatistic>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<TwittersTweetsStatistic> list = twittersTweetsStatisticService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
