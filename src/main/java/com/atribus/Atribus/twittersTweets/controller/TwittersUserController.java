package com.atribus.Atribus.twittersTweets.controller;

import com.atribus.Atribus.twittersTweets.entity.TwittersUser;
import com.atribus.Atribus.twittersTweets.service.TwittersUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/twittersusers")
@CrossOrigin(origins = "*")
public class TwittersUserController {
    @Autowired
    TwittersUserService twittersUserService;

    //MOSTRAR TWITTERSUSER -> GET ALL (READ):
    @GetMapping("/list")
    public ResponseEntity<List<TwittersUser>> List() {
        List<TwittersUser> list = twittersUserService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    //PAGINACIÓN -> GET:
    @GetMapping("/list/pagina={page}&resultadosporpagina={size}")
    public ResponseEntity<Slice<TwittersUser>> ListPage(@PathVariable("page") int page, @PathVariable("size") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Slice<TwittersUser> list = twittersUserService.listPage(pageable);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
