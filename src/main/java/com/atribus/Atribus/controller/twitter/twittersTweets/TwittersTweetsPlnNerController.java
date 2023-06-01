package com.atribus.Atribus.controller.twitter.twittersTweets;

import com.atribus.Atribus.entity.twitter.twittersTweets.TwittersTweetsPlnNer;
import com.atribus.Atribus.service.twitter.twittersTweets.TwittersTweetsPlnNerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/twitterstweetsplnner")
@CrossOrigin(origins = "*")
public class TwittersTweetsPlnNerController {

    @Autowired
    TwittersTweetsPlnNerService twittersTweetsPlnNerService;

    //MOSTRAR TWITTERSTWEETSPLNNER -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<TwittersTweetsPlnNer>> List() {
        List<TwittersTweetsPlnNer> list = twittersTweetsPlnNerService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<TwittersTweetsPlnNer>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<TwittersTweetsPlnNer> list = twittersTweetsPlnNerService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
