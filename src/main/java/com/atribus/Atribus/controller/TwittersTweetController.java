package com.atribus.Atribus.controller;

import com.atribus.Atribus.entity.TwittersTweet;
import com.atribus.Atribus.service.TwittersTweetService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/twitterstweets")
@CrossOrigin(origins = "*")
public class TwittersTweetController {

    @Autowired
    TwittersTweetService twittersTweetService;

    //MOSTRAR TWITTERSTWEET -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<TwittersTweet>> List() {
        List<TwittersTweet> list = twittersTweetService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<TwittersTweet>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<TwittersTweet> list = twittersTweetService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //MÉTODO findByCategoryIdAndSearchIdAndDateCreated:
    @GetMapping("/listByCategoryAndSearchAndDate")
    public ResponseEntity<List<TwittersTweet>> listByCategoryAndSearchAndDate(
            @RequestParam("category") int category,
            @RequestParam("search") int search,
            @RequestParam("dateCreated") Date dateCreated) {
        if (category == -1 && search != -1) {
            List<TwittersTweet> tweets = twittersTweetService.findBySearchAndDateCreated(search, dateCreated);
            return new ResponseEntity<>(tweets, HttpStatus.OK);
        }
        if (search == -1 && category != -1) {
            List<TwittersTweet> tweets = twittersTweetService.findByCategoryIdAndDateCreated(category, dateCreated);
            return new ResponseEntity<>(tweets, HttpStatus.OK);
        } else if (category == -1) {
            List<TwittersTweet> tweets = twittersTweetService.findByDateCreated(dateCreated);
            return new ResponseEntity<>(tweets, HttpStatus.OK);
        }
        List<TwittersTweet> tweets = twittersTweetService.findByCategoryIdAndSearchAndDateCreated(category, search, dateCreated);
        return new ResponseEntity<>(tweets, HttpStatus.OK);
    }

}
