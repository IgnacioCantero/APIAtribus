package com.atribus.Atribus.controller;

import com.atribus.Atribus.entity.TwittersTweet;
import com.atribus.Atribus.entity.TwittersTweetsMaxId;
import com.atribus.Atribus.service.TwittersTweetsMaxIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/twitterstweetsmaxid")
@CrossOrigin(origins = "*")
public class TwittersTweetsMaxIdController {

    @Autowired
    TwittersTweetsMaxIdService twittersTweetsMaxIdService;

    //MOSTRAR TWITTERSTWEETSMAXID -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<TwittersTweetsMaxId>> List() {
        List<TwittersTweetsMaxId> list = twittersTweetsMaxIdService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<TwittersTweetsMaxId>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<TwittersTweetsMaxId> list = twittersTweetsMaxIdService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
